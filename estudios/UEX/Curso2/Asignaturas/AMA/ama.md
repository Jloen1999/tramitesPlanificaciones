# AMPLIACIÓN DE MATEMÁTICAS

Profesor: Mario Martínez Pizarro

Departamento de Matemáticas. Despacho 25

Url Campus: [AMA](https://campusvirtual.unex.es/zonauex/avuex/course/view.php?id=8467)

Correo: mariomp@unex.es

Grupo: A(Lab I): 12-13

Pareja: Fredy

*Poner en asunto de los correos al profe: AMA I

- SAGE

:point_right:  [Url Sage](https://sage-cum.unex.es:8015/)

- Credenciales Sage:

  - Username: GIT21jelanang
  - !Password: Y7369285
  - User Teacher: mariomp2223

<span style="color:red">Tutoria:</span>

![tutoria](Doc_Img/tutoria.png)


# APUNTES

## Tema 1:  Teoría en Grafos

<p style="color: green">Publicado el 13/09/2022</p>

¿Qué es un grafo? Es un conjunto de objetos llamados vértices o nodos unidos por enlaces llamados aristas o arcos, que permiten representar relaciones binarias entre elementos de un conjunto.

Año de creación: 1735

Creador: Leonard Euler

- El problema de los puentes de Konigsberg:
  También llamado el problema de los 7 puentes de Königsberg, es un problema matemático que consistía en encontrar un recorrido para cruzar a pie toda la ciudad pasando solo una vez por cada uno de los puentes y regresando al mismo punto de inicio. Dicho problema se resuelve a través de los grafos eulerianos.

![img.png](Doc_Img/img_7.png)

¿Qué permiten los grafos? Permiten modelizar situaciones para saber si los objetos están relacionados.

- Aplicaciones de un grafo:
  - Redes
  - Diagramas de flujo
  - Bases de Datos
  - etc...

<img src="Doc_Img/img_2.png" alt="imagen2" width="530px" height="300" style="margin-left: 50px">

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

  - Isomorfos: si tengo dos grafos, renombro los vértices y aristas del primero obtenemos el segundo. También tienen que tener los mismos ciclos y las imágenes tienen que ser las mismas.

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
  - Listas:

    <img style="margin-left: 100px" src="Doc_Img/img_9.png" alt="img9">

    - Lista de incidencia: Se enumeran las aristas.

      <img style="margin-left: 100px" src="Doc_Img/img_10.png" width="300px" alt="img10">
    - Lista de adyacencia: Se enumeran los vértices adyacentes.

      <img style="margin-left: 100px" src="Doc_Img/img_11.png" width="300px" alt="img11">
  - Matriz: los grafos se pueden representar mediante una matriz.

    - Propiedades:

      - Una matriz nos permite saber el total de caminos diferentes en un grafo, multigrafo o digrafo G, de longitud r, desde el vértice v<sub>i</sub> al v<sub>j</sub>, es igual al elemento a<sub>ij </sub>∈ A<sup>r</sup>
      - La suma de los elementos de la diagonal principal de A<sup>2</sup> equivale a la suma de los grados de todos los vértices de G.

      <img style="margin-left: 100px" src="Doc_Img/img_17.png" alt="img17">

      <img style="margin-left: 100px" src="Doc_Img/img_18.png" alt="img18">

      <img style="margin-left: 100px" src="Doc_Img/img_19.png" alt="img19">
  - Matriz de incidencia: Se representan las aristas. -1 del vértice que sale y 1 al vértice que llega.

    - Grafo:

      <img style="margin-left: 100px" src="Doc_Img/img_14.png" alt="img14">

      <img style="margin-left: 100px" src="Doc_Img/img_12.png" width="250px" alt="img12">
    - Digrafo:

      <img style="margin-left: 100px" src="Doc_Img/img_13.png" width="250px" alt="img13">

      <img style="margin-left: 100px" src="Doc_Img/img_21.png" width="250px" alt="img21">

<span style="color: red">DUDA: En una matriz de incidencia se supone que las columnas son las aristas y las filas los vértices, entonces no entiendo, por qué en el ejemplo del tema 1 aparece al revés.</span>

<span style="color: green">DUDA RESUELTA: En una matriz de incidencia las columnas pueden representar las aristas o vértices, depende de lo que queramos hacer con la matriz.</span>

- Matriz de adyacencia: En la posición (i, j) hay un 1 si las aristas i, j son adyacentes.
  - Nos permite saber

<span style="color: blue">NOTA:Si el grafo no es dirigido la matriz va a ser simétrica.</span>

<img style="margin-left: 100px" src="Doc_Img/img_15.png" alt="img15">

<img style="margin-left: 100px" src="Doc_Img/img_16.png" alt="img16">

<img style="margin-left: 100px" src="Doc_Img/isomorfiaPermutacion.png" alt="isomorfía Permutaciones">

- Grado de un vértice: Es el número de aristas que lo tienen como extremo.

  - Ejemplo:

  <img style="margin-left: 100px" src="Doc_Img/grado.png" alt="grado">

  En el grado de la figura: gr(a) = 3, gr(b) = 3, gr(c) = 3, gr(d) = 4

  - Secuencia de grados de un grafo: es la lista (decreciente) de los grados del grafo.
    (4,3,3,3,3)
    - Si dos grafos son isomorfos, entonces tienen la misma secuencia de grados, pero dos grafos pueden tener la misma secuencia de grados y no ser isomorfos.

      <img style="margin-left: 100px" src="Doc_Img/NOisomorfos.png" alt="No isomorfos">
    - Propiedades:

      - La suma de los grados es igual al doble del número de aristas.
      - En particular, la suma de los grados es un número par.
      - Algoritmo de Havel-Hakimi: Para determinar si una secuencia de números naturales n<sub>1</sub> >= n<sub>2</sub> ... >= n<sub>k</sub> >= 0 es la secuencia de grados de un grafo, debemos usar el siguiente algoritmo:
        - Si todos los elementos son cero, terminamos con respuesta afirmativa. En caso contrario:
          - Eliminamos n<sub>1</sub> de la secuencia y restamos 1 a (los primeros) n<sub>1</sub> elementos.
          - Si algún entero toma valor negativo, terminamos con respuesta negativa.
          - Reordenamos la secuencia de mayor a menor.
          - Volvemos al primer paso.

            <img style="margin-left: 100px" src="Doc_Img/algoritmoHakimi.png" alt="Algoritmo Havel-Hakimi">
- Grafo Completo: es un grafo tal que todos los pares de vértices están conectados.

  Denotamos K<sub>n</sub> al grafo completo de n vértices.

  <img style="margin-left: 100px" src="Doc_Img/grafoCompleto.png" alt="Grafo Completo">
- Grafo k-regular: Es todo grafo tal que todos sus vértices tienen grado k.

  Todo grafo completo K<sub>n</sub> es n-1 regular, es decir, todo grafo completo es regular pero no todo grafo regular es completo.

<img style="margin-left: 100px" src="Doc_Img/grafoRegular.png" alt="Grafo Regular">

<img style="margin-left: 100px" src="Doc_Img/ejemploRepaso1.jpeg" alt="ejemplo Repaso 1">

<img style="margin-left: 100px" src="Doc_Img/ejemploRepaso2.jpeg" alt="ejemplo Repaso 2">

- Caminos en un grafo:

  - Camino: Sucesión finita de vertices de modo que cada dos consecutivos son adyacentes.
  - Longitud: Es el número de aristas dentro de un camino.
  -
  -
- Grafo euleriano: Es aquel en el que existe un circuito que recorre todas las aristas.
- Toda secuencia de grados de un grafo que tiene grados pares es euleriano.
- Todo grafo euleriano tiene secuencia de grados pares
- Grafo Hamiltoniano: existe un ciclo.

  - Ciclo: Camino cerrado que recorra todos los vértices sin que se repita ningún vértice salvo el extremo.
- Ejemplos:

```mermaid
graph LR
A-->B
B-->C
C-->D
D-->E
E-->F
```
