package com.example.springteste.modules.moments.repositories;

import com.example.springteste.modules.moments.models.Moment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MomentRepository extends JpaRepository<Moment, Integer> {

}
