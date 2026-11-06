<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sentinel - Dashboard</title>
</head>
<body>

<h1> CyberTrack - Dashboard</h1>

<table border="1" cellpadding="15">
    <tr>
        <td>
            <strong>Incidents critiques</strong><br/>
                <c:out value="${nbCritiques}"/>
            </h2>
        </td>
        <td>
            <strong>En cours</strong><br/>
                <c:out value="${nbEnCours}"/>
            </h2>
        </td>
        <td>
            <strong>Résolus</strong><br/>
                <c:out value="${nbResolus}"/>
            </h2>
        </td>
        <td>
            <strong>Total</strong><br/>
                <c:out value="${totalIncidents}"/>
            </h2>
        </td>
    </tr>
</table>

<br/>

<h2>Derniers incidents</h2>
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
                <td><c:out value="${inc.titre}"/></td>
                <td><c:out value="${inc.severite}"/></td>
                <td><c:out value="${inc.statut}"/></td>
                <td><c:out value="${inc.equipement}"/></td>
                <td>
                    <a href="/incidents/${inc.id}">Détail</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<br/>
<a href="/incidents/new"><button>+ Déclarer un incident</button></a>
<a href="/incidents"><button>Voir tous les incidents</button></a>

</body>
</html>