//package es.unex.cum.mdp.e22_23;
//
//public class Liga{
//    public boolean crearCalendario() {
//        int numTeams = equiposLiga.size();
//        int numDays = (numTeams - 1); // Dias que tendrá el torneo
//        int halfSize = numTeams / 2; // calculo e la mitad
//
//        //TODO: Compruebo que hay equipos
//
//        //TODO: Compruebo que para equipo hay al menos tantos jugadores como Partido.getNumEnfrentamiento()*2
//
//        // Lista para copiar la lista de jugadores
//        List<EquipoLiga> teams = new ArrayList<EquipoLiga>();
//        teams.addAll(equiposLiga); // Añado todos los equipos al temporal
//        teams.remove(teams.get(0)); // Elimino el primer elemento
//        int teamsSize = teams.size();
//        for (int day = 0; day < numDays; day++) {
//            // Primer partido de la jornada
//            System.out.println("Jornada: " + day);
//            int teamIdx = day % teamsSize;
//            System.out.println(teams.get(teamIdx) + " vs " + equiposLiga.get(0));
//            // TODO: crear jornada
//            // TODO: crear primer partidos
//            // TODO: fijar la estadistica en base al tipo
//            // TODO: Asignar Juez. NO HACERLO
//            // TODO: crear enfrentamiento para cada partido llamando al método de Enfrentamiento
//            // El resto de partidos de la jornada
//            for (int idx = 1; idx < halfSize; idx++) {
//                int firstTeam = (day + idx) % teamsSize;
//                int secondTeam = (day + teamsSize - idx) % teamsSize;
//                System.out.println(teams.get(firstTeam) + " vs " + teams.get(secondTeam));
//                // TODO: crear cada partido
//                // TODO: fijar la estadistica en base al tipo
//                // TODO: Asignar Juez. NO HACERLO
//                // TODO: crear enfrentamiento para cada partido llamando al método de Enfrentamiento
//            }
//            calendario.add(j);
//        }
//    }
//}
