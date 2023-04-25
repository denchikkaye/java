package com.construction.Construction.service;

import com.construction.Construction.models.Home;
import com.construction.Construction.models.SupplierOrder;
import com.construction.Construction.models.Suppliers;
import com.construction.Construction.respository.SupplierOrderRepository;
import com.construction.Construction.respository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    private SupplierOrderRepository supplierOrderRepository;

    public Suppliers findSupplierById(Long supId) {
        Optional<Suppliers> homeFromDb = supplierRepository.findById(supId);
        return homeFromDb.orElse(new Suppliers());
    }

    public SupplierOrder findById(Long supId) {
        Optional<SupplierOrder> userFromDb = supplierOrderRepository.findById(supId);
        return userFromDb.orElse(new SupplierOrder());
    }
}
