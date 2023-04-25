package com.construction.Construction.respository;

import com.construction.Construction.models.Constractors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstractorsRepository extends JpaRepository<Constractors, Long> {
    Constractors findPriceByHomeId(Long homeId);
}
