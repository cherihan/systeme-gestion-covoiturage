<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Création d'un client</title>
<link type="text/css" rel="stylesheet" href="inc/style.css"
/>
</head>
<body>
	<div>
		<form  method="get" action="CreationUtilisateur">
			<fieldset>
				<legend>Informations client</legend>
				<label for="nomUtilisateur">Nom <span class="requis">*</span></label>
				<input type="text" id="nomUtilisateur" name="nomUtilisateur" value="" size="20" maxlength="20" />
				<br />
				<label for="prenomUtilisateur">Prénom </label>
				<input type="text" id="prenomUtilisateur" name="prenomUtilisateur" value="" size="20" maxlength="20" />
				<br />
				<label for="adresseClient">Date Naissance
				<span class="requis">*</span></label>
				<input type="text" id="datenaissance" name="datenaissance" value="" size="20" maxlength="20" />
				<br />
				<label for="telephoneClient">Numéro de téléphone
				<span class="requis">*</span></label>
				<input type="text" id="telephone" name="telephone" value="" size="20" maxlength="20" />
				<br />
				<label for="email">Adresse email</label>
				<input type="email" id="email" name="email" value="" size="20" maxlength="60" />
				<br />
			</fieldset>
			<input type="submit" value="Valider"  />
			<input type="reset" value="Remettre à zéro" /> <br/>
		</form>
	</div>
</body>
</html>