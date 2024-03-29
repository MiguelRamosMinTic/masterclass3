package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Categoria;
import co.usa.ciclo3.ciclo3.model.Papeleria;
import co.usa.ciclo3.ciclo3.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAll(){
        return  categoriaRepository.getAll();
    }
    public Optional<Categoria> getCategoria(int id){
        return categoriaRepository.getCategoria(id);
    }

    public Categoria save(Categoria p){
        if(p.getId()==null){
            return categoriaRepository.save(p);
        }else{
            Optional<Categoria> paux=categoriaRepository.getCategoria(p.getId());
            if(paux.isEmpty()){
                return categoriaRepository.save(p);
            }else{
                return p;
            }
        }
    }
}
