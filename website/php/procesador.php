<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>repaso</title>
    <link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
    <link rel="stylesheet" href="js/javascript.js">
</head>
<body>
<main id="container">
    <form id="form">
        <p>Ip del usuario
            <label for="name"></label>
            <input required id="input" type="text" id="name" placeholder=""Introduce una ip>
            <small>Por ejemplo: 54.85.132.205</small>
        </p>
        <button id="submit" type="submit">Buscar Informacion de esta IP</button>

    </form>
    <div>
        <pre id="results"></pre>
    </div>
</main>


</body>
</html>