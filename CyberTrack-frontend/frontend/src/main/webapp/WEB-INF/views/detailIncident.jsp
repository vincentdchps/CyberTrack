<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<title>CyberTrack - Détail de l'incident</title>
</head>

<body>
	<h1> CyberTrack - Détail de l'incident</h1>
	<table border="1" cellpadding="8">
		<tr>
			<th>Titre</th>
			<td>
				<c:out value="${incident.titre}" />
			</td>
		</tr>
		<tr>
			<th>Description</th>
			<td>
				<c:out value="${incident.description}" />
			</td>
		</tr>
		<tr>
			<th>Sévérité</th>
			<td>
				<c:out value="${incident.severite}" />
			</td>
		</tr>
		<tr>
			<th>Statut</th>
			<td>
				<c:out value="${incident.statut}" />
			</td>
		</tr>
		<tr>
			<th>Date de détection</th>
			<td>
				<c:out value="${incident.dateDetection}" />
			</td>
		</tr>
		<tr>
			<th>Équipement</th>
			<td>
				<c:out value="${incident.equipement}" />
			</td>
		</tr>
		<tr>
			<th>Analyste</th>
			<td>
				<c:out value="${incident.analyste}" />
			</td>
		</tr>
	</table>
	<br />
	<a href="/incidents/new"><button>Déclarer un incident</button></a>
	<a href="/incidents"><button>Voir tous les incidents</button></a>
	<a href="/incidents/${incident.id}/edit"><button>Modifier l'incident</button></a>
	<form action="/incidents/${inc.id}/delete" method="post" style="display:inline;">
		<button type="submit">Supprimer</button>
	</form>
</body>

</html>