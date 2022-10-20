# Ejercicio 6
# a) Comprobar en el simulador, ejecutando el programa paso a paso y observando el contenido de $ra y de PC en la ventana de registro y las direcciones de las instrucciones en la ventana de texto, si se cumple la siguiente afirmacion
    #Respuesta:  ra = 400040   PC = 400054
# b) Comprobar en el simulador, observando el cambio en el contador de programa, si se cumple la siguiente afirmacion. Se cumple poniendo en el contador del programa la direccion de la siguiente instruccion a ejecutar que es la ue guarda el registro ra.
# "Mediante la instruccion etiquetada por ipx, se esta retornando a la instruccion siguiente a la que hizo la llamada a la rutina ip"

# c) ¿Cuantas veces se ejecuta la instruccion b ip1? Se ejecuta 4 veces

# d) Dibujar un diagrama de flujo que describa las operaciones realizadas en el codifo ensamblador.




.text
.globl main

main:
    la $a0, x   #$0<-- direccion base del array x
    la $a1, y   #$1<-- direccion base del array y
    lw $a2, size    #$a2 <-- tamaño del array = n
    jal ip  #invoca rutina ip, guarda en $ra dir de vuelta
    move $a0, $v0   #escribe en consola el resultado (que ip dejo en $v0)
    li $v0, 1
    syscall
    #-----------#Fin de la ejecucion del programa
    li $v0, 10
    syscall

ip: li $v0, 0       #Inicializa sum a 0. $v0 guardara el resultado
                    #que devuelve la rutina
    li $t3, 0       #$t3: indice de los elementos del array(1)

ip1: bge $t3, $a2, ipx  #sale cuando i >= n
     lw $t0, 0($a0)     #$t0 <-a0(i)
     lw $t1, 0($a1)     #$t1 <-a1(i)
     mul $t2, $t0, $t1
     add $v0, $v0, $t2
     add $a0, $a0, 4
     add $a1, $a1, 4
     add $t3, $t3, 1        #i++
     b ip1          #cierra bucle (salto incond a ip1)

ipx: jr $ra         #retorna al invocador

.data
    size: .word 4
    x: .word 1, 3, 5, 7
    y: .word 2, 4, 6, 8
