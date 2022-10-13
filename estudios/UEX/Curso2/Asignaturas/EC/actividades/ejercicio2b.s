#Realizar un programa en ensamblador del MIPS que cargue en una zona
#de datos en memoria(etiquetados como "array" los siguientes enteros de
# 8 bits: 2, 4, 6, 8, 10. A continuacion el programa debe cargar en el registro
# t0 el dato array[2] (6) y en el registro t1 el dato array[4] (10)

.data
       array: 2, 4, 6, 8, 10

.text
.globl main
main:
    lb $t0, array+2
    li $t3, 2
    lb $t0, array($t3)

    lb $t1, array+4
    li $t3, 4
    lb $t1, array($t3)




