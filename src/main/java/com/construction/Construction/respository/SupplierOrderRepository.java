package com.construction.Construction.respository;

import com.construction.Construction.models.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Long> {
    SupplierOrder findByUserId(Long userId);
}
