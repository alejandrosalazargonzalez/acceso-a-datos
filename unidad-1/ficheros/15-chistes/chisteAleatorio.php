<?php
    $chistes = file("chistes.txt");
    $random = array_rand($chistes);
    echo $chistes[$random];
