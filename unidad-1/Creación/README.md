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

**2. Edad permitida**  
Pide la edad de una persona y muestra:
        "Eres menor de edad" si es < 18.
        "Eres mayor de edad" si es ≥ 18.

```php
<?php
    $edad = 18;
    if($edad>=18){
        echo "eres mayor de edad";
    }else{
        echo "no eres mayor de edad";
    }
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

## 2️⃣ Bucles (for, while, foreach)

**5. Contar del 1 al 100**  
Muestra los números del 1 al 100 en pantalla.

```php
<?php
    for($i = 0; $i<=100; $i++){
        echo $i."\n";
    }
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

**7. Tabla de multiplicar**  
 Pide un número y genera su tabla de multiplicar del 1 al 10.

```php
<?php
    $numero = 7;
    for($i = 1; $i <= 10; $i++) {
        echo "$numero x $i = " . ($numero * $i) . "\n";
    }
```

**8. Números pares**  
Muestra todos los números pares entre 1 y 50.

```php
<?php
    for($i = 2; $i <= 50; $i += 2) {
        echo $i . "\n";
    }
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

## 3️⃣ Combinando Condicionales y Bucles

**11. Números primos**  
Escribe un algoritmo que muestre los números primos entre 1 y 50.

```php

```

**12. Fibonacci**  
Genera los primeros 20 términos de la secuencia de Fibonacci.

```php

```

**13. Múltiplos de un número**  
Pide un número n y muestra sus múltiplos hasta 100.

```php

```

**14. Suma de pares e impares**  
Calcula la suma de los números pares e impares entre 1 y 100 por separado.

```php

```

**15. Adivinar número**  
Genera un número aleatorio entre 1 y 20.
    Pide al usuario que lo adivine y usa un bucle con condicionales para dar pistas: "Mayor" o "Menor".

```php

```

## 4️⃣ Construcción de Algorítmicos

**16. Número perfecto**  
Comprueba si un número es perfecto (la suma de sus divisores propios es igual al número).

```php

```

**17. Invertir número**  
Escribe un algoritmo que invierta los dígitos de un número (ejemplo: 123 → 321).

```php

```

**18. Palíndromo**  
Comprueba si una palabra almacenada en una variable es palíndroma.

```php

```

**19. Máximo común divisor (MCD)**  
Escribe un algoritmo que calcule el MCD de dos números.

```php

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

```
