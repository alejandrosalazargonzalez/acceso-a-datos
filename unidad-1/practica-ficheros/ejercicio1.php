<?php
/**
 * @author alejandrosalazargonzalez
 * @version 1.0.0
 */
    /**
     *lee el archivo csv
     * @param mixed $archivo
     * @return array|bool
     */
    function leerArchivo($archivo): bool|array{
        if (!file($archivo) ) {
            echo "no se encontro el archivo $archivo \n";
            return false;
        }
        return file($archivo);
    }

    /**
     * crea y/o escre en el archivo resultado csv
     * @param mixed $arrayArchivo
     * @return void
     */
    function escribir($arrayArchivo): void{
        $file = fopen("resultado.csv","w");
        fwrite($file,"z1,z2,op,resultado\n");
        for ($i=1; $i < sizeof($arrayArchivo) ; $i++) {
            $operacion = explode(",",$arrayArchivo[$i]);
            fwrite($file, trim($arrayArchivo[$i]).",".calcular(($operacion))."\n");
        }
    }

    /**
     * realiza los calculos
     * @param int|string $operacion
     */
    function calcular($operacion): int|string{
        switch (strtolower(trim($operacion[2]))) {
            case 'suma':
                return $operacion[0] + $operacion[1];
            case 'resta':
                return $operacion[0] - $operacion[1];
            case 'producto':
                return $operacion[0] * $operacion[1];
            case 'division':
                if ($operacion[1] == 0) {
                    return "ERROR";
                }
                return $operacion[0] / $operacion[1];
            default:
                return "algo va mal\n";
        }
    }

    escribir(leerArchivo("ops.csv"));

