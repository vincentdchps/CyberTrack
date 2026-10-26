<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sentinel - Dashboard</title>
</head>
<body>

<h1>🔐 Sentinel — Tableau de bord</h1>
<p>Surveillez l'état de sécurité de votre parc informatique.</p>

<!-- Compteurs [4] -->
<table border="1" cellpadding="15">
    <tr>
        <td>
            <strong>Incidents critiques</strong><br/>
            <h2 style="color:red;">
                <c:out value="${nbCritiques}"/>
            </h2>
        </td>
        <td>
            <strong>En cours</strong><br/>
            <h2 style="color:orange;">
                <c:out value="${nbEnCours}"/>
            </h2>
        </td>
        <td>
            <strong>Résolus</strong><br/>
            <h2 style="color:green;">
                <c:out value="${nbResolus}"/>
            </h2>
        </td>
        <td>
            <strong>Total</strong><br/>
            <h2 style="color:blue;">
                <c:out value="${totalIncidents}"/>
            </h2>
        </td>
    </tr>
</table>

<br/>

<!-- Derniers incidents -->
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