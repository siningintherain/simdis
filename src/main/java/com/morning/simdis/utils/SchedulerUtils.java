package com.morning.simdis.utils;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * com.morning.simdis.utils.SchedulerUtils
 *
 * @author Niancheng
 * @date 2018/11/11
 */
public class SchedulerUtils {

    private final static Scheduler DEFAULT_SCHEDULER;

    static {
        try {
            DEFAULT_SCHEDULER = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }


    public static void startSetTimeTask() {

    }
}
