package es.unex.cum.mdp.e22_23.jornadaLigaTemporadaCampeonato;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Clase Temporada
 * Se utiliza para modelar cada una de las temporadas
 *
 * @author Jose Luis Obiang Ela Nanguan
 * @version 1.0, 2/12/2022
 * @see Liga
 */
public class Temporada {
    //Atributos
    private String nombre; // identificador de la temporada
    private Map<String, Liga> ligas; //lista de las distintas ligas que tendrá la temporada

    //Constructores

    /**
     * Constructor por defecto. Inicializa todos los atributos de la
     * clase.
     */
    public Temporada(){
        nombre = new String();
        ligas = new HashMap<>();
    }


    /**
     * Constructor parametrizado.
     *
     * @param nombre  Recibe el nombre(identificador) de la Temporada.
     * @param ligas Recibe un map de Liga cuya key es de tipo String
     */
    public Temporada(String nombre, Map<String, Liga> ligas) {
        this.nombre = nombre;
        this.ligas = ligas;
    }

    /**
     * Constructor copia.
     * @param t recibe una Temporada
     */
    public Temporada(Temporada t){
        this.nombre = t.nombre;
        this.ligas = t.ligas;
    }

    /**
     * Constructor copia.
     * @param nombre Variable de tipo cadena. Recibe el nombre(identificador) de la Temporada
     */
    public Temporada(String nombre){
        this.nombre = nombre;
        ligas = new HashMap<>();
    }

            //Getters
    /**
     * Obtiene el nombre de la temporada.
     * @return String
     */
    public String getNombre() {
        return nombre;
    }


    /**
     * Obtiene las ligas de la temporada.
     * @return ligas Recibe un map de tipo Liga cuya key es un String
     */
    public Map<String, Liga> getLigas() {
        return ligas;
    }

            //Setters
    /**
     * Modifica el nombre de la temporada.
     * @param nombre Recibe el nombre(identificador) de la Temporada
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    /**
     * Modifica las ligas de la temporada.
     * @param ligas Recibe un map de tipo Liga cuya key es un String
     */
    public void setLigas(Map<String, Liga> ligas) {
        this.ligas = ligas;
    }

    /**
     * Redefine el método equals de la clase Object, que comprueba la igualdad
     * de todos los atributos y objetos de la clase Persona.
     *
     * @param o Recibe un objeto de tipo Object.
     * @return booleano Devuelve un valor de tipo booleano
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temporada temporada = (Temporada) o;
        return Objects.equals(nombre, temporada.nombre) && Objects.equals(ligas, temporada.ligas);
    }

    /**
     * Devuelve un código hash para el nombre y la lista de ligas de la temporada.
     *
     * @return entero Devuelve un valor de tipo entero
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, ligas);
    }

    /**
     * Muestra en formato de cadena el valor de todos los atributos
     *
     * @return cadena Devuelve un valor de tipo cadena
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Temporada{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", ligas=").append(ligas);
        sb.append('}');
        return sb.toString();
    }

            //TODO: Métodos a implementar
    /**
     * Obtenemos una temporada dado su nombre(identificador)
     *
     * @param nombre Recibe el nombre(identificador) de la Liga
     * @return Devuelve un objeto de tipo Liga
     * <ul>
     *     <li>NULL: Si NO existe la Liga</li>
     *     <li>NO NULL: Si existe la Liga</li>
     * </ul>
     */
    public Liga getLigaName(String nombre) {
        Liga l = null;
        if (ligas != null && nombre != null) { //Si la lista de ligas y la clave introducida no son nulas.
            //Iteramos la lista de ligas de la temporada
            Iterator<String> it = ligas.keySet().iterator();
            while (it.hasNext() && l == null) {
                String clave = (String) it.next();  //Obtenemos la clave
                Liga value = (Liga) ligas.get(clave);   //Obtenemos el valor de la clave
                if (clave.equals(nombre)) { //Comparamos las claves, si son iguales
                    l = value;  //Almacenamos el valor, es la liga a retornar.
                }

            }
        }//En caso contrario retorna NULL

        return l;
    }

    /**
     * Añadimos una Liga a la lista de ligas de una Temporada
     *
     * @param l Recibe una Liga
     * @return booleano Devuelve un valor booleano
     * <ul>
     *     <li>True: Se inserta la Liga</li>
     *     <li>False: NO se inserta la Liga</li>
     * </ul>
     */
    public boolean addLiga(Liga l) {
        boolean insertado = false;
        if(ligas!=null) { //Si la lista de ligas no es nula
            if (l != null && !ligas.containsKey(l.getNombre())) {   //Si la liga introducida no es nula y no existe la clave de la liga en cuestión
                ligas.put(l.getNombre(), l);   //Añadimos la liga
                insertado = true; // y devolvemos True
            }
        }
        return insertado;   //En caso contrario devolvemos false.
    }


}
