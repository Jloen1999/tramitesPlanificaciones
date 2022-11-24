.data
    A: .word 6, 5, 4, 3, 2, 1
    B: .word 1, 2, 3, 4, 5, 6
    size: .word 6
    res: .space 4

.text
    .globl main

main:   lw $a2, size($0)
        la $a0, A
        la $a1, B
        jal sumatorio
        li $v0, 10
        syscall

sumatorio:  #Apilamos
            addi $sp, $sp, -16
            sw $ra, 0($sp)
            sw $a0, 4($sp)
            sw $a1, 8($sp)
            sw $a2, 12($sp)

            move $t0, $a0
            move $t1, $a1
            move $t2, $a2
            li $t3, 1

        for: bgt $t3, $a2, fin
             lw $a0, 0($t0)
             lw $a1, 0($t1)
             jal suma
             add $t4, $t4, $v0
             addi $t3, $t3, 1
             addi $t1, $t1, 4
             addi $t0, $t0, 4
             j for

       fin: move $v0, $t4
            lw $ra, 0($sp)
            lw $a0, 4($sp)
            lw $a1, 8($sp)
            lw $a2, 12($sp)
            addi $sp, $sp, 16
            jr $ra

suma:   add $v0, $a0, $a1
        jr $ra



