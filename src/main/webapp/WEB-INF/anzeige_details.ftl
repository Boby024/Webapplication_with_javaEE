<!DOCTYPE html>

<html>

<head>
	<link rel="stylesheet" href="style.css">
	<title>Inserator | Anzeige editieren</title>
	<meta charset="utf-8">
</head>

<body>
	<div id="anzeige_editieren">
		<header>
			<h1>Anzeige editieren</h1>
		</header>
		<section>
			<div class="Titel">
				<h2>Titel</h2>
				<h2>Kategorie</h2>
				<h2>Preis (€)</h2>
				<h2>Beschreibung</h2>
			</div>
			<div class="Eingabefelder">
				<input type="text" tabindex="1"><br>
				<input class="radio" type="checkbox"> Digitale Waren
				<input class="radio" type="checkbox"> Haus &amp; Garten<br>
				<input class="radio" type="checkbox"> Mode &amp; Kosmetik
				<input class="radio" type="checkbox"> Multimedia &amp; Elektronik<br>
				<input class="Preis" type="text" tabindex="3"><br>
				<textarea tabindex="4"></textarea><br>
				<input class="Button" type="submit" tabindex="5" value="Aktualisieren" style="background-color: white">
			</div>
		</section>
	</div>
</body>

</html>