#mostrar vector desordenado
.data
	array: .word 45, 56, 12, 15, 5, 3
	string_ord: .asciiz "\nArray Ordenado: ["
    string_desor: .asciiz "Array Desordenado: ["
	coma: .asciiz ","
	corcheteCerrado: .asciiz "]"
	size: .word 6

.text
	.globl main

main:   li $t0, 0
        la $a0, string_desor
        li $v0, 4
        syscall
	
	    la $a0, array   #Cargamos la dirección del array en el argumento $a0
        lw $a1, size($t0)   #Cargamos el tamaño del array en el argumento $a1
        la $a2, coma
        la $a3, corcheteCerrado
        jal imprimir	#Llamada a procedimiento
        
        la $a0, array   #Cargamos la dirección del array en el argumento $a0
        lw $a1, size($t0)   #Cargamos el tamaño del array en el argumento $a1
        jal ordenar	#Llamada a procedimiento
        
        la $a0, string_ord
        li $v0, 4
	    syscall
        
        la $a0, array   #Cargamos la dirección del array en el argumento $a0
        lw $a1, size($t0)   #Cargamos el tamaño del array en el argumento $a1
        la $a2, coma
        la $a3, corcheteCerrado
        jal imprimir	#Llamada a procedimiento
        
        li $v0, 10	#Close Program
        syscall



ordenar:    li $t1, 0
		    mientras:	move $s2, $a0
                        bnez $t1, fin_mientras
                        li $t1, 1
                        li $t2, 0
                        sub $t3, $a1, 2

		    desde: 		bgt $t2, $t3, fin_desde
                        lw $t5, 0($s2)
                        addi $s3, $s2, 4
                        lw $t6, 0($s3)
                        ble $t5, $t6, no_interc
                        sw $t6, 0($s2)
                        sw $t5, 0($s3)
                        li $t1, 0

            no_interc: 	addi $t2, $t2, 1
                        addi $s2, $s2, 4
                        b desde

            fin_desde: 	b mientras

            fin_mientras: 	jr $ra


#Mostramos todos los elementos del array para comprobar la salida de la ejecución del programa

imprimir:	li $s0, 0
            li $t1, 1
            sub $t2, $a1, $t1   #Restamos una unidad al tamaño para evitar imprimir una coma de más

		                move $s1, $a0   #Movemos la direccion del array contenido en $a0 al registro $s1

            bucle:      bge $s0, $a1, fin_bucle
                        lw $a0, 0($s1)     #Imprime el elemento del array
                        li $v0, 1
                        syscall
                        blt $s0, $t2, show_coma #Imprimos la coma el numero de veces como tamaño de array -1
                        b fin_bucle
            show_coma:
                        move $a0, $a2   #Imprimimos la coma
                        li $v0, 4
                        syscall
                        addi $s0, $s0, 1
                        addi $s1, $s1, 4        #i++
                        b bucle

            fin_bucle:	move $a0, $a3   #Cerramos corchete
                        li $v0, 4
                        syscall
                        jr $ra

