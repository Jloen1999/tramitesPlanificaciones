
### getPuntos() →int

```java TI:"getPuntos()"
/**  
 * Calcula/Devuelve el total de puntos de cada Partido * * @return puntos Variable de tipo entero. Devuelve la suma de las puntuaciones en base a:  
 * <ul>  
 *     <li>Partidos Ganados(partGanados)->5 puntos</li>  
 *     <li>Partidos Empatados(partEmpatados)->2 puntos</li>  
 *     <li>Partidos Perdidos(partPerdidos)->-3 puntos</li>  
 * </ul>  
 */  
@Override  
public int getPuntos() { //Redefinimos el método getPuntos  
    puntos = partGanados*5 + partEmpatados*2 + partPerdidos*(-3);  
    return puntos;  
}
```