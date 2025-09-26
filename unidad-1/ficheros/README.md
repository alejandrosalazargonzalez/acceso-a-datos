## 1 Crear fichero

```php
<?php
file_put_contents("datos.txt", "Hola mundo desde PHP\n");
echo file_get_contents("datos.txt");

```

```bash
Hola mundo desde PHP
```

## 2 Guardar numeros

```php
<?php
$archivo = fopen("numeros.txt", "w");
for ($i=1; $i <= 10; $i++) {
    fwrite($archivo,$i."\n");
}
fclose($archivo);
$archivo = fopen("numeros.txt", "r");
echo fread($archivo,filesize("numeros.txt"));
fclose($archivo);

```

```bash
1
2
3
4
5
6
7
8
9
10
```

## 3 Contar

```php
<?php
$palabras = file_get_contents("texto.txt");
echo $palabras."\n";
echo str_word_count($palabras)."\n";

```

```bash
ya no quiero jugar a los php
7
```

## 4 Nombres en arrays

```php
<?php
    $fichero = fopen("nombres.txt", "w");
    $nombres = ["Jhosef","Adolfo","Nicolas","Ana","Maria","Luisa","Marcos"];
    for ($i=0; $i < sizeof($nombres); $i++) {
        fwrite($fichero, $nombres[$i]."\n");
    }
    fclose($fichero);
    $fichero = fopen("nombres.txt", "r");
    echo fread($fichero, filesize("nombres.txt"));

```

```bash
Jhosef
Adolfo
Nicolas
Ana
Maria
Luisa
Marcos
```

## 5 copiar txt

```php
<?php

echo file_get_contents("original.txt")."\n";
$datos = copy("original.txt", "copia.txt");
echo file_get_contents("copia.txt")."\n";

```

```bash
Este es el archivo original.
Este es el archivo original.
```

## 6 invertir contenido

```php
<?php
$frase = file_get_contents("frase.txt");
$frase = strrev($frase);
file_put_contents("frase_invertida.txt",$frase);

echo file_get_contents("frase_invertida.txt")."\n";

```

```bash
PHP aloh
```

## 7 calcular suma

```php
<?php

$numeros = explode(",",file_get_contents("datos_numericos.txt"));
echo array_sum($numeros)."\n";
```

```bash
100
```

## 8 tabla de multiplicar

```php
<?php
    $file = fopen("tabla5.txt","w");
    for ($i=0; $i <= 10 ; $i++) {
        $resultado = 5 * $i;
        $calculo = "5 x $i = $resultado\n";
        fwrite($file,$calculo);
    }
    fclose($file);
    echo file_get_contents("tabla5.txt");

```

```bash
5 x 0 = 0
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
5 x 4 = 20
5 x 5 = 25
5 x 6 = 30
5 x 7 = 35
5 x 8 = 40
5 x 9 = 45
5 x 10 = 50
```

## 9 registrar entrada 

```php
<?php
    $file = fopen("usuarios.txt","w");
    do{
        $nombre = readline("¿quien ha entrado? Si no hay nadie no respondas ");
        if (!empty($nombre) || !is_null($nombre)) {
            fwrite($file, $nombre."\n");
        }
    }while ($nombre);
    echo implode(file("usuarios.txt"));
    fclose($file);
```

```bash
¿quien ha entrado? Si no hay nadie no respondas alejandro
¿quien ha entrado? Si no hay nadie no respondas miguel
¿quien ha entrado? Si no hay nadie no respondas german
¿quien ha entrado? Si no hay nadie no respondas 
alejandro
miguel
german

```

## 10 leer json

```php
<?php

$contenido = file_get_contents("datos.json");
$salida = json_decode($contenido);
foreach ($salida as $nombre => $value) {
    echo $value -> nombre."\n";
}

```

```bash
Ana
Luis
```

## 11 diario

```php
<?php
    $file = fopen("diario.txt", "a");
    do{
        $datetime = date_format(date_create(), "Y-m-d H:i");
        $entrada = readline("¿que hiciste hoy? Si no hiciste nada no respondas ");
        if (strlen($entrada) > 0) {
            fwrite($file, "[$datetime] $entrada\n");
        }
    }while ($entrada);
    echo implode(file("diario.txt"));
    fclose($file);

```

```bash
¿que hiciste hoy? Si no hiciste nada no respondas expuse en clase
¿que hiciste hoy? Si no hiciste nada no respondas acabar la tarea
¿que hiciste hoy? Si no hiciste nada no respondas 
[2025-09-25 17:08] me levante
[2025-09-25 17:08] fui a clase
[2025-09-25 17:08] programe mucho
[2025-09-25 17:08] me estrese con el erasmus
[2025-09-26 01:03] expuse en clase
[2025-09-26 01:03] acabar la tarea
```

## 12 ranking videojuegos

```php
<?php

$file = file("ranking.txt");

$ranking = [];

foreach ($file as $linea) {
    list($juego, $puntos) = explode(":", $linea);
    $ranking[$juego] = (int)$puntos;
}

arsort($ranking);

$contador = 0;
foreach ($ranking as $juego => $puntos) {
    echo "$juego: $puntos\n";
    $contador++;
    if ($contador == 3){
        break;
    }
}

```

```bash
Zelda: 10
Mario: 9
Sonic: 8
```

## 13 cancion aleatoria

```php
<?php
    $canciones = file("canciones.txt");
    $random = array_rand($canciones);
    echo $canciones[$random];

```

