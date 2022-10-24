import pandas as pd


def factorial1(num):
    if num > 0:
        return num * factorial1(num - 1)
    else:
        return 1


def pruebaFactorial():
    print(factorial1(5))
    print(factorial1(0))
    print(factorial1(12))


def factorial2():
    i = 2
    res = 1
    num = int(input("Introduce un numero: "))
    while i <= num:
        res = res * i
        i += 1
    print(res)


def eliminarDuplicadosLista(lista):
    print(lista)
    lista = pd.unique(lista)
    #lista = list(set(lista))
    print(lista)

def


if __name__ == '__main__':
    pruebaFactorial()  # Ejercicio 1
    factorial2()  # Ejercicio 2
    lista = ["Jose Luis", 3, 3, "Jose", "Jose", "Leo", "Jose Luis"]
    eliminarDuplicadosLista(lista)
