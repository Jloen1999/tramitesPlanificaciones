# AMPLIACIÓN DE MATEMÁTICAS

Profesor: Mario Martínez Pizarro 

Departamento de Matemáticas. Despacho 25

Url Campus: [AMA](https://campusvirtual.unex.es/zonauex/avuex/course/view.php?id=8467)

Correo: mariomp@unex.es

Grupo: A(Lab I): 12-13

Pareja: NO

*Poner en asunto de los correos al profe: AMA I

- SAGE

:point_right:  [Url Sage](https://sage-cum.unex.es:8015/)

- Credenciales Sage:

  - Username: GIT21jelanang

  - !Password: Y7369285

# APUNTES
## Tema 1:  Teoría en Grafos
<p style="color: green">Publicado el 13/09/2022</p>

¿Qué es un grafo? Es un conjunto de objetos llamados vértices o nodos unidos por enlaces llamados aristas o arcos, que permiten representar relaciones binarias entre elementos de un conjunto.

Año de creación: 1735

Creador: Leonard Euler
- El problema de los puentes de Königsberg:
También llamado el problema de los 7 puentes de Königsberg, es un problema matemático que consistía en encontrar un recorrido para cruzar a pie toda la ciudad pasando solo una vez por cada uno de los puentes y regresando al mismo punto de inicio.

![img.png](Doc_Img/img_7.png)

¿Qué permiten los grafos? Permiten modelizar situaciones para saber si los objetos están relacionados.
- Aplicaciones de un grafo:
    - Redes
    - Diagramas de flujo
    - Bases de Datos
    - etc...

Ejemplo de un grafo: una red de computadoras(donde los vertices son los terminales y las aristas las conexiones inalámbricas o cables).

- Un grafo (V,E) está formado por
  - un conjunto de vértices V
  - un conjunto de aristas E

- Aristas: son enlaces que unen o conectan dos vértices.
- Vértices: son los nodos.
  - Vértices adyacentes: son aquellos que están conectados mediante la misma arista.

![img_1.png](Doc_Img/img_1.png)

![img_2.png](Doc_Img/img_2.png)

- Tipos de Grafos:
  - Pseudografo: Son vértices conectados con ellos mismos, es decir, que tienen un lazo, una arista que se conecta al mismo vértice.
   
  <img style="margin-left: 100px" src="Doc_Img/img_3.png" alt="img_3.png">
  
  - Multigrafo: Es cuando hay más de una conexión, arista o extremo entre dos vértices, dichas aristas se llaman paralelas.

  <img style="margin-left: 100px" src="Doc_Img/img_4.png" alt="img4">

  - Multipseudografo: Es un multigrafo donde aparecen lazos.
   
  - Digrafo o grafo dirigido: Son aristas representadas con una flecha, es decir, son pares de vértices ordenados.

  <img style="margin-left: 100px" src="Doc_Img/img_5.png" alt="img5">

  - Isomorfos: si tengo dos grafos, renombro los vértices y aristas del primero obtenemos el segundo.

  <img style="margin-left: 100px" src="Doc_Img/img_6.png" alt="img6">
  
  <img style="margin-left: 100px" src="Doc_Img/apunte1_13092022.jpg" width="300px" height="280px" alt="apunte1">
  
  <img style="margin-left: 100px" src="Doc_Img/apunte2_13092022.jpg" width="300px" height="280px" alt="apunte2">
  
  <img style="margin-left: 100px" src="Doc_Img/apunte3_13092022.jpg" width="300px" height="280px" alt="apunte3">
  
  <img style="margin-left: 100px" src="Doc_Img/apunte4_13092022.jpg" width="300px" height="280px" alt="apunte4">
  
  <img style="margin-left: 100px; transform: rotate(-90deg)" src="Doc_Img/apunte5_13092022.jpg" height="300px" alt="apuntes5">

  - Subgrafo de un grafo: es un grafo obtenido tomando un subconjunto de vértices y un subconjunto de aristas y todos los extremos de estas.
  
    <img style="margin-left: 100px" src="Doc_Img/img_7.png" width="300px" alt="img7">
  
    - Subgrafo Completo: es un grafo obtenido tomando un subconjunto de vértices y todas las aristas cuyos extremos sean esos vértices.
    
      <img style="margin-left: 100px" src="Doc_Img/img_8.png" width="300px" alt="img8">

  

  - 