#mostrar vector desordenado
.data
	vector: .word 18, 13, 2, 45, 5, 70
	espacio: .asciiz " "
    string1: .asciiz "Desordenado: \n"
	string2: .asciiz "\nOrdenado: \n"

.text
	.globl main

main:
	    la $a0, vector
        li $a1, 6
        la $a2, espacio
        la $a3, string1
        jal imprimir
        
        la $a0, vector
        li $a1, 6
        jal ordenar

        la $a0, vector
        li $a1, 6
        la $a2, espacio
        la $a3, string2
        syscall
        jal imprimir
        
        li $v0, 10
        syscall

ordenar:    li $t1, 0
		    mientras:	move $s1, $a0
                        bnez $t1, fin_mientras
                        li $t1, 1
                        li $t2, 0
                        sub $t3, $a1, 2

		    desde: 		bgt $t2, $t3, fin_desde
                        lw $t5, 0($s1)
                        addi $s2, $s1, 4
                        lw $t6, 0($s2)
                        ble $t5, $t6, no_interc
                        sw $t6, 0($s1)
                        sw $t5, 0($s2)
                        li $t1, 0

            no_interc: 	addi $t2, $t2, 1
                        addi $s1, $s1, 4
                        b desde

            fin_desde: 	b mientras

            fin_mientras: 	jr $ra


imprimir:	li $t0, 0

		                move $s3, $a0

                        move $a0, $a3
                        li $v0, 4
                        syscall
            bucle:      bge $t0, $a1, fin_bucle
                        lw $a0, 0($s3)
                        li $v0, 1
                        syscall
                        move $a0, $a2
                        li $v0, 4
                        syscall
                        addi $t0, $t0, 1
                        addi $s3, $s3, 4
                        b bucle

            fin_bucle:	jr $ra

