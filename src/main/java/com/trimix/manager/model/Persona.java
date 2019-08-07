package com.trimix.manager.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @Column(name = "per_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int perId;
    @Basic
    @Column(name = "per_nombre")
    private String perNombre;
    @Basic
    @Column(name = "per_apellido")
    private String perApellido;
    @ManyToOne
    @JoinColumn(name = "tpo_id", nullable = false)
    private TipoDocumento perTpoId;
    @Basic
    @Column(name = "per_numero_documento")
    private long perNumeroDocumento;
    @Basic
    @Column(name = "per_fecha_nacimiento")
    private Date perFechaNacimiento;
    @Transient
    private String fechaNacimientoFormat;

    public Persona(){

    }

    public Persona(String perNombre, String perApellido, TipoDocumento perTipoDocumento, long perNumeroDocumento, Date perFechaNacimiento) {
        this.perNombre = perNombre;
        this.perApellido = perApellido;
        this.perTpoId = perTipoDocumento;
        this.perNumeroDocumento = perNumeroDocumento;
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public String getFechaNacimientoFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaNacimientoFormat = sdf.format(this.getPerFechaNacimiento());
        return fechaNacimientoFormat;
    }

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

    public TipoDocumento getPerTipoDocumento() {
        return perTpoId;
    }

    public void setPerTipoDocumento(TipoDocumento perTipoDocumento) {
        this.perTpoId = perTipoDocumento;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        if (perId != persona.perId) return false;
        if (perNumeroDocumento != persona.perNumeroDocumento) return false;
        if (perNombre != null ? !perNombre.equals(persona.perNombre) : persona.perNombre != null) return false;
        if (perApellido != null ? !perApellido.equals(persona.perApellido) : persona.perApellido != null) return false;
        if (perTpoId != null ? !perTpoId.equals(persona.perTpoId) : persona.perTpoId != null)
            return false;
        if (perFechaNacimiento != null ? !perFechaNacimiento.equals(persona.perFechaNacimiento) : persona.perFechaNacimiento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = perId;
        result = 31 * result + (perNombre != null ? perNombre.hashCode() : 0);
        result = 31 * result + (perApellido != null ? perApellido.hashCode() : 0);
        result = 31 * result + (perTpoId != null ? perTpoId.hashCode() : 0);
        result = 31 * result + (int) (perNumeroDocumento ^ (perNumeroDocumento >>> 32));
        result = 31 * result + (perFechaNacimiento != null ? perFechaNacimiento.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "perId=" + perId +
                ", perNombre='" + perNombre + '\'' +
                ", perApellido='" + perApellido + '\'' +
                ", perNumeroDocumento=" + perNumeroDocumento +
                ", perFechaNacimiento=" + perFechaNacimiento +
                '}';
    }
}

