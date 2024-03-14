package com.appratingsystem.app.service.AppService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appratingsystem.app.service.AppService.entities.App;

public interface AppRepo extends JpaRepository<App, String>{
    
}
