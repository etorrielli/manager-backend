package com.trimix.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_documento")
public class TipoDocumento {
    @Id
    @Column(name = "tpo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tpoId;
    @Basic
    @Column(name = "tpo_descripcion")
    private String tpoDescripcion;
    @JsonIgnore
    @OneToMany(mappedBy = "perTpoId", cascade = CascadeType.ALL)
    private List<Persona> personaList;


    public int getTpoId() {
        return tpoId;
    }

    public void setTpoId(int tpoId) {
        this.tpoId = tpoId;
    }

    public String getTpoDescripcion() {
        return tpoDescripcion;
    }

    public void setTpoDescripcion(String tpoDescripcion) {
        this.tpoDescripcion = tpoDescripcion;
    }

    public List<Persona> getPersonaList(){return personaList;};

    public void setPersonaList(List<Persona> personaList){this.personaList = personaList;}
}
