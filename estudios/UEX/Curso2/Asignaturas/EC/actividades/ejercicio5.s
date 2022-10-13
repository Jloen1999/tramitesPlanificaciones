.data
array: .word 6, 8, 10, 12
string: .asciiz "Introduce un entero: \n"
string1: .asciiz "Mostrar array:\n "
salto: .asciiz "\n"
	.text
	.globl main
main:
la $a0,string
li, $v0,4
syscall

li, $v0,5
syscall

li $t3, 4
sw $v0, array($t3)

la $a0,string1
li, $v0,4
syscall

lw $a0, array($zero)
li $v0, 1
syscall

lw $a0, array+4
li $v0, 1
syscall

lw $a0, array+8
li $v0, 1
syscall

lw $a0, array+12
li $v0, 1
syscall

#Con salto de linea
la $a0,salto
li, $v0,4
syscall
lw $a0, array($zero)
li $v0, 1
syscall
la $a0,salto
li, $v0,4
syscall

lw $a0, array+4
li $v0, 1
syscall
la $a0,salto
li, $v0,4
syscall

lw $a0, array+8
li $v0, 1
syscall
la $a0,salto
li, $v0,4
syscall

lw $a0, array+12
li $v0, 1
syscall

li, $v0,10
syscall









li, $v0,10
syscall