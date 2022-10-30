public class Ciudadano extends Persona{
    private String poblacion;
    public Ciudadano(){
        super();
        iniciarAtributos();
    }

    public void iniciarAtributos()
    {
        setNombre("Mi nombre");
        age = 0;
    }

    public Ciudadano(String nombre, int edad, String poblacion){
        super(nombre, edad);
        this.poblacion = poblacion;
    }

    public Ciudadano(Persona p, String poblacion){
        super(p.nombre, p.age);
        this.poblacion = poblacion;
    }

    public String getPoblacion()
    {
        return poblacion;
    }
    public void setPoblacion(String poblacion)
    {
        this.poblacion = poblacion;
    }
}
