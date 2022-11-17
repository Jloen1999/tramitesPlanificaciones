#mostrar vector desordenado
.data:
	array: .word 45, 56, 12, 56, 5, 3
	size: .word 6
	ordenado: .asciiz "Array Ordenado\n"
        desordenado: .asciiz "Array Desordenado\n"
	espacio: .asciiz " "
	salto: .asciiz "\n"

.text:
	.globl main

main:
        la $a0, ordenado
	li $v0, 4
	syscall
	la $a1, array   #Cargamos la dirección del array en el argumento $a1
        lw $a2, size   #Cargamos el tamaño del array en el argumento $a2
        jal imprimir
        
        la $a1, array   #Cargamos la dirección del array en el argumento $a1
        lw $a2, size   #Cargamos el tamaño del array en el argumento $a2
        jal ordenar
        
	li $v0, 10
	syscall



ordenar:
		li $t1, 0
		mientras:	bnez $t1, fin_mientras
			        li $t1, 1
				li $t2, 0
				sub $t3, $a2, 2

		desde: 		bgt $t2, $t3, fin_desde
				lw $t5, 0($a1)
				lw $t6, 4($a1)
				ble $t5, $t6, no_intere
				sw $t6, 0($a1)
				sw $t5, 4($a1)
				li $t1, 0

		no_intere: 	addi $t2, $t2, 1
				b desde

		fin_desde: 	b mientras
                
		fin_mientras: 	la $a0, desordenado
				li $v0, 4
				syscall
				li $t1, 0
				la $a1, array   #Cargamos la dirección del array en el argumento $a1
				lw $a2, size   #Cargamos el tamaño del array en el argumento $a2
                		show1:
                        		lw $a0, 0($a1)     #Imprime el elemento del array
                        		li $v0, 1
	                        	syscall
	                        	la $a0, espacio
	                        	li, $v0, 4
	                        	syscall
              		        	addi $t1, $t1, 1
                        		addi $a1, $a1, 4        #i++
                        		blt $t1, $a2, show1
                        		la $a0, salto
	                        	li, $v0, 4
	                        	syscall
			        	jr $ra
				jr $ra



imprimir:
			#Mostramos todos los elementos del array para comprobar la salida de la ejecución del programa
		li $t1, 0
                show:
                        	lw $a0, 0($a1)     #Imprime el elemento del array
                        	li $v0, 1
	                        syscall
	                        la $a0, espacio
	                        li, $v0, 4
	                        syscall
              		        addi $t1, $t1, 1
                        	addi $a1, $a1, 4        #i++
                        	blt $t1, $a2, show
                        	la $a0, salto
	                        li, $v0, 4
	                        syscall
			        jr $ra

