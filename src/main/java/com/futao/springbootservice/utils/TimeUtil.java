package com.futao.springbootservice.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author futao
 * @date 2020/12/2
 */
public class TimeUtil {

    public static LocalDateTime currentDateTime() {
        return LocalDateTime.now(ZoneOffset.ofHours(8));
    }

    public static LocalDate currentDate() {
        return LocalDate.now(ZoneOffset.ofHours(8));
    }
}
