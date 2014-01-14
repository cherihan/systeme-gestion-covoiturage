<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
<title>Affichage d'un client</title>
<link type="text/css" rel="stylesheet" href="inc/style.css"/>
</head>
<body>
<%-- Affichage de la chaîne "message" transmise par la
servlet --%>
<p class="info">${ message }</p>
<%-- Puis affichage des données enregistrées dans le bean
"client" transmis par la servlet --%>
<p>Nom : ${ client.nom }</p>
<p>Prénom : ${ client.prenom }</p>
<p>Adresse : ${ client.adresse }</p>
<p>Numéro de téléphone : ${ client.telephone }</p>
<p>Email : ${ client.email }</p>
</body>
</html>