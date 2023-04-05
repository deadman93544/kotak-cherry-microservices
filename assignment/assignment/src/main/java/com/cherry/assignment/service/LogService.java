package com.cherry.assignment.service;

import com.cherry.assignment.controllers.FeignAPIClient;
import com.cherry.assignment.entities.Log;
import com.cherry.assignment.jpa.LogRepository;
import com.cherry.assignment.views.LogRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class LogService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private FeignAPIClient apiClient;

    public Log getLogById(String uid){
        if(uid == null){
            throw new RuntimeException("Please provide a valid Id");
        }
        Log log = logRepository.findByUid(uid);
        if(log == null){
            throw new RuntimeException("No Log found for Id: " + uid);
        }
        return log;
    }

    public List<Log> getAllLogs(){
        return logRepository.findAllByActive(true);
    }

    public Log saveLog(LogRequest request) {
        Log log = null;
        if(!StringUtils.isEmpty(request.getUid())){
            log = logRepository.findByUid(request.getUid());
            if(log == null){
                throw new RuntimeException("No Log found for Id: " + request.getUid());
            }
        }
        if(log == null){
            log = new Log();
            log.setUid(UUID.randomUUID().toString());
            log.setCreatedDate(new Date());
            log.setCreatedBy("SYSTEM");
        }
        log.setActive(true);
        log.setMessage(request.getMessage());
        log.setUpdatedBy("SYSTEM");
        log.setUpdatedDate(new Date());
        return logRepository.save(log);
    }

    public Log generateHelloWorldAsLog() {
        Log log = new Log();
        log.setUid(UUID.randomUUID().toString());
        log.setCreatedDate(new Date());
        log.setCreatedBy("SYSTEM");
        log.setActive(true);
        log.setMessage(apiClient.generateMessage());
        log.setUpdatedBy("SYSTEM");
        log.setUpdatedDate(new Date());
        return logRepository.save(log);
    }

    public void deleteLog(String uid) {
        if(uid == null){
            throw new RuntimeException("Please provide a valid Id");
        }
        Log log = logRepository.findByUid(uid);
        if(log == null){
            throw new RuntimeException("No Log found for Id: " + uid);
        }
        log.setActive(false);
        logRepository.save(log);
    }
}
