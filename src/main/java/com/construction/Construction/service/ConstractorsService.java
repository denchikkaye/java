package com.construction.Construction.service;

import com.construction.Construction.models.ConstractorsOrder;
import com.construction.Construction.respository.ConstractorsOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstractorsService {
    @Autowired
    ConstractorsOrderRepository constractorsOrderRepository;

    public List<ConstractorsOrder> allConOrder() {
        return constractorsOrderRepository.findAll();
    }

    public ConstractorsOrder findById(Long conId) {
        Optional<ConstractorsOrder> conFromDb = constractorsOrderRepository.findById(conId);
        return conFromDb.orElse(new ConstractorsOrder());
    }

}
