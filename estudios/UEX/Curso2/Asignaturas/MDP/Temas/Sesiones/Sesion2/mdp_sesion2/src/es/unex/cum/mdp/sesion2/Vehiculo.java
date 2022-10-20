/**
 * @author Jose Luis Obiang Ela Nanguan
 * @since 1.0
 */


package es.unex.cum.mdp.sesion2;

import java.util.Arrays;
import java.util.Objects;

public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected Persona propietario;
    protected Pieza[] piezas;
    protected int cont;
    protected Integer bastidor;


    public Vehiculo() {
        marca = "Audi";
        modelo = "Q2";
        propietario = new Persona();
        piezas = new Pieza[3];
        cont = 0;
        bastidor = 0;
    }

    public Vehiculo(Vehiculo v) {
        this.marca = v.marca;
        this.modelo = v.modelo;
        this.propietario = v.propietario;
        this.piezas = new Pieza[3];
        this.bastidor = v.bastidor;
        this.cont = v.cont;
    }

    public Vehiculo(String marca, String modelo, Persona propietario, Integer bastidor) {
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.piezas = new Pieza[3];
        this.bastidor = bastidor;
    }

    public Vehiculo(String marca, String modelo, Persona propietario) {
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.piezas = new Pieza[3];
    }

    public Integer getBastidor() {
        return bastidor;
    }

    public void setBastidor(Integer bastidor) {
        this.bastidor = bastidor;
    }


    public int getCont() {
        return cont;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setPropietario(Persona p) {
        this.propietario = p;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public Pieza getPiezaV(int pos) {
        if(pos>=piezas.length || pos<0) return null;
        return piezas[pos];
    }

    public Pieza[] getPiezas() {
        return piezas;
    }

//    public boolean addPiezaV1(Pieza p)
//    {
//        Set<Pieza> piezas = new HashSet<Pieza>();
//        return piezas.add(p);
//    }


    public boolean existIDPieza(String id) {
        int i = 0;
        boolean exist = false;
        while (i < cont && !exist) {
            if (id.equals(piezas[i].getId())) {
                exist = true;
            }
            i++;
        }
        return exist;
    }

    public Pieza getPiezaForId(String id){
        int i = 0;
        while (i < cont) {
            if (id.equals(piezas[i].getId())) {
                return piezas[i];
            }
            i++;
        }
        return null;
    }

    public boolean addPiezaV(Pieza p) {
        boolean add = false;
        if (cont<piezas.length) {
            if(!existIDPieza(p.getId())){
                piezas[cont] = p;
                cont++;
                add = true;
            }
        }

        return add;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(bastidor, vehiculo.bastidor);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(marca, modelo, propietario);
        result = 31 * result + Arrays.hashCode(piezas);
        return result;
    }

    @Override
    public String toString() {
        return "Vehiculo [" +
                "marca=" + marca +
                ", modelo=" + modelo +
                ", propietario=" + propietario +
                ", piezas=" + Arrays.toString(piezas) +
                ", cont=" + cont +
                ", bastidor=" + bastidor +
                ']';
    }
}

