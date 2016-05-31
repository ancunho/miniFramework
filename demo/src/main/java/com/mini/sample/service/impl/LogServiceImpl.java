package com.mini.sample.service.impl;

import com.mini.framework.annotation.Service;
import com.mini.sample.entity.Log;
import com.mini.sample.service.LogService;

@Service
public class LogServiceImpl implements LogService {

    @Override
//    @Transaction
    public void log(String description) {
        Log log = new Log();
        log.setDate(DateUtil.getCurrentDate());
        log.setTime(DateUtil.getCurrentTime());
        log.setDescription(description);
        DataSet.insert(log);

//        // 故意让事务回滚
//        throw new RuntimeException();
    }
}
