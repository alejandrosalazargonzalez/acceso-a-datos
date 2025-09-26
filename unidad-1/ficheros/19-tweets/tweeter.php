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
