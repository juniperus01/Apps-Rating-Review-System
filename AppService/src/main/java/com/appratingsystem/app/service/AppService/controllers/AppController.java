package com.appratingsystem.app.service.AppService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appratingsystem.app.service.AppService.entities.App;
import com.appratingsystem.app.service.AppService.services.AppService;



@RestController
@RequestMapping("/apps")
public class AppController {
    
    @Autowired
    private AppService appService;

    @PostMapping
    public ResponseEntity<App> create(@RequestBody App app){
        return ResponseEntity.status(HttpStatus.CREATED).body(appService.create(app));
    }

    @GetMapping("/{appId}")
    public ResponseEntity<App> getSingleApp( @PathVariable String appId){
        App app = appService.getApp(appId);
        return ResponseEntity.ok(app);
    }

    @GetMapping
    public ResponseEntity<List<App>> getAllApp(){
        List<App> allApp = appService.getAllApp();
        return ResponseEntity.ok(allApp);
    }
}
