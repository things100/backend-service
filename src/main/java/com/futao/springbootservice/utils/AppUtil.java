package com.futao.springbootservice.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * APP工具类
 *
 * @author futao
 * @date 2020/11/4
 */
public class AppUtil {

    /**
     * 获取不带`-`的UUID
     *
     * @return 不带`-`的UUID
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取文件扩展名
     *
     * @param fileName
     * @return
     */
    public static String getFileExtNameWithPoint(String fileName) {
        if (!StringUtils.isBlank(fileName)) {
            int suffixIndex = fileName.lastIndexOf(".");
            if (suffixIndex > 0) {
                return fileName.substring(suffixIndex);
            }
        }
        return StringUtils.EMPTY;
    }

    public static void main(String[] args) {
        System.out.println(AppUtil.getFileExtNameWithPoint("asdasdasds.asdas.das.d.as.das.da.sd.as.das.1"));
        System.out.println(AppUtil.getFileExtNameWithPoint(""));
        System.out.println(AppUtil.getFileExtNameWithPoint(null));
        System.out.println(AppUtil.getFileExtNameWithPoint("12312312"));
    }
}
