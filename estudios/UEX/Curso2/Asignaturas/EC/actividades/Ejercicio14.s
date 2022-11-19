#mostrar vector desordenado
.data:
	a: .word 45, 56, 12, 56, 5, 3
	ordenado: .asciiz "Array Ordenado\n"
        desordenado: .asciiz "Array Desordenado\n"
	espacio: .asciiz " "
	salto: .asciiz "\n"

.text:
	.globl main

main:
		#Mostramos todos los elementos del array para comprobar la salida de la ejecución del programa
		li $t0, 6
		li $t1, 0 
		li $t2, 0
		la $a0, ordenado
	        li $v0, 4
	        syscall
                imprimir:
                        	lw $a0, a($t1)     #Imprime el elemento del array
                        	li, $v0,1
	                        syscall
	                        la $a0, espacio
	                        li $v0, 4
	                        syscall
              		        addi $t1, $t1, 4
                        	addi $t2, $t2, 1        #i++
                        	blt $t2, $t0, imprimir
                        	la $a0, salto
	                        li $v0, 4
	                        syscall
                		
		li $t1, 0
		li $t0, 6

mientras:	bnez $t1, fin_mientras
		li $t1, 1
		li $t2, 0
		sub $t3, $t0, 2
		
desde: 		bgt $t2, $t3, fin_desde
		sll $t4, $t2, 2
		lw $t5, a($t4)
		lw $t6, a+4($t4)
		ble $t5, $t6, no_intere
		sw $t6, a($t4)
		sw $t5, a+4($t4)
		li $t1, 0
		
no_intere: 	addi $t2, $t2, 1
		b desde
		
fin_desde: 	b mientras

fin_mientras: 	li $t0, 6
		li $t1, 0 
		li $t2, 0
                la $a0, desordenado
	        li $v0, 4
	        syscall
                imprimir1:
                        	lw $a0, a($t1)     #Imprime el elemento del array
                        	li, $v0,1
	                        syscall
	                        la $a0, espacio
	                        li $v0, 4
	                        syscall
              		        addi $t1, $t1, 4
                        	addi $t2, $t2, 1        #i++
                        	blt $t2, $t0, imprimir1
                        	la $a0, salto
	                        li $v0, 4
	                        syscall
		                li $v0, 10
                                syscall