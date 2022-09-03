package uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
@NamedQuery(name = "Persona.buscarPorCedula", query = "SELECT p FROM Persona p WHERE p.cedula =:cedula")
@NamedQuery(name = "Persona.buscarPorNombreApellido", query = "SELECT p FROM Persona p WHERE p.nombre =:nombre AND p.apellido = :apellido")

// @NamedQueries({@NamedQuery(name = "Persona.buscarPorCedula", query = "SELECT
// p FROM Persona p WHERE p.cedula =:cedula"), @NamedQuery(name =
// "Persona.buscarPorNombreApellido", query = "SELECT p FROM Persona p WHERE
// p.nombre =:nombre AND p.apellido = :apellido")})\

@NamedNativeQueries({
        @NamedNativeQuery(name = "Persona.buscarCedulaNative", query = "SELECT * FROM persona WHERE pers_cedula = :cedula", resultClass = Persona.class),
        @NamedNativeQuery(name = "Persona.buscarApellidoNative", query = "SELECT * FROM persona WHERE pers_apellido = :apellido", resultClass = Persona.class) })

public class Persona {

    @Id
    @Column(name = "pers_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pers_id_seq")
    @SequenceGenerator(name = "pers_id_seq", sequenceName = "pers_id_seq")
    private Integer id;

    @Column(name = "pers_nombre")
    private String nombre;

    @Column(name = "pers_apellido")
    private String apellido;

    @Column(name = "pers_genero")
    private String genero;

    @Column(name = "pers_cedula")
    private String cedula;

    // Set y Get

    public Integer getId() {
        return id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona [apellido=" + apellido + ", cedula=" + cedula + ", genero=" + genero + ", id=" + id
                + ", nombre=" + nombre + "]";
    }

}
