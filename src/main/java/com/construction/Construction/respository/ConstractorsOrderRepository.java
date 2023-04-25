package com.construction.Construction.respository;

import com.construction.Construction.models.ConstractorsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstractorsOrderRepository extends JpaRepository<ConstractorsOrder, Long> {
    ConstractorsOrder findByUserId(Long userId);
}
