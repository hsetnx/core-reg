package com.lefinance.common.utils.threadpool;

import com.lefinance.common.utils.CommonUtil;

import java.util.concurrent.*;

/**
 * @Author: Jingyan
 * @Time: 2017-12-04 11:39
 * @Description:
 */
public class ThreadPoolUtils {
    //线程池核心线程数
    private static int CORE_POOL_SIZE = 4;
    //线程池最大线程数
    private static int MAX_POOL_SIZE = 8;
    //额外线程空状态生存时间 10S
    private static int KEEP_ALIVE_TIME = 10000;
    //无解阻塞队列。当核心线程都被占用，且阻塞队列已满的情况下，才会开启额外线程。
    private static BlockingQueue workQueue = new LinkedBlockingQueue();
    //线程池
    private static ThreadPoolExecutor threadPool;
    //线程工厂
    private static ThreadFactory threadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, CommonUtil.getUUIDWithoutSeparator());
        }
    };

    static {
        threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, workQueue, threadFactory);
    }

    private ThreadPoolUtils() {
    }

    public static void execute(Runnable runnable) {
        threadPool.execute(runnable);
    }

    public static void execute(FutureTask futureTask) {
        threadPool.execute(futureTask);
    }

    public static void cancel(FutureTask futureTask) {
        futureTask.cancel(true);
    }
}