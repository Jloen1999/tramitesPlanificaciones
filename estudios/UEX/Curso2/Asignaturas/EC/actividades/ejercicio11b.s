#Implementación condición if then

.data
        array: .word -12, -5, 34, 75, -10, -25
        size: .word 6
        salida1: .asciiz "\nTotal de numeros positivos: "
        salida2: .asciiz "\nTotal de numeros negativos: "
        corchete1: .asciiz "["
        coma: .asciiz ","
        corchete2: .asciiz "]"

.text
    .globl main

main:
    li $t6, 0
    li $t7, 0
    lw $t2, size($t6)
    la $a0,corchete1    #Imprime corchete abierto
    li, $v0,4
    syscall

    imprimir:   #Mostramos todos los elementos del array para comprobar la salida de la ejecución del programa

                        lw $a0, array($t6)     #Imprime el elemento del array
                        li, $v0,1
                        syscall

                        la $a0,coma                             #Imprime coma
                        li, $v0,4
                        syscall

                        addi $t6, $t6, 4
                        addi $t7, $t7, 1        #i++
                        blt $t7, $t2, imprimir

                        la $a0,corchete2    #Imprime corchete cerrado
                        li, $v0,4
                        syscall

    #Pasamos lor argumentos o parámetros al procedimiento calcular
    la $a0, array   #Cargamos la dirección del array en el argumento $a0
    lw $a1, size   #Cargamos el tamaño del array en el argumento $a1
    li $a2, 0   #Inicializamos a 0 el contador de números positivos el argumento $a2
    li $a3, 0   #Inicializamos a 0 el contador de números negativos en el argumento $a3
    jal calcular    #Hacemos un salto incondicional a la función calcular guardando la dirección de la siguiente instrucción en el registro $ra

    #Imprimimos "\nTotal de numeros positivos: "
    la $a0, salida1
    li $v0, 4
    syscall
    #Mostramos el contador de números positivos
    move $a0, $a2
    li $v0, 1
    syscall
    #Imprimimos "\nTotal de numeros negativos: "
    la $a0, salida2
    li $v0, 4
    syscall
    #Mostramos el contador de números negativos
    move $a0, $a3
    li $v0, 1
    #Salida del programa
    syscall
    li $v0, 10
    syscall

calcular:
            li $t0, 0   #$t0 es el indice de iteración
            bucle:
                bge $t0, $a1, fuera_bucle
                lw $t1, 0($a0)  #Almacenamos el elemento actual del array en el regsitro temporal $t2
                bgez $t1, positivos    #Comparamos
                addi $a3, $a3, 1    #Incrementamos el contador de número de negativos
                b fuera_switch  #Salto incondicional a la etiqueta fuera_switch para incrementar el índice y la dirección de la palabra actual.
                positivos:  addi $a2, $a2, 1    #Incrementamos el contador de número de positivos
                            b fuera_switch

            fuera_switch:
                #Incrementamos el índice de la iteración del bucle y la dirección de la palabra actual del array
                addi $a0, $a0, 4
                addi $t0, $t0, 1
                b bucle     #Hacemos un salto incondicional al bucle para repetir el proceso hasta que el índice de iteración sea mayor o igual al tamaño del array

            fuera_bucle:  jr $ra    #Hacemos un salto a la siguiente instrucción del jal <etiqueta(calcular)>







