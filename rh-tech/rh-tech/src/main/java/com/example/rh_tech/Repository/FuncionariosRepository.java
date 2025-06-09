package com.example.rh_tech.Repository;

import com.example.rh_tech.Model.funcionariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface funcionariosRepository extends JpaRepository<Model.funcionariosModel, Long> {
} 