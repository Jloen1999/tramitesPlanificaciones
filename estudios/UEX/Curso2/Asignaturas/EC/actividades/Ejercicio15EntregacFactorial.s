#Factorial de un numero

.text
    .globl main

main:
    sw $fp, 0($sp)
    subu $sp, $sp, 32
    addi $fp, $sp, 32
    sw $ra, -4($fp)

    li $a0, 3
    jal fact
    move $a0, $v0
    li $v0, 1
    syscall
    lw $ra, -4($fp)
    addu $sp, $sp, 32
    lw $fp, 0($sp)
    jr $ra



fact:   sw $fp, 0($sp)
        subu $sp, $sp, 32
        addi $fp, $sp, 32
        sw $ra, -4($fp)
        sw $a0, -8($fp)

        lw $v0, -8($fp)
        bgtz $v0, l2
        li $v0, 1
        j l1

l2:    lw $v1, -8($fp)
        subu $v0, $v1, 1
        move $a0, $v0
        jal fact
        lw $v1, -8($fp)
        mul $v0, $v0, $v1

l1:     lw $ra, -4($fp)
        addu $sp, $sp, 32
        lw $fp, 0($sp)

        jr $ra

