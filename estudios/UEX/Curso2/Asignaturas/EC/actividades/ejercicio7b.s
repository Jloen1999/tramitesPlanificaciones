.data
    array1: .word 8, 9, 16, 17
    array2: .word 4, 5, 6, 7
    result: .space 16
    size: .word 4
    string: .asciiz "Introduce una opcion 0|1: \n"
    string1: .asciiz "Elemento "
    puntos: .asciiz ": "
    salto: .asciiz "\n"
    pos: .word 1, 2, 3, 4
    suma: .asciiz "Suma de elementos\n"
    resta: .asciiz "Resta de elementos\n"
    ceros: .asciiz "No es ni suma ni resta\n"

.text
    .globl main

    main:
    la $a0, string   #Mostramos mensaje por pantalla
    li, $v0, 4
    syscall

    li, $v0, 5   #Introducimos una opcion
    syscall

    move $a3, $v0   #Guardo la opcion introducida en el registro $a3
    la $a0, array1 #Guardo el array1 en el registro $a0
    la $a1, array2 #Guardo el array2 en el registro $a1
    la $a2, result #Guardo el array resultante en el registro $a2
    jal calculo #Llamo a la funcion guardando la posicion de la siguiente intruccion

    li $t6, 0
    li $t7, 0
    bne $a3, 0, print_resta
                    #Imprime el mensaje "Suma de elementos\n"
    la $a0,suma
    li, $v0,4
    syscall
    imprimir:
                     #imprime el mensaje "Elemento "
        la $a0,string1
        li, $v0,4
        syscall
                    #Imprime el indice+1
        lw $a0, pos($t6)
        li, $v0,1
        syscall
                    #imprime ": "
        la $a0,puntos
        li, $v0,4
        syscall
                    #Imprime el elemento del array
        lw $a0, result($t6)
        li, $v0,1
        syscall

                    #Con salto de linea
        la $a0,salto
        li, $v0,4
        syscall

        addi $t6, $t6, 4
        addi $t7, $t7, 1        #i++
        blt $t7, $t2, imprimir
        li, $v0,10
        syscall

calculo:
    li $t0, 0   #Creo registros contadores: $t0 indice de iteracion de cada uno de los elementos del array
    li $t1, 0   #$t1 indice de stop del bucle
    lw $t2, size($t0)

    bucle:      bge $t1, $t2, fuera_bucle
                lw $t3, 0($a0)  #Almaceno elemento de array1 en $t3
                lw $t4, 0($a1)  #Almaceno elemento de array2 en $t4
                case0:  bne $a3, 0, case1   #inicio del switch
                        add $t5, $t3, $t4
                        sw $t5, 0($a2)
                        b fuera_switch


                case1: bne $a3, 1, otro
                       sub $t5, $t3, $t4
                       sw $t5, 0($a2)
                       b fuera_switch

                otro:
                        li $t5, 0
                        sw $t5, 0($a2)

fuera_switch:   addi $t1, $t1, 1
                addi $a0, $a0, 4
                addi $a1, $a1, 4
                addi $a2, $a2, 4
                b bucle
fuera_bucle: jr $ra

print_ceros:    #Imprime el mensaje "No es ni suma ni resta"
                la $a0,ceros
                li, $v0,4
                syscall
                b imprimir

print_resta:    #Imprime el mensaje "Resta de elementos\n"
                bne $a3, 1, print_ceros
                la $a0,resta
                li, $v0,4
                syscall
                b imprimir





