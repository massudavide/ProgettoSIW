<!DOCTYPE html>
<html>

<head>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Quicksand:100,300,500">
  <link rel="stylesheet" href="CSS/style.css">
  <title>Transparent Login Form</title>
</head>

<body>
  <div class="full-screen-containerFotografo">
    <div class="login-container">
      <h3 class="login-title">Inserimento nuovo fotografo</h3>
      <form action="fotoController" method="post">
        <div class="input-group">
          <label>Nome</label>
          <input type="text" name="username">
        </div>
        <div class="input-group">
          <label>Cognome</label>
          <input type="text" name="cognome">
        </div>
        <button type="submit" class="login-button">Conferma</button>
      </form>
    </div>
  </div>
</body>

</html>