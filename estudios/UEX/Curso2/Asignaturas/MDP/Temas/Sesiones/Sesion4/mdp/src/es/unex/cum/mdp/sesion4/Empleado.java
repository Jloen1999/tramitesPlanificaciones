package es.unex.cum.mdp.sesion4;

import java.util.Date;
import java.util.Objects;

public class Empleado extends Persona{
    private float sueldo;
    private Date fechaAlta;

    public Empleado(float sueldo, Date fechaAlta) {
        sueldo = sueldo;
        this.fechaAlta = fechaAlta;
    }

    public Empleado(String _nombre, String _dni, int _edad, float sueldo, Date fechaAlta) {
        super(_nombre, _dni, _edad);
        this.sueldo = sueldo;
        this.fechaAlta = fechaAlta;
    }

    public Empleado(Persona p, float sueldo, Date fechaAlta) {
        super(p);
        this.sueldo = sueldo;
        this.fechaAlta = fechaAlta;
    }

    public Empleado(){
        super();
        sueldo = 0;
        fechaAlta = new Date();
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Empleado empleado = (Empleado) o;
        return Float.compare(empleado.sueldo, sueldo) == 0 && Objects.equals(fechaAlta, empleado.fechaAlta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sueldo, fechaAlta);
    }

    @Override
    public String toString() {
        return super.toString()+
                "Empleado {sueldo=" + sueldo +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}
