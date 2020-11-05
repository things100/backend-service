package com.futao.springbootservice.model.app;

/**
 * @author futao
 * @date 2020/11/4
 */
public class Constants {
    public static class APP {
        public static final String APP_NAME = "springboot-service";
    }

    public static class RedisKey {
        /**
         * 验证码redis key
         */
        public static final String VERIFY_CODE_KEY = APP.APP_NAME + ":verify-code:";
    }
}
