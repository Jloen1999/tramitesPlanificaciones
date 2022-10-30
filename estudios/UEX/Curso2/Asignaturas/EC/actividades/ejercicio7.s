#Bucles y condiciones
#Comprobar la ejecucion del programa en el simulador
#Dibujar un diagrama de flujo que describe las operaciones realizadas en el codigo ensamblador

.data
Badajoz: .asciiz "Badajoz\n"
Caceres: .asciiz "Caceres\n"
Plasencia: .asciiz "Plasencia\n"
Merida: .asciiz "Merida\n"
Otras: .asciiz "Otras\n"

.text
.globl main

main:
    li $s0, 2       #Seleccion de ciudad
    bne $s0, 0, c1
    la $a0, Badajoz
    b cx

c1: bne $a0, 1, c2
    la $a0, Caceres
    b cx
c2: bne $a0, 2, c3
    la $a0, Merida
    b cx
c3: bne $a0, 3, c4
    la $a0, Plasencia
    b cx
c4: la $a0, Otras
cx: li $v0, 4   #Imprime la ciudad
    syscall
    li $v0, 10  #Salida del programa
    syscall




