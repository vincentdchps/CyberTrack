<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title> Création d'un incident</title>
</head>
<body>

<h1> Création d'un incident</h1> 
    <table border="1" cellpadding="8">
        <h2> Ajout d'un incident</h2>
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
            <tr>
                <form action="/incidents/save" method="post">
                    <td><input type="text" name="titre" required/></td>
                    <td><input type="text" name="description" required/></td>
                    <td>
                        <select name="severite" required>
                            <option value="Critique">Critique</option>
                            <option value="Majeur">Majeur</option>
                            <option value="Mineur">Mineur</option>
                        </select>
                    </td>
                    <td>
                        <select name="statut" required>
                            <option value="En cours">En cours</option>
                            <option value="Résolu">Résolu</option>
                        </select>
                    </td>
                    <td><input type="text" name="equipement" required/></td>
                    <td><button type="submit">Ajouter</button></td>
                </form>
            </tr>
    </table>

<br/>
</body>
</html>