package com.defitech.tpVente.service;

import com.defitech.tpVente.modele.Appro;
import com.defitech.tpVente.repository.ApproRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApproService {
    @Autowired
    ApproRepository approRepository;

    public void saveAppro(Appro appro) {approRepository.save(appro);
    }

    public List<Appro> showAllAppro() {return approRepository.findAll();
    }
    public Appro showOneAppro(int id){
        return approRepository.findById(id).get();
    }
    public void deleteAppro(int id){
        approRepository.deleteById(id);
    }
}
