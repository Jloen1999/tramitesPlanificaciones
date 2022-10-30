import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {2,1};
            Persona p = new Persona("Jose Luis", (new Random()).nextInt(2,10));
            Ciudadano c = new Ciudadano("Pedro", 22, "Merida");
            Persona c1 = new Ciudadano(p, "Badajoz");
        System.out.println(p.getNombre());
        p.iniciarAtributos();
        System.out.println(p.getNombre());

        System.out.println(p.toString());
        System.out.println(p instanceof Persona);

    }
}
