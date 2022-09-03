package uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.demo.repository.IPersonaRepo;
import uce.edu.demo.repository.modelo.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaRepo repo;

    @Override
    public Persona buscarId(Integer id) {

        return this.repo.buscarId(id);
    }

    @Override
    public void insertar(Persona p) {
        this.repo.insertar(p);

    }

    @Override
    public void actualizar(Persona p) {
        this.repo.actualizar(p);

    }

    @Override
    public void eliminar(Integer id) {
        this.repo.eliminar(id);

    }

    @Override
    public List<Persona> buscarTodos() {
        // TODO Auto-generated method stub
        return this.repo.buscarTodos();
    }

}