```bash
 php cancionAleatoria.php 
4 de la mañana
 php cancionAleatoria.php 
enemy
 php cancionAleatoria.php 
enemy
 php cancionAleatoria.php 
blanco y negro
```

## 14 excusas

```php
<?php
    $excusas = file("excusas.txt");
    $random = array_rand($excusas);
    echo $excusas[$random];

```

```bash
 php selector.php 
Me asalto otro alumno que no la habia hecho, pero no soy un chivato
 php selector.php 
Ah ¿Que era hoy?
 php selector.php 
Me asalto otro alumno que no la habia hecho, pero no soy un chivato
 php selector.php 
Se me cayo la cola sobre la torre
```

## 15 chistes

```php
<?php
    $chistes = file("chistes.txt");
    $random = array_rand($chistes);
    echo $chistes[$random];

```

```bash
 php chisteAleatorio.php 
Ayer vi un bit triste… estaba des-bit-ido.
 php chisteAleatorio.php 
¿Qué le dice un bit al otro? Nos vemos en el bus
 php chisteAleatorio.php 
¿Por qué los programadores prefieren el café frío? Porque no les gusta el Java caliente.
```

## 16 adivina

```php
<?php
    $palabras = file("palabras.txt");
    $random = array_rand($palabras);
    $adivina = $palabras[$random];

    $adivinaArray = str_split($adivina);
    $tamanio = sizeof($adivinaArray);

    $pos1 = rand(0, $tamanio - 1);
    do {
        $pos2 = rand(0, $tamanio - 1);
    } while ($pos2 == $pos1);

    $oculta = "";
    for ($i = 0; $i < $tamanio-1; $i++) {
        if ($i == $pos1 || $i == $pos2) {
            $oculta .= $adivinaArray[$i];
        } else {
            $oculta .= "_";
        }
    }

    $intento = readline("Adivina la palabra: $oculta\n ");
    $input = trim($intento);

    if (strtolower($input) == trim(strtolower($adivina))) {
        echo "Correcto\n";
    } else {
        echo "Incorrecto. La palabra era: $adivina\n";
    }
```

```bash
 php adivinar.php 
Adivina la palabra: ____a_a manzana
Correcto
 php adivinar.php 
Adivina la palabra: J_______p_ javascript
Correcto
 php adivinar.php 
Adivina la palabra: _____a___o_ balonmano
Incorrecto. La palabra era: programador
```

## 17 generar nombres de superheroes

```php
<?php
$adjetivos = file("adjetivos.txt");
$animales = file("animales.txt");

$adj = $adjetivos[array_rand($adjetivos)];
$animal = $animales[array_rand($animales)];

$combinacion = trim($adj) . " " . trim($animal);
echo "$combinacion\n";

```

```bash
salazar@Sala:~/acceso-a-datos/unidad-1/ficheros/17-generadorNombres$ php generador.php 
Increíble Tigre
salazar@Sala:~/acceso-a-datos/unidad-1/ficheros/17-generadorNombres$ php generador.php 
Rápido Lobo
salazar@Sala:~/acceso-a-datos/unidad-1/ficheros/17-generadorNombres$ php generador.php 
Increíble Lobo
```

## 18 ranking de comidas

```php
<?php
$file = fopen("comidas.txt", "a");
$comida = readline("que comida te gusta? ");
fwrite($file, $comida . "\n");
fclose($file);

$file = fopen("comidas.txt", "r");
$ranking = array();

while ($linea = fgets($file)) {
    $comida = trim($linea);
    if (isset($ranking[$comida])) {
        $ranking[$comida] += 1;
    } else {
        $ranking[$comida] = 1;
    }
}
fclose($file);

arsort($ranking);

echo "Ranking de comidas:\n";
foreach ($ranking as $comida => $veces) {
    echo "$comida: $veces\n";
}

```

```bash
que comida te gusta? albondigas
Ranking de comidas:
pan: 3
hamburguesa: 2
bocadillo de lomo: 1
albondigas: 1
```

## 19 tweets

```php
<?php
    $tweets = fopen("tweets.txt", "a");
    do{
        $datetime = date_format(date_create(), "Y-m-d H:i");
        $tweet = readline("Escribe tu tweet (Enter vacío para salir): ");
        if (strlen($tweet) > 0) {
            fwrite($tweets, "[$datetime] @usuario: $tweet\n");
        }
    }while ($tweet);
    echo implode(file("tweets.txt"));
    fclose($tweets);

```

```bash
Escribe tu tweet (Enter vacío para salir): acabando la tarea #agotado
Escribe tu tweet (Enter vacío para salir): 
[2025-09-26 00:34] @usuario: hoy comi pan
[2025-09-26 00:34] @usuario: mi hamster es el mejor
[2025-09-26 00:34] @usuario: php se lleva mi cordura #programador
[2025-09-26 00:35] @usuario: la pantalla a parpadeado o son efectos secundarios de programar por la madrugada? #demencia
[2025-09-26 01:14] @usuario: acabando la tarea #agotado
```

## 20 remplazar partes de la frase

```php
<?php
$plantilla = file_get_contents("plantilla.txt");

$animales = file("animales.txt", FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
$lugares  = file("lugares.txt", FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
$comidas  = file("comidas.txt", FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

$plantilla = str_replace("[animal]", $animales[array_rand($animales)], $plantilla);

$plantilla = str_replace("[lugar]", $lugares[array_rand($lugares)], $plantilla);

$plantilla = str_replace("[comida]", $comidas[array_rand($comidas)], $plantilla);

echo $plantilla . "\n";

```

```bash
Un dragón viajó a la playa para comer ramen.
```
