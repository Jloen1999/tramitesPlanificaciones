import java.util.Objects;

public class Persona {
    protected String nombre;
    protected int age;

    public Persona(){
        nombre = "";
        age = 0;
    }

    public Persona(String name, int age)
    {
        this.nombre = name;
        this.age = age;
    }

    public String getNombre()
    {
        return nombre;
    }
    public int getAge()
    {
        return age;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString(){
        return "Persona{" +
                "Nombre= " + nombre +
                "Edad= " +age+
                "}";
    }

    /**
     *
     * @param o
     * @return
     */

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Persona p = (Persona)o;
        return Objects.equals(nombre, p.nombre) && age == p.age;
    }

    public void iniciarAtributos() {
        setNombre("Nombre");
        age = 1;
    }
}
