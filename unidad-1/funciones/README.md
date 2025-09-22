# Code, Learn & Practice("Introducción a Php, uso de funciones")

## Número capicúa (palíndromo numérico)

Implementa una función __esCapicua(int $n): bool__ que determine si un número entero positivo es capicúa.

- Un número es capicúa si se lee igual de izquierda a derecha que de derecha a izquierda.

> Ejemplo: `12321` → `true`

### Codigo

```php
<?php
function capicua(int $numero): bool {
    $str_num = (string)$numero;
    $reversed_str_num = strrev($str_num);
    return $str_num == $reversed_str_num;
}

$numero = 12321;
echo capicua($numero);
?>
```

## Escalera de asteriscos

Implementa una función __montañaAsteriscos(int $n, $m): void__ que imprima una escalera de asteriscos de altura `N`y el tamaño M.

- La primera fila contiene 1 asterisco, la segunda 2, y así hasta `N`, `M` veces.

> Ejemplo con entrada `4,2`:

```text
*.     *
**.   **
***  ***
********
```

### codigo

```php
<?php
function montana($n, $m) {
    for ($i = 1; $i <= $n; $i++) {
        for ($j = 1; $j <= $m; $j++) {
            echo str_repeat("*", $i);
            if ($j < $m) {
                echo str_repeat(" ", $n - $i);
            }
        }
        echo "\n";
    }
}
montana(4, 2);
```

## Suma de dígitos

Implementa una función __sumaDigitos(int $n): int__ que calcule la suma de los dígitos de un número entero positivo.

- Descompón el número en dígitos y súmalos.

> Ejemplo: `2025` → `9` (2+0+2+5)

### codigo

```php
<?php
function sumaDigitos(int $n): int {
    $suma = 0;
    while ($n > 0) {
        $digito = $n % 10;
        $suma = $suma + $digito;
        $n = intdiv($n, 10);
    }
    return $suma;
}

echo sumaDigitos(2025);
```

## Número secreto (múltiplos de 3 o 5)

Implementa una función __multiplosTresOCinco(int $n): array__ que devuelva todos los múltiplos de 3 o 5 menores que `N`.

- Además, calcula la suma de dichos múltiplos.

> Ejemplo con entrada `10`:

```code
3, 5, 6, 9
Suma = 23
```

## Secuencia de Collatz

Implementa una función __secuenciaCollatz(int $n): array__ que genere la secuencia de Collatz a partir de un entero positivo.

- Si el número es par → dividir entre 2.  
- Si es impar → multiplicar por 3 y sumar 1.  
- Repetir hasta llegar a 1.

> Ejemplo con entrada `6`:

```code
6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1
```

---