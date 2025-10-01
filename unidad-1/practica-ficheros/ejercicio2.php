<?php
function recogerPalabras(): array {
    $texto = strtolower(string: file_get_contents("texto.txt"));
    preg_match_all("/\p{L}+/u", $texto, $words);
    return $words[0];
}

function resultado(): void {
    if (!$fp = fopen("estadisticas.csv", "w")) {
        echo "no se puede abrir el archivo";
        return;
    }

    $words = recogerPalabras();
    $ocurrencias = array_count_values($words);

    fwrite($fp, "palabra,frequencia\n");
    foreach ($ocurrencias as $word => $frequency) {
        fwrite($fp, "$word,$frequency\n");
    }
    fclose($fp);
}

resultado();
