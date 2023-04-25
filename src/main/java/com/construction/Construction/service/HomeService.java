package com.construction.Construction.service;

import com.construction.Construction.models.Home;
import com.construction.Construction.respository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeService {

    @Autowired
    HomeRepository homeRepository;

    public List<Home> allHomes() {
        return homeRepository.findAll();
    }

    public Home findHomeById(Long homeId) {
        Optional<Home> homeFromDb = homeRepository.findById(homeId);
        return homeFromDb.orElse(new Home());
    }
}
