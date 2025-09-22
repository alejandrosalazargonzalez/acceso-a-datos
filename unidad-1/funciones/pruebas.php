<?php
function multiplos(int $n) {
    $multiplos = [];
    for ($i=0; $i < $n; $i++) { 
    if ($i % 3 == 0 || $i % 5 == 0 ) {
        $multiplos[] = $i; 
    }
    }
    return $multiplos;
}
function suma($list){
    return $suma = array_sum($list);
}

$numeros = multiplos(10);

echo implode(",",$numeros) . "\n";
echo suma(multiplos(10)) . "\n";