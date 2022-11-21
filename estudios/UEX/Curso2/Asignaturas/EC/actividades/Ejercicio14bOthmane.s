#mostrar vector desordenado
.data
	a: .word 40, 70, 3, 20, 30, 9
	coma: .asciiz ","
	salto: .asciiz "\n"

.text
	.globl main

main:
	    la $a0, a
        li $a1, 6
        la $a2, coma
        jal show
        
        la $a0, a
        li $a1, 6
        jal ordenar

        la $a0, salto
        li $v0, 4
        syscall
        la $a0, a
        li $a1, 6
        la $a2, coma
        jal show

        li $v0, 10
        syscall

ordenar:    li $t1, 0
            li $t7, 4
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


show:	li $t0, 0

		                move $s3, $a0

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

            fin_bucle:	 jr $ra

