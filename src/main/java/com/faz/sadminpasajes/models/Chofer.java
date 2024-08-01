package com.faz.sadminpasajes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Chofer extends Persona {
    
    @NotBlank(message = "licencia no puede estar vacio")
    private String licencia;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Chofer() {
        super();
    }

    public Chofer(String nom,String ape,int dni,String licencia){
        super(nom, ape, dni);
        this.licencia = licencia;
    }


    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public void setEmpresa(Empresa emp){
        this.empresa = emp;
    }

    public Empresa getEmpresa(){
        return this.empresa;
    }
    
    public void updateValues(Chofer choferUpdate){
        this.setApellido(choferUpdate.getApellido());
        this.setNombre(choferUpdate.getNombre());
        this.setDni(choferUpdate.getDni());
        this.empresa.updateValues(choferUpdate.getEmpresa());
        this.setLicencia(choferUpdate.getLicencia());
    }
}
