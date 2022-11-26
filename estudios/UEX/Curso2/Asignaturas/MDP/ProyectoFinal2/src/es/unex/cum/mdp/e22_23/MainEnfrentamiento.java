//package es.unex.cum.mdp.e22_23;
//
//import java.util.Random;
//
//public class MainEnfrentamiento {
//    private String tipo="Petanca";
//    private Jugador j1=new Jugador("Pepe",1,20,"Pepe",10);
//    private Jugador j2=new Jugador("Ana",2,22,"Ana",12);
//    private Jugador j3=new Jugador("Juan",3,24,"Jaun",14);
//    private Jugador j4=new Jugador("Lupe",4,26,"Lupe",12);
//    private Partido p= new Parti();
//    public static void main(String[]args) {
//        MainEnfrentamiento m= new MainEnfrentamiento();
//        m.run();
//    }
//
//    public void run() {
//        Enfrentamiento e=null;
//        if (tipo.equals("Futbolin")) {
//            e = new EnfrentamientoFutbolin(1,j1,j2,j3,j4);
//        }else {
//            e = new EnfrentamientoPetanca(1,j1,j2);
//        }
//        System.out.println(e.simular(14, 10)); //retorna 0 en petanca 2
//        System.out.println(e.simular(16, 10)); //retorna 2 en petanca 4
//        System.out.println(e.simular(11, 9));  //retorna -2 en petanca 0
//
//        System.out.println(e.jugar(5, 5)); //retorna 0 en petanca 0
//        System.out.println(e.jugar(2, 4)); //retorna -2 en petanca -2
//        System.out.println(e.jugar(5, 2)); //retorna 3 en petanca 3
//    }
//
//}
