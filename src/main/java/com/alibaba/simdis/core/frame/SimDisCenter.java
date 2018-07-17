package com.alibaba.simdis.core.frame;

import com.alibaba.simdis.datasource.SimDisDataSourceFactory;
import com.alibaba.simdis.datasource.SimDisSqlExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 资源绑定中心
 *
 * @author niancheng
 * @date 2018/7/12
 */
@Component
public class SimDisCenter {

    @Autowired
    private SimDisDataSourceFactory simDisDataSourceFactory;

    private SimDisSqlExecutor simDisSqlExecutor;

    public SimDisDataSourceFactory getSimDisDataSourceFactory() {
        return simDisDataSourceFactory;
    }

    public void setSimDisDataSourceFactory(SimDisDataSourceFactory simDisDataSourceFactory) {
        this.simDisDataSourceFactory = simDisDataSourceFactory;
    }

    void init(){

    }
}
