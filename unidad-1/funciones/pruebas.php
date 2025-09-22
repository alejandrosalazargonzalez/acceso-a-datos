<?php
function montanaAsteriscos($n, $m) {
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
montanaAsteriscos(4, 2);
