package uce.edu.demo.repository;

import java.util.List;

import uce.edu.demo.repository.modelo.Persona;

public interface IPersonaRepo {
    public Persona buscarId(Integer id);

    public void insertar(Persona p);

    public void actualizar(Persona p);

    public void eliminar(Integer id);

    public List<Persona> buscarTodos();

}
