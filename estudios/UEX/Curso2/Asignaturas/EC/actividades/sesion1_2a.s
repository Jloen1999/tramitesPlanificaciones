#Ejercicio 2.a
.data
valor: .word 5, 10, 15, 20 #Defino array 4 palabras (decimal)
       #valor[2] es 15 = 0xf
ind: .word 1 #Usado como indice del array "valor"
     .byte 0x1a,0x0b,10 #Defino los 3 primeros bytes de la
                        #siguiente palabra (hex. y dec.)
     .align 2 #Alineo el siguiente dato en memoria
              #para que este alineado en palabra
              #(empiece en una palabra)
     .ascii "Hola" #Cadena de caracteres
     .asciiz ",MIPS" #Cadena de caracteres terminada
                    #con el caracter nulo

.text
.globl main
main:
     lw $s0,valor($zero) #Carga en $s0 valor[0]
                         #($s0 <-- valor[0])
                         #Tambien vale: lw $s0, valor
     lw $s4,ind #$s4 <-- indice del array
     mul $s5,$s4,4 #$s5 <-- ind*4
     lw $s1, valor($s5) #$s1 <-- valor[1]
     add $s4,$s4,1 #incrementamos el indice del array
     mul $s5,$s4,4
     lw $s2,valor($s5) #$s2 <-- valor[2]
     add $s4,$s4,1 #incrementamos el indice del array
     mul $s5,$s4,4
     lw $s3,valor($s5) #Ss3 <-- valor 3
	 

#e) valor = 5
# lw $s0,valor($zero) #Carga en $s0 el valor 5
                         #($s0 <-- valor[0])
                         #Tambien vale: lw $s0, valor
     lw $s4,ind #$s4 <-- #en principio $s4 vale 0 y lo #incrementa a 1 para saltar a la otra posicion del #array y luego lo multiplica por 4 para saltar a la #otra posicion del array que no deja de ser una #nueva palabra
     mul $s5,$s4,4 #$s5 <-- ind*4
     lw $s1, valor($s5) #$s1 <-- valor[1]
     add $s4,$s4,1 #incrementamos el indice del array
     mul $s5,$s4,4
     lw $s2,valor($s5) #$s2 <-- valor[2]
     add $s4,$s4,1 #incrementamos el indice del array
     mul $s5,$s4,4
     lw $s3,valor($s5) #Ss3 <-- valor 3