# Diagrama
![umlPartido](UMLPartido.png)


# Métodos
## Prerrequisitos y Flujo normal y alterno
### getEnfrentamientoId(int id)
- Comprobamos que el id pasado por parámetro no sea menor que 0 y que la lista de enfrentamientos no sea nula.
	- Si no se cumple el método devuelve null.
	- En caso contrario recorremos la lista de enfrentamientos y comparamos el id de cada enfrentamiento con el id pasado por parámetro:
		- Si son iguales el método devolverá el enfrentamiento que tenga dicho id.
		- En caso contrario el método devolverá null.
- 

### addEnfrentamientos(EnfrentamientoPetanca enf)  
- Comprobamos si el enfrentamiento existe en la lista de enfrentamientos:
	- No existe: Añadimos el enfrentamiento, return true.  
	- Existe: No añadimos, return false.
