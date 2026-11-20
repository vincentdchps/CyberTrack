<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<c:if test="${incident != null}">
		<title> Modification d'un incident</title>
	</c:if>
	<c:if test="${incident == null}">
		<title> Création d'un incident</title>
	</c:if>
</head>

<body>
	<c:if test="${incident != null}">
		<h1> Modification d'un incident</h1>
	</c:if>
	<c:if test="${incident == null}">
		<h1> Création d'un incident</h1>
	</c:if>
	<form action="/incidents/save" method="post">
		<table border="1" cellpadding="8">
			<thead>
				<tr>
					<th>Titre</th>
					<th>Description</th>
					<th>Severité</th>
					<th>Statut</th>
					<th>Equipement</th>
					<th>Analyste</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="titre" value="${incident.titre}" required /> </td>
					<td><input type="text" name="description" value="${incident.description}" required /></td>
					<td>
						<select name="severite" required>
							<option value="CRITIQUE" ${incident.severite=='CRITIQUE' ? 'selected' : '' }>Critique</option>
							<option value="MAJEUR" ${incident.severite=='MAJEUR' ? 'selected' : '' }>Majeur</option>
							<option value="MINEUR" ${incident.severite=='MINEUR' ? 'selected' : '' }>Mineur</option>
						</select>
					</td>
					<td>
						<select name="statut" required>
							<option value="EN_COURS" ${incident.statut=='EN_COURS' ? 'selected' : '' }>En cours</option>
							<option value="RESOLU" ${incident.statut=='RESOLU' ? 'selected' : '' }>Résolu</option>
							<option value="OUVERT" ${incident.statut=='OUVERT' ? 'selected' : '' }>Ouvert</option>
						</select>
					</td>
					<td>
						<select name="equipement" required>
							<option value="Serveur" ${incident.equipement=='Serveur' ? 'selected' : '' }>Serveur</option>
							<option value="Routeur" ${incident.equipement=='Routeur' ? 'selected' : '' }>Routeur</option>
							<option value="Switch" ${incident.equipement=='Switch' ? 'selected' : '' }>Switch</option>
							<option value="Pare-feu" ${incident.equipement=='Pare-feu' ? 'selected' : '' }>Pare-feu</option>
							<option value="Poste de travail" ${incident.equipement=='Poste de travail' ? 'selected' : '' }>Poste de travail</option>
							<option value="Autre" ${incident.equipement=='Autre' ? 'selected' : '' }>Autre</option>
						</select>
					</td>
					<td><input type="text" name="analyste" value="${incident.analyste}" required /></td>
					<td><input type="hidden" name="id" value="<c:out value='${incident.id}'/>" />
					<td><button type="submit">Enregistrer</button></td>
				</tr>
			</tbody>
		</table>
	</form>
	<br />
</body>

</html>