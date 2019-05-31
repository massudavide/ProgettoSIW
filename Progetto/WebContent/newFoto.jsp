<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Prima pagina</title>
</head>
<body>
	<form action="fotoController" method="post">
		<div>
			Titolo: <input type="text" name="titolo" value=${param["titolo"]} > 
			<span class="error">${errorTitolo}</span>
		</div>
		<br>
		<div>
			Cognome: <input type="text" name="file" value=${param["file"]} >
			<span class="error">${errorFile}</span>
		</div>
		<br>
		<div>
			<input type="submit" name="sumbit" value="invia" />
			<!-- PULSANTE ("value" è il valore scritto sopra il pulsante -->
		</div>
	</form>
</body>
</html>