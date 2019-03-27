<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" />
    <title>home</title>
</head>
<body>

 <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Titel</th>
      <th scope="col">Text</th>
      <th scope="col">Preis</th>
      <th scope="col">Erstellungsdatum</th>
      <th scope="col">Status</th>
      <th scope="col">Kategorie</th>
      <th scope="col">Ersteller</th>
    </tr>
  </thead>
  <tbody>
  <#list anzeige as anzg>
    <tr>
      <th scope="row">${anzg.id}</th>
      <td><a href="/anzeige_edditieren?id=${anzg.id}">${anzg.titel}</a></td>
      <td>${anzg.text}</td>
      <td>${anzg.preis}</td>
      <th>${anzg.date}</th>
      <td>${anzg.status}</td>
      <td>${anzg.kategorie}</td>
      <td><a href="/userprofil?benutzername=${anzg.ersteller}">${anzg.ersteller}</a></td>
    </tr>
     </#list>
  </tbody>
</table>
<a class="btn btn-primary" href="/anzeige_erstellen" role="button">Anzeige Erstellen</a>
</body>
</html>