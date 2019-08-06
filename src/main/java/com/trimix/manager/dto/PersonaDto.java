package com.trimix.manager.dto;

import java.util.Date;

public class PersonaDto {
    private int perId;
    private String perNombre;
    private String perApellido;
    private int perTpoId;
    private long perNumeroDocumento;
    private Date perFechaNacimiento;

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public int getPerTpoId() {
        return perTpoId;
    }

    public void setPerTpoId(int perTpoId) {
        this.perTpoId = perTpoId;
    }

    public long getPerNumeroDocumento() {
        return perNumeroDocumento;
    }

    public void setPerNumeroDocumento(long perNumeroDocumento) {
        this.perNumeroDocumento = perNumeroDocumento;
    }

    public Date getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(Date perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }
}
