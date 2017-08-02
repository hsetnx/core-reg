package com.lefinance.common.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @Author: jingyan
 * @Time: 2017/8/2 14:16
 * @Describe:
 */
public class ScreenUtil {

    /**
     * @Author: jingyan
     * @Time: 2017/8/2 14:27
     * @Describe: 截图
     */
    public static String captureScreen(String imgName, String imgType) {
        try {
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rectangle = new Rectangle(dimension);
            Robot robot = new Robot();
            BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
            ImageIO.write(bufferedImage, imgType, new File(imgName));
            return imgName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        long timer = System.currentTimeMillis();
        String fileName = ScreenUtil.captureScreen("D://" + timer + "_screen.png", "png");
        System.out.println(fileName);
    }
}
