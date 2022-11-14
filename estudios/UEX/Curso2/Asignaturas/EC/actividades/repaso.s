.data 
	array: .word 23, 34, 45, 2, 3
	size: .word 5
	string: .asciiz "\nEl elemento mayor es: "
	string1: .asciiz "Mostramos todos los elementos del array: "
	coma: .asciiz ","
	
.text
	.globl main

main:
      la $a0, string1
      li $v0, 4
      syscall
      
      li $t0, 0
      lw $t1, size($t0)
      la $a1, array
      bucle1:	 
      		lw $a0, 0($a1)
      		li $v0, 1
      		syscall
      		la $a0, coma
      		li $v0, 4
      		syscall
      		
      		
      		addi $t0, $t0, 1
      		addi $a1, $a1, 4
      		ble $t0, $t1, bucle1 
	     		
		
	li $t0, 0
	lw $t1, size($t0)
	li $s0, 0
	la $a1, array

	
bucle:	bge $t0, $t1, showBigElement
	lw $t2, 0($a1)
	ble $t2, $s0, increment
	move $s0, $t2
	b bucle
	
	
increment: addi $t0, $t0, 1
	   addi $a1, $a1, 4
	   b bucle
	



showBigElement:	la $a0, string
		li $v0, 4
		syscall
		
		move $a0, $s0
		li $v0, 1
		syscall
		
		li $v0, 10
		syscall
