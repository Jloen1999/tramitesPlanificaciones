.data
string: .asciiz "¡Hola Mundo!\n"
item: .word 99
array: .word 11, 22, 33, 44, 55, 66, 77, 88, 99
	.text
	.globl main
main:
la $a0,string
li, $v0,4
syscall


lw $a0,item
li, $v0,1
syscall


li, $v0,5
syscall


li, $v0,8
la $a0,string
li, $a1,9
syscall

li, $v0,4
syscall

li, $t0,3
li, $t1,4
mul $t2,$t1,$t0
lw $a0, array($t2)
li $v0,1
syscall

li, $v0,10
syscall