package com.appratingsystem.app.service.AppService.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.appratingsystem.app.service.AppService.entities.App;

@Service
public interface AppService {
    App create(App app);

    List<App> getAllApp();
    
    App getApp(String appId);
}
