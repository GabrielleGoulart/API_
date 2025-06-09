package com.example.rh_tech.Service;
import com.example.rh_tech.Model.cargosModel;
import javax.management.loading.ClassLoaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargosService {

@Autowired
private ClassLoaderRepository cargosRepository;

public cargosModel createCargo(cargosModel cargo) {
    return CargosRepository.save(cargo);

}


}



