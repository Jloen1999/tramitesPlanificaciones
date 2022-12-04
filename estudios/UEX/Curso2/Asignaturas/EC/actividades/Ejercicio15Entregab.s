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
            sw $fp, 0($sp)
            move $fp, $sp
            addi $sp, $sp, -20
            sw $ra, -4($fp)
            sw $a0, -8($fp)
            sw $a1, -12($fp)
            sw $a2, -16($fp)

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

       fin: #Desapilamos
            move $v0, $t4
            lw $a2, -16($fp)
            lw $a1, -12($fp)
            lw $a0, -8($fp)
            lw $ra, -4($fp)
            move $sp, $fp
            lw $fp, 0($sp)  #o lw $fp, 0($fp)
            jr $ra

suma:   add $v0, $a0, $a1
        jr $ra



