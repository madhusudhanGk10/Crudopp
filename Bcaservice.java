package com.student.student_crud.service;

import com.student.student_crud.entity.Bca;
import com.student.student_crud.rep.Bcarep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Bcaservice {
    @Autowired
    Bcarep bca_rep;
    public List<Bca> getAllStr(){
        return bca_rep.findAll();
    }

    public String save_bca(Bca bca){
        bca_rep.save(bca);
        return "data saved successfully";
    }

    public String del_bca(Long id){
        bca_rep.deleteById(id);
        return id+"data deleted successfully";
    }

    public Bca edit_str(Long id,Bca bca){
        Bca b=bca_rep.findById(id).orElse(null);
        b.setJava(bca.getJava());
        b.setPython(bca.getPython());
        b.setName(bca.getName());
        return bca_rep.save(b);
    }
}