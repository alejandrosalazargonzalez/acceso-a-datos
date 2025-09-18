# Bloque 1: Conceptos básicos (introducción a php)

## Variables y Condicionales

**1. Mayor de dos números**  
Pide dos números y muestra cuál es mayor o si son iguales.

```php
<?php
    $numero1 = 1;
    $numero2 = 2;

    echo "el resultado de $numero1 + $numero2 es ". $numero1+$numero2;

```

### salida

```bash
el resultado de 1 + 2 es 3
```

**2. Edad permitida**  
Pide la edad de una persona y muestra:  

* "Eres menor de edad" si es < 18.  
* "Eres mayor de edad" si es ≥ 18.

```php
<?php
    $edad = 18;
    if($edad>=18){
        echo "eres mayor de edad";
    }else{
        echo "no eres mayor de edad";
    }
```

### salida

```bash
eres mayor de edad
```

**3. Positivo, negativo o cero**  
Comprueba si un número almacenado en una variable es positivo, negativo o cero.

```php
<?php
    $numero = 1;
    $mensaje = "el numero es ";

    if($numero>0){
        echo $mensaje ."positivo";
    }else if($numero<0){
        echo $mensaje ."negativo";
    }else{
        echo $mensaje . "cero";
    }

```

### salida

```bash
el numero es positivo
```

**4. Nota final**  
   Pide la nota de un alumno y muestra:

* "Suspenso" (< 5), "Aprobado" (5–6), "Notable" (7–8), "Sobresaliente" (9–10).

```php
<?php
    $nota = 6;
    $mensaje = "el alumno tiene un ";

    if($nota<5){
        echo $mensaje ."suspenso";
    }else if($nota<7){
        echo $mensaje ."aprobado";
    }else if($nota<9){
        echo $mensaje . "notable";
    }else{
        echo $mensaje . "sobresaliente";
    }
```

### salida

```bash
el alumno tiene un aprobado
```

## 2️⃣ Bucles (for, while, foreach)

**5. Contar del 1 al 100**  
Muestra los números del 1 al 100 en pantalla.

```php
<?php
    for($i = 0; $i<=100; $i++){
        echo $i."\n";
    }
```

### salida

```bash
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 
```

**6. Suma acumulada**  
Calcula la suma de los números del 1 al 50 usando un bucle.

```php
<?php
    $suma = 0;
    $i = 1;
    while($i <= 50) {
        $suma += $i;
        $i++;
    }
    echo $suma;
```

### salida

```bash
1275
```

**7. Tabla de multiplicar**  
 Pide un número y genera su tabla de multiplicar del 1 al 10.

```php
<?php
    $numero = 7;
    for($i = 1; $i <= 10; $i++) {
        echo "$numero x $i = " . ($numero * $i) . "\n";
    }
```

### salida

```bash
7 x 1 = 7, 7 x 2 = 14, 7 x 3 = 21, 7 x 4 = 28, 7 x 5 = 35, 7 x 6 = 42, 7 x 7 = 49, 7 x 8 = 56, 7 x 9 = 63, 7 x 10 = 70, 
```

**8. Números pares**  
Muestra todos los números pares entre 1 y 50.

```php
<?php
    for($i = 2; $i <= 50; $i += 2) {
        echo $i . "\n";
    }
```

### salida

```bash
2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 
```

**9. Cuenta atrás**  
Haz un bucle que cuente de 10 a 1 y luego muestre "¡Fin!".

```php
<?php
    for($i = 10; $i >= 1; $i--) {
        echo $i . "\n";
    }
    echo "¡Fin!";
```

### salida

```bash
    for($i = 10; $i >= 1; $i--) {
        echo $i . "\n";
    }
    echo "¡Fin!";
```

**10. Factorial**  
Calcula el factorial de un número introducido (ejemplo: 5! = 120).

```php
<?php
    $numero = 5;
    $factorial = 1;
    
    for($i = 1; $i <= $numero; $i++) {
        $factorial *= $i;
    }
    
    echo "!$numero = $factorial";
```

### salida

```bash
!5 = 120
```

## 3️⃣ Combinando Condicionales y Bucles

**11. Números primos**  
Escribe un algoritmo que muestre los números primos entre 1 y 50.

```php
<?php
for ($j = 2; $j <= 50; $j++) {
    $esPrimo = true;
    for ($i = 2; $i < $j; $i++) {
        if ($j % $i == 0) {
            $esPrimo = false;
            break;
        }
    }
    if ($esPrimo) {
        echo $j . "\n";
    }
}
```

### salida

```bash
1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 
```

**12. Fibonacci**  
Genera los primeros 20 términos de la secuencia de Fibonacci.

