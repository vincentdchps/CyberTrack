<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<title> Liste des Incidents</title>
</head>

<body>
	<h1> Incidents</h1>
	<a href="/incidents/new"> Ajouter un incident</a>
	<table border="1" cellpadding="8">
		<thead>
			<tr>
				<th>Titre</th>
				<th>Sévérité</th>
				<th>Statut</th>
				<th>Equipement</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="inc" items="${incidents}">
				<tr>
					<td>
						<c:out value="${inc.titre}" />
					</td>
					<td>
						<c:out value="${inc.severite}" />
					</td>
					<td>
						<c:out value="${inc.statut}" />
					</td>
					<td>
						<c:out value="${inc.equipement}" />
					</td>
					<td>
						<a href="/incidents/${inc.id}">Détail</a>
						<a href="/incidents/${inc.id}/edit">Modifier</a>
						<form action="/incidents/${inc.id}/delete" method="post" style="display:inline;">
							<button type="submit">Supprimer</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
</body>

</html>