<!DOCTYPE html>
<html>

<head>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Quicksand:100,300,500">
  <link rel="stylesheet" href="CSS/style.css">
  <title>Transparent Login Form</title>
</head>

<body>
  <div class="full-screen-container">
    <div class="login-container">
      <h3 class="login-title">Welcome</h3>
      <form action="adminController" method="post">
        <div class="input-group">
          <label>Username</label>
          <input type="text" name="username">
        </div>
        <div class="input-group">
          <label>Password</label>
          <input type="password" name="password">
        </div>
        <div>${errorLogin}</div>
        <button type="submit" class="login-button">Sign In</button>
      </form>
    </div>
  </div>
</body>

</html>