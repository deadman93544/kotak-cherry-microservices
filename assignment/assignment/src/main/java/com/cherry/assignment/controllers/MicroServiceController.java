package com.cherry.assignment.controllers;

import com.cherry.assignment.service.LogService;
import com.cherry.assignment.views.LogRequest;
import com.cherry.assignment.views.LogResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cherry/log")
@Slf4j
public class MicroServiceController {

    @Autowired
    private LogService logService;

    @GetMapping
    public LogResponse getLogById(@RequestParam String uid){
        return new LogResponse(logService.getLogById(uid));
    }

    @GetMapping("/all")
    public List<LogResponse> getAllLogs(){
        return logService.getAllLogs().stream().map(LogResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public LogResponse addLog(@RequestBody LogRequest request){
        return new LogResponse(logService.saveLog(request));
    }

    @PostMapping("/generate")
    public LogResponse generateHelloWorldAsLog(){
        return new LogResponse(logService.generateHelloWorldAsLog());
    }

    @PutMapping
    public LogResponse editLog(@RequestBody LogRequest request){
        return new LogResponse(logService.saveLog(request));
    }

    @DeleteMapping
    public void deleteLog(@RequestParam String uid){
        logService.deleteLog(uid);
    }

}
