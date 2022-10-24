<?php
header('Content-Type: text/event-stream');
header('Cache-Control: no-cache');

$time = date('r');
echo "data: La hora del Servidor es: {$time}\n\n";
flush();
?>