#Modificar el ejercicio 5 para mostrar los elementos del array empleando un
#bucle (utilizando instrucciones de salto condicionales

.data
    size: .word 4
    array: .word 6, 8, 10, 12
    string: .asciiz "Introduce un entero: \n"
    string1: .asciiz "Mostrar array:\n "
    salto: .asciiz "\n"

.text
	.globl main
    main:
    la $a0,string
    li, $v0,4
    syscall

    li, $v0,5
    syscall

    li $t3, 4
    sw $v0, array($t3)

    la $a0,string1
    li, $v0,4
    syscall

    lw $a0, array($zero)
    li $v0, 1
    syscall

    lw $a0, array+4
    li $v0, 1
    syscall

    lw $a0, array+8
    li $v0, 1
    syscall

    lw $a0, array+12
    li $v0, 1

    la $a0,salto
    li, $v0,4
    syscall

    lw $a1, array   #$1<-- direccion base del array
    lw $a2, size    #$a2 <-- tamaño del array = n
    li $t1, 0
    li $t2, 0

imprimir:
    lw $a0, array($t1)
    li, $v0,1
    syscall
       #Con salto de linea
    la $a0,salto
    li, $v0,4
    syscall

    add $t1, $t1, 4
    add $t2, $t2, 1        #i++
    blt $t2, $a2, imprimir

li, $v0,10
syscall










