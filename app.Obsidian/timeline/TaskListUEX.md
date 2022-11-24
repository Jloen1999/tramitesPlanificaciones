> No se gustas eo que hac  sd  


🐶
```button
name haz click
type command
action Open link under cursor in new window
```
^button-1

[Recordatorio: El caso con Id. PP-R-WIF-462675687 se cerrará el 27 de noviembre de 2022 - jloelananguan@gmail.com - Gmail (google.com)](https://mail.google.com/mail/u/0/#inbox/FMfcgzGrbHrBdQQCqRLDMBxtJlwwNhZB)

```button
name link
type link
action https://www.youtube.com/watch?v=E1OhQafpn4o&t=883s&ab_channel=BenCodeZen
```
^button-2

```button
name abre
type link
action https://www.google.com
```

```button
name ejecutar codigo
type command
action Execute Code: Open Code Runtime Management
~~~java
public class Imprime{
	public static void main(String[] args){
		System.out.println("Hola Mundo")
	}
}
~~~
```

```button
name Add Em Up
type calculate
action 2+2
```
^button-add

```button
name New Meeting
type note(Meeting-<%tp.date.now("HH-MM") %>, split) note
action Meeting Note Template
templater true
```

```button
name Current Weather
type prepend template
action Weather Template Note
replace [1,5]
```
^button-weather
```button
name Log
type append text
action "Hola Mundo"
```
"Hola Mundo"
"Hola Mundo"
"Hola Mundo"
"Hola Mundo"
