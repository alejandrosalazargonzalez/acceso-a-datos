<?php
file_put_contents("datos.txt", "Hola mundo desde PHP\n");
echo file_get_contents("datos.txt");
