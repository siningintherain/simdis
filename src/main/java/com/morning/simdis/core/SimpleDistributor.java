package com.morning.simdis.core;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * com.morning.simdis.core.SimpleDistributor
 * 简单分布式
 *
 * @author Niancheng
 * @date 2018/11/9
 */
public class SimpleDistributor {

    private Scheduler scheduler;

    private final static Scheduler DEFAULT_SCHEDULER;

    static {
        try {
            DEFAULT_SCHEDULER = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }




}
