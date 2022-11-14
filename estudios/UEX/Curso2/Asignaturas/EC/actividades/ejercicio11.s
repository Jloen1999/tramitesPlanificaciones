#Implementación condición if then

.data
        a: .word -12, 5, 34, 75, 10, -25
        size: .word 6
        salida1: .asciiz "\nTotal de numeros positivos: "
        salida2: .asciiz "\nTotal de numeros negativos: "

.text
    .globl main

main:
    li $t0, 0   #npos: contador de numeros positivos
    li $t1, 0   #nneg   contador de numeros negativos
    li $t2, 0   #indice
    li $t3, 0   #$t3 almacena el elemento del array
    lw $s0, size  #$s0 almacena el tamaño del array

bucle:      bge $t2, $s0, fuera_bucle
            mul $s1, $t2, 4
            lw $t3, a($s1)  #Almacenamos el elemento actual del array en $t3
            bgez $t3, positivos    #Si $t3 es mayor o igual que 0 saltamos a la etiqueta positivos
            addi $t1, $t1, 1    #En caso contrario incrementamos el contador de números negativos
            b fuera_switch  #Salto incondicional a la etiqueta fuera_switch para incrementar el índice de la iteración


positivos:     addi $t0, $t0, 1  #Incrementamos el contador de números positivos
               b fuera_switch

fuera_switch:   addi $t2, $t2, 1    #Incrementamos el índice de la iteración del bucle.
                b bucle     #Hacemos un salto incondicional al bucle para repetir el proceso hasta que el índice de iteración sea mayor o igual al tamaño del array


fuera_bucle: la $a0, salida1
             li $v0, 4
             syscall
             #Mostramos el contador de números positivos
             move $a0, $t0
             li $v0, 1
             syscall
             la $a0, salida2
             li $v0, 4
             syscall
             #Mostramos el contador de números negativos
             move $a0, $t1
             li $v0, 1
             syscall
             #Salida del programa
             li $v0, 10
             syscall