```php
$terminos = 20;
$a = 0;
$b = 1;

echo "Los primeros $terminos términos de la secuencia de Fibonacci son:\n";
echo "$a\n";
echo "$b\n";

for ($i = 3; $i <= $terminos; $i++) {
    $siguiente = $a + $b;
    echo "$siguiente\n";
    $a = $b;
    $b = $siguiente;
}
```

### salida

```bash
Los primeros 20 términos de la secuencia de Fibonacci son: 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 
```

**13. Múltiplos de un número**  
Pide un número n y muestra sus múltiplos hasta 100.

```php
$numero = 2;

echo "Los múltiplos de $numero hasta 100 son:\n";

for ($i = $numero; $i <= 100; $i += $numero) {
    echo "$i\n";
}
```

### salida

```bash
Los múltiplos de 2 hasta 100 son: 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98 100
```

**14. Suma de pares e impares**  
Calcula la suma de los números pares e impares entre 1 y 100 por separado.

```php
$pares = 0;
$impares = 0;
for ($i=0; $i <= 100 ; $i++) { 
    if ($i%2 === 0) {
        $pares+=$i;
    }else{
        $impares+=$i;
    }
}
echo "la suma de pares es $pares y la suma de impares es $impares"
```

### salida

```bash
la suma de pares es 2550 y la suma de impares es 2500
```

**15. Adivinar número**  
Genera un número aleatorio entre 1 y 20.  
Pide al usuario que lo adivine y usa un bucle con condicionales para dar pistas: "Mayor" o "Menor".

```php
$numero = rand(1,20);
$adivinado = true;
while ($adivinado) {
    $nDado = readline("ingresa un numero ");
    if ($nDado < $numero) {
        echo "el numero ingresado es mas pequeño \n";
    } else if($nDado > $numero){
        echo "el numero ingresado es mas grande \n";
    }
    if ($nDado == $numero) {
        $adivinado = false;
        break;
    }
}
echo "adivinaste \n";
```

### salida

```bash
ingresa un numero 1
el numero ingresado es mas pequeño 
ingresa un numero 2
el numero ingresado es mas pequeño 
ingresa un numero 3
el numero ingresado es mas pequeño 
ingresa un numero 4
el numero ingresado es mas pequeño 
ingresa un numero 5
adivinaste 
```

## 4️⃣ Construcción de Algorítmicos

**16. Número perfecto**  
Comprueba si un número es perfecto (la suma de sus divisores propios es igual al número).

```php
    $numero = 8128;
    $sumaDivisores = 0;

    for ($i = 1; $i <= $numero / 2; $i++) {
        if ($numero % $i == 0) {
            $sumaDivisores += $i;
        }
    }

    if ($sumaDivisores == $numero) {
        echo "$numero es un número perfecto.\n";
    } else {
        echo "$numero no es un número perfecto.\n";
    }
```

### salida

```bash
8128 es un número perfecto.

12 no es un número perfecto.
```

**17. Invertir número**
Escribe un algoritmo que invierta los dígitos de un número (ejemplo: 123 → 321).

```php
    $numero = 8128; 
    $invertido = 0;
    echo "$numero\n";
    while ($numero > 0) {
        $digito = $numero % 10;
        $invertido= $invertido * 10 + $digito;
        $numero = intdiv($numero, 10);
    }
    echo "$invertido\n";
```

### salida

```bash
1234
4321
```

**18. Palíndromo**  
Comprueba si una palabra almacenada en una variable es palíndroma.

```php
    $palabra = "hola"; 
    $invertido = strrev($palabra);
    if ($palabra == $invertido) {
        echo "$palabra es palindromo\n";
    } else{
        echo "$palabra no es palindromo\n";
    }
```

### salida

```bash
hola no es palindromo
ana es palindromo
```

**19. Máximo común divisor (MCD)**  
Escribe un algoritmo que calcule el MCD de dos números.

```php
$numero1 = 48; 
$numero2 = 18; 

while ($numero2 != 0) {
    $temp = $numero2;
    $numero2 = $numero1 % $numero2;
    $numero1 = $temp;
}

echo "El MCD es: " . $numero1 . "\n";
```

### salida

```bash
El MCD es: 6
```

**20. Triángulo de asteriscos**  
Muestra en pantalla un triángulo de altura n usando *.
Ejemplo con n = 5:

```bash
*
**
***
****
*****
```

```php
    $tamanio = readline("introduce el tamanio del triangulo ");
    for ($i=0; $i < $tamanio; $i++) { 
        for ($j=0; $j < $i; $j++) { 
            echo "*";
        }
        echo "\n";
    }
```

### salida

```bash
introduce el tamanio del triangulo 20

*
**
***
****
*****
******
*******
********
*********
**********
***********
************
*************
**************
***************
****************
*****************
******************
*******************
```
