#mostrar vector desordenado
.data
	array: .word 45, 56, 12, 15, 5, 3
	desordenado: .asciiz "Array Desordenado: "
	ordenado: .asciiz "\nArray Ordenado: "
	espacio: .asciiz " "

.text
	.globl main

main:
		#Mostramos todos los elementos del array para comprobar la salida de la ejecución del programa
		li $t0, 6   #tamaño del array
		li $t1, 0   #increment 4
		li $t2, 0   #index
		la $a0, desordenado    #Imprimimos "Array Desordenado: "
        li $v0, 4
        syscall

        imprimir:
                    lw $a0, array($t1)     #Imprime el elemento del array
                    li, $v0,1
                    syscall
                    la $a0, espacio     #Imprimos el caracter espacio
                    li $v0, 4
                    syscall
                    addi $t1, $t1, 4    #Saltamos de word en word
                    addi $t2, $t2, 1    #Incrementamos el indice para iterar
                    blt $t2, $t0, imprimir  #Comparamos el indice con el tamaño del array

		    li $t1, 0   #Inicializamos nuevamente el indice
mientras:	bnez $t1, fin_mientras
		    li $t1, 1   #Bandera a 1(false)
            li $t2, 0   #subIndice
            sub $t3, $t0, 2     #restamos el tamaño del array 2 unidades porque estaremos comparando elementos de 2 en 2
		
desde: 		bgt $t2, $t3, fin_desde #Comparamos el
            sll $t4, $t2, 2 #Obtenemos la direccion del siguiente elemento del array, es lo mismo que hacer un mul de 4
            lw $t5, array($t4)  #Obtenemos un elemento del array
            lw $t6, array+4($t4)    #Obtenemos el siguiente elemento del array
            ble $t5, $t6, incre #Comparamos ambos elementos obtenidos
            sw $t6, array($t4)  #Hacemos el cambio de posicion de ambos elementos
            sw $t5, array+4($t4)
            li $t1, 0   #Cambiamos la bandera a 0(true)
		
incre: 	addi $t2, $t2, 1    #Incrementamos el subIndice
		    b desde
		
fin_desde: 	b mientras

fin_mientras: 	li $t1, 0
                li $t2, 0
                la $a0, ordenado #Imprimimos "Array Ordenado: "
                li $v0, 4
                syscall
                imprimir1:
                        	lw $a0, array($t1)     #Imprime el elemento del array
                        	li, $v0,1
	                        syscall
	                        la $a0, espacio
	                        li $v0, 4
	                        syscall
              		        addi $t1, $t1, 4
                        	addi $t2, $t2, 1        #i++
                        	blt $t2, $t0, imprimir1

                            li $v0, 10  #Salir del programa
                            syscall