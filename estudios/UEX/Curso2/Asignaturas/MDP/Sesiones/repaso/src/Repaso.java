public class Repaso{

    public static void main(String[] args){
        for(Semana dia : Semana.values()){
            System.out.println(dia.name());
            System.out.println(dia.ordinal());
            System.out.println(dia.getNombre());
            System.out.println(dia.getNumero());
            }
        }

    public enum Semana {
        LUNES(12, "Primer dia de la semana"),
        MARTES(343, "Segundo dia de la semana"),
        MIERCOLES(56, "Sin comentarios"),
        JUEVES(567, "Siempre en medio"),
        VIERNES(4, "Ultimo dia de trabajo"),
        SABADO(3, "Empieza el fin de semana"),
        DOMINGO(2, "Mañana de nuevo a trabajar");
        private int numero;
        private String nombre;

        Semana(int numero, String nombre) {
            this.numero = numero;
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public int getNumero() {
            return numero;
        }
    }


}