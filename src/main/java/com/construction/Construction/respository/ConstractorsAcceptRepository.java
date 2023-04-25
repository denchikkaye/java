package com.construction.Construction.respository;

import com.construction.Construction.models.ConstractorsAccept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstractorsAcceptRepository extends JpaRepository<ConstractorsAccept, Long> {
    ConstractorsAccept findByUserId(Long userId);
}
