# 🛡️ CyberTrack - Système de Gestion des Vulnérabilités et des Incidents (Mini-SOC)

Projet académique de Licence 3 axé sur la cybersécurité et l'architecture web (Spring Boot / Maven).


---

## 🎯 1. Présentation du Sujet
**CyberTrack** est une application web de type **Mini-SOC (Security Operations Center)** conçue pour aider les équipes de sécurité à surveiller, analyser et résoudre les menaces informatiques au sein d'une organisation.

---

## 🏗️ 2. Modèle de Données (MCD)
L'application repose sur 5 entités principales :
* **Équipements (1,N) ↔ (0,N) Vulnérabilité :** Un équipement peut posséder plusieurs vulnérabilités, et une vulnérabilité peut toucher plusieurs machines.
* **Équipements (1,1) ↔ (0,N) Incident :** Un équipement peut subir plusieurs incidents, et un incident est rattaché à une seule machine.
* **Analyste (1,1) ↔ (0,N) Incident :** Un analyste gère plusieurs incidents, et un incident est pris en charge par un seul analyste.
* **Vulnérabilité (1,N) ↔ (0,1) Correctif :** Une vulnérabilité fait l'objet d'un correctif, et un correctif peut résoudre plusieurs vulnérabilités.

---

## 👥 3. Personas & Use Cases
* **Analyste Sécurité :** Surveillance des alertes, qualification des failles, gestion des incidents.
* **Administrateur Système & Réseau :** Consultation des équipements et application des correctifs.

**Fonctionnalités principales :**
* Consultation de tableaux de bord et de listes (filtrage et recherche multicritère).
* Déclaration, modification et suppression sécurisée des incidents et vulnérabilités.
* Suivi détaillé des fiches d'incidents.

---

## 🚀 4. Stack Technique
* **Backend / Framework :** Java, Spring Boot, Maven
* **Gestion de versions :** Git / GitHub

---
## 📂 5. Structure du Dépôt
```text
CyberTrack/
├── src/main/        # Code source Spring Boot (Backend / Frontend MVC)
├── .gitignore       # Fichiers ignorés par Git
└── pom.xml          # Configuration des dépendances Maven
```
## 👤 Auteur
**Vincent Deschamps**
