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
        <form method="POST" action="anzeige_edditieren?action=anzeige_edditieren">
		
            <labe for="titel">Titel </labe><input type="text" maxlength="255" size="30" id="titel" name="titel" value = "${anzg.titel} required></br>
            <label for="kategorie">Kategorie</label></br>
            <input type="checkbox"  id="Digitale Waren" name="kategorie" value="Digitale Waren" checked><label>Digitale Waren</label></br>
            <input type="checkbox" id="Haus & Garten" name="kategorie" value="Haus & Garten Waren"><label>Haus & Garten Waren</label></br>
            <input type="checkbox" id="Multimedia & Elektronik" name="kategorie" value="Mode & Kosmetik"><label>Mode & Kosmetik</label></br>
            <input type="checkbox" id="Mode & Kosmetik" name="kategorie" value="Multimedia & Elektronik"><label>Multimedia & Elektronik</label></br>

            <label for="preis"> Preis (€)</label> <input type="number"  id="preis" name="preis" class="grossePreis" value ="${anzg.preis} required></br>
           <div class="form-group">
    <label for="beschreibung">Beschreibung</label>
    <textarea class="form-control" id="beschreibung" name = "beschreibung" rows="3" value = "${anzg.text}">${anzg.text}</textarea>
  </div>

            <input type="submit" value="Erstellen" class="erstellen_center" name="senden">
        </form>
    </div>
  </body>
</html>
