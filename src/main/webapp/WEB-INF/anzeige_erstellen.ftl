<!DOCTYPE html>
<html>
  <head>
      <meta charset="UTF-8">
      <link rel="stylesheet" href="style.css" />
    <title class="title_Erst">anzeige_erstellen</title>
  </head>
  <body>
    <div class="anzeige_div">
        <p>Anzeige erstellen</p>
        <form method="POST" action="anzeige_erstellen?action=anzeige_erstellen">
		
            <labe for="titel">Titel </labe><input type="text" maxlength="255" size="30" name="titel" required></br>
            <label for="kategorie">Kategorie</label></br>
            <input type="checkbox" name="kategorie" value="Digitale Waren" checked><label>Digitale Waren</label></br>
            <input type="checkbox" name="kategorie" value="Haus & Garten Waren"><label>Haus & Garten Waren</label></br>
            <input type="checkbox" name="kategorie" value="Mode & Kosmetik"><label>Mode & Kosmetik</label></br>
            <input type="checkbox" name="kategorie" value="Multimedia & Elektronik"><label>Multimedia & Elektronik</label></br>

            <label for="preis"> Preis (€)</label> <input type="number" name="preis" class="grossePreis" required></br>
            <label for="beschreibung">Beschreibung</label><input text type="text"  name="beschreibung" class="seinBeschreibung" required></br>

            <input type="submit" value="Erstellen" class="erstellen_center" name="senden">
        </form>
    </div>
  </body>
</html>
