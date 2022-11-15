.data
	array: 34, 45, 23, 56
	size: 4
	string1: .asciiz "0.- Impresion Array con variable\n1.- Impresion Array con Registro\n"
	string2: .asciiz "Introduce una opcion 0 o 1: "
	opcion: .space 2
	
.text
	.globl main

main:	la $a0, string1
	li $v0, 4
	syscall
	
	la $a0, string2
	li, $v0, 4
	syscall
	
	la $a1, opcion
	li $v0, 5
	syscall
	
	sw $v0, 0($a1)
	lw $a0, opcion
	li, $v0, 1
	syscall	
