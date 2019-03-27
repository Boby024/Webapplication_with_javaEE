<html>
<head>
<title>Hello World</title>

</head>
 
<body>
   <br>
  <#if benutzer??>
  <h3>${benutzer.benutzername} ${benutzer.name}  ${benutzer.eintrittsdatum}  </h3>
  <br><h4>${benutzer.benutzername} hat ${numberverkauft} Anzeige gekauft. </h4>
<br>
  <h4>Angeboten</h4>
  <br><br>
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
  <#list angeboten as anzg>
    <tr>
      <th scope="row"><a href="/indivanzeige?id=${anzg.id}">${anzg.id}</a></th>
      <td>${anzg.titel}</td>
      <td>${anzg.text}</td>
      <td>${anzg.preis}</td>
      <th>${anzg.erstellungsdatum}</th>
      <td>${anzg.status}</td>
      <td>${anzg.kategorie}</td>
      <td>${anzg.ersteller}</td>
    </tr>
     </#list>
  </tbody>
</table>
<br><br>
<h4>Gekauft</h4>
  <br><br>
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
  <#list gekauft as anzg>
    <tr>
      <th scope="row"><a href="/indivanzeige?id=${anzg.id}">${anzg.id}</a></th>
      <td>${anzg.titel}</td>
      <td>${anzg.text}</td>
      <td>${anzg.preis}</td>
      <th>${anzg.erstellungsdatum}</th>
      <td>${anzg.status}</td>
      <td>${anzg.kategorie}</td>
      <td>${anzg.ersteller}</td>
    </tr>
     </#list>
  </tbody>
</table>
</#if>
</body>
</html>
