/**
 * @author Jose Luis Obiang Ela Nanguan
 * @since 1.0
 */


package es.unex.cum.mdp.sesion4;

import java.util.*;

public class Vehiculo implements Comparable{
    protected String marca;
    protected String modelo;
    protected Persona propietario;
    protected Set<Pieza> piezas;
    protected Integer bastidor;


    public Vehiculo() {
        marca = "Audi";
        modelo = "Q2";
        propietario = new Persona();
        bastidor = 0;
        piezas = new TreeSet<Pieza>();
    }

    public Vehiculo(Vehiculo v) {
        this.marca = v.marca;
        this.modelo = v.modelo;
        this.propietario = v.propietario;
        this.bastidor = v.bastidor;
        piezas = new TreeSet<Pieza>();
    }

    public Vehiculo(String marca, String modelo, Persona propietario, Integer bastidor) {
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.bastidor = bastidor;
        piezas = new TreeSet<Pieza>();

    }

    public Vehiculo(String marca, String modelo, Persona propietario) {
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        piezas = new TreeSet<Pieza>();
    }

    public Integer getBastidor() {
        return bastidor;
    }

    public void setBastidor(Integer bastidor) {
        this.bastidor = bastidor;
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
        if(pos>=piezas.size() || pos<0) return null;
        List<Pieza> list= new ArrayList<Pieza>(piezas);
        return list.get(pos);
    }

    public TreeSet<Pieza> getPiezas() {
        return (TreeSet<Pieza>) piezas;
    }

    public Pieza getPiezaForId(String id){
        Pieza p = null;
//        //ArrayList<Pieza> listPiezas= new ArrayList<Pieza>(piezas);
//        Iterator<Pieza> item = listPiezas.iterator();
//        while (item.hasNext() && p!=null) {
//            Pieza pz = item.next();
//                if(listPiezas.stream().anyMatch(pieza -> pieza.getId().equals(id))){
//                    p = pz;
//                }
//        }
        if(id != null && piezas != null){
            Iterator<Pieza> iterator = piezas.iterator();
            while(iterator.hasNext() && p == null){
                Pieza pz = (Pieza)iterator.next();
                if(pz.getId().equals(id)){
                    p = pz;
                }
            }
        }

        return p;
    }

    public boolean addPiezaV(Pieza p) {
        if(p !=null && piezas != null){
            return piezas.add(p);
        }
        return false;
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
        return Objects.hash(bastidor,piezas);
    }

    @Override
    public String toString() {
        return "Vehiculo [" +
                "marca=" + marca +
                ", modelo=" + modelo +
                ", propietario=" + propietario +
                ", piezas=" + piezas +
                ", bastidor=" + bastidor +
                ']';
    }

    @Override
    public int compareTo(Object o) {
        int mayor = -1;
        Vehiculo v = (Vehiculo)o;
        if(piezas != null && v.getPiezas()!=null){
            if (piezas.size() > v.getPiezas().size()) mayor = 1;
            else if (piezas.size() == v.getPiezas().size()) mayor = 0;
        }

        return mayor;
    }


}

