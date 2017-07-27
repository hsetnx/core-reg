package com.lefinance.test;

import com.lefinance.Application;
import com.lefinance.config.redis.RedisTools;
import com.lefinance.regulation.dao.RegCqContractInfoMapper;
import com.lefinance.regulation.service.AcctCreateKeyService;
import com.lefinance.regulation.service.PTLN102Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author: jingyan
 * @Time: 2017/6/27 16:10
 * @Describe:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= Application.class)
public class TestData {
    @Resource
    private RegCqContractInfoMapper regCqContractInfoMapper;
    @Resource
    private RedisTools redisTools;

    @Resource
    @Qualifier("ptln102Service")
    private PTLN102Service ptln102Service;
    @Resource
    private AcctCreateKeyService acctCreateKeyService;

    @Test
    public void createContractData(){
        redisTools.put("wert","4563456");
        System.out.println(redisTools.get("wert"));
    }
}
