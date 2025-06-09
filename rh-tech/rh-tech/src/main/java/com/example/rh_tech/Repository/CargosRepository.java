package com.example.rh_tech.rh_tech.Repository;

import com.example.rh_tech.rh_tech.Model.cargosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cargosRepository extends JpaRepository<Model.cargosModel, Long> {
} 