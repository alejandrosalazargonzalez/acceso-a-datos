<?php
    $excusas = file("excusas.txt");
    $random = array_rand($excusas);
    echo $excusas[$random];
