.data
dato1: .word 6
dato2: .word 3
dato3: .word 2
dato4: .word 5
res1: .space 4
res2: .space 4

.text
    .globl main

main:
    lw $a0, dato1($0)
    lw $a1, dato2($0)
    jal suma
    sw $v0, res1($0)

    lw $a0, dato3($0)
    lw $a1, dato4($0)
    jal suma
    sw $v0, res2($0)
    li $v0, 10
    syscall

suma:   #add $v0, $a0, $a1
        #jal otra_rutina
        #jr $ra

        #Primero apilamos
        addi $sp, $sp, -4
        sw $ra, 0($sp)

        add $v0, $a0, $a1   #Realizamos la suma

        #Luego Desapilamos
        lw $ra, 0($sp)
        addi $sp, $sp, 4
        jr $ra



otra_rutina: #rutina vacia
             jr $ra
