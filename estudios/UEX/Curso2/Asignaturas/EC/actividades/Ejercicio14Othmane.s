#mostrar vector desordenado
.data
	a: .word 40, 70, 3, 20, 30, 9
	coma: .asciiz ","
	salto: .asciiz "\n"
	tam: .word 6

.text
	.globl main

main:
		la $a1, a
        li $t1, 0
		lw $t2, tam($t1)

        show:   bge $t1, $t2, fin_show
                    lw $a0, 0($a1)
                    li, $v0,1
                    syscall
                    la $a0, coma
                    li $v0, 4
                    syscall
                    addi $a1, $a1, 4
                    addi $t1, $t1, 1        #i++
                    b show

        fin_show:   la $a0, salto
                        li $v0, 4
                        syscall

		li $t0, 0

mientras:	bnez $t0, fin_mientras
            li $t0, 1
            li $t3, 0
            sub $t4, $t2, 2
		
desde: 		bgt $t3, $t4, fin_desde
            sll $t5, $t3, 2
            lw $t6, a($t5)
            lw $t7, a+4($t5)
            ble $t6, $t7, no_intere
            sw $t7, a($t5)
            sw $t6, a+4($t5)
            li $t0, 0
		
no_intere: 	addi $t3, $t3, 1
		    b desde
		
fin_desde: 	b mientras

fin_mientras:   la $a1, a
                li $t1, 0
                lw $t2, tam($t1)
                show1:   bge $t1, $t2, fin_show1
                            lw $a0, 0($a1)
                            li, $v0,1
                            syscall
                            la $a0, coma
                            li $v0, 4
                            syscall
                            addi $a1, $a1, 4
                            addi $t1, $t1, 1        #i++
                            b show1

                fin_show1:   li $v0, 10
                                syscall
