package com.construction.Construction.respository;

import com.construction.Construction.models.SuppliersAccept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersAcceptRepository extends JpaRepository<SuppliersAccept, Long> {
    SuppliersAccept findByUserId(Long userId);
}
