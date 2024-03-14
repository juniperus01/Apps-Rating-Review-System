package com.appratingsystem.app.service.AppService.impl;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appratingsystem.app.service.AppService.entities.App;
import com.appratingsystem.app.service.AppService.exceptions.ResourceNotFoundException;
import com.appratingsystem.app.service.AppService.repositories.AppRepo;
import com.appratingsystem.app.service.AppService.services.AppService;

@Service
public class AppServiceImpl implements AppService{

    @Autowired
    private AppRepo appRepository;
    
    @Override
    public App create(App app){
        String appId = UUID.randomUUID().toString();
        app.setAppId(appId);
        return appRepository.save(app);
    }

    @Override
    public List<App> getAllApp(){
        return appRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public App getApp(String appId){
        return appRepository.findById(appId).orElseThrow(() -> new ResourceNotFoundException("App with given id not found !!" + appId));
    }
}
