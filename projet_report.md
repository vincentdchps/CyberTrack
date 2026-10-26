# CyberTrack - Système de Gestion des Vulnérabilités et des Incidents de Sécurité

**Auteur :** Vincent Deschamps  

**Projet :** Lancement du projet fil rouge : Analyse, conception et architecture

---

## 1. Choix du sujet
* **Sujet :** Système de gestion des vulnérabilités et des incidents de sécurité (Mini-SOC)
* **Nom de l'application :** CyberTrack

---

## 2. Analyse métier

### A. Modèle de Données (Entités et Attributs)
* **Équipements :** Les serveurs, applications ou postes de l'entreprise.
* **Vulnérabilités :** Répertorie les failles identifiées.
* **Incident :** Alertes ou attaques constatées.
* **Analyste :** Membres de l'équipe de sécurité.
* **Correctif :** L'ensemble des procédures et patches pour résoudre une vulnérabilité ou un incident.

### B. Relations entre les entités
* **Équipements (1,N) ↔ (0,N) Vulnérabilité :** Un équipement peut posséder une ou plusieurs vulnérabilités, et une vulnérabilité peut exister sur une ou plusieurs machines.
* **Équipements (1,1) ↔ (0,N) Incident :** Un équipement peut subir aucun ou plusieurs incidents, et un incident est présent sur une et une seule machine.
* **Analyste (1,1) ↔ (0,N) Incident :** Un analyste peut s'occuper d'aucun ou plusieurs incidents, et un incident est pris en charge par un et un seul analyste.
* **Vulnérabilité (1,N) ↔ (0,1) Correctif :** Une vulnérabilité fait l'objet d'aucun ou d'un seul correctif, et un correctif corrige une ou plusieurs vulnérabilités.
### C. Personas
* **Analyste sécurité :** Il surveille les alertes de sécurité, analyse les failles annoncées, qualifie les incidents et met à jour leur état de traitement.
* **Administrateur système & réseau :** Il consulte l'état des équipements sous sa responsabilité et s'assure que les correctifs sont appliqués sur les machines vulnérables.

### D. Cas d'Usage (Use Cases)
* **Consultation tableau de bord et listes :** 
  * *Acteur :* Analyste Sécurité, Administrateur système.
  * *Description :* L'utilisateur arrive sur la page d'accueil et accède à l'ensemble des enregistrements sous forme de tableaux récapitulatifs.
* **Déclaration d'un nouvel incident ou d'une vulnérabilité :** 
  * *Acteur :* Analyste sécurité.
  * *Description :* Utilisation d'un formulaire de saisie pour déclarer un nouvel incident détecté sur le réseau ou ajouter une vulnérabilité découverte.
* **Consultation des détails d'un élément :** 
  * *Acteur :* Analyste Sécurité, Administrateur Système.
  * *Description :* Clic sur "consulter" dans un tableau pour afficher toutes les informations approfondies d'un enregistrement.
* **Mise à jour d'un statut ou d'une information :** 
  * *Acteur :* Analyste Sécurité, Administrateur Système.
  * *Description :* Modification d'un enregistrement existant via un formulaire pré-rempli avec les données actuelles.
* **Suppression d'un enregistrement :** 
  * *Acteur :* Administrateur Système.
  * *Description :* Suppression d'un enregistrement erroné après validation via une page de confirmation de sécurité.
* **Recherche multicritère et filtrage :** 
  * *Acteur :* Analyste sécurité.
  * *Description :* Utilisation d'un moteur de recherche et de filtres sur les vues pour affiner l'affichage des données.

---

## 3. Modélisation prévisionnelle (MCD)

<img width="945" height="426" alt="image" src="https://github.com/user-attachments/assets/d40ed3b1-4062-4a22-804a-730494e25e1c" />

---

## 4. Conception des vues (Maquettes)
* **Tableau de bord :**
  <img width="945" height="504" alt="image" src="https://github.com/user-attachments/assets/f9f4934a-c665-46cf-867f-40b77f2d615d" />
  
* **Vues listes :**

<img width="945" height="520" alt="image" src="https://github.com/user-attachments/assets/40bad29a-db79-46d7-94b8-dbb48b3f4052" />

 **Vues détails :** 
<img width="945" height="521" alt="image" src="https://github.com/user-attachments/assets/27ed4d30-9d84-434a-8745-bf0ec33e0721" />

 **Formulaires de création / modification :**
<img width="945" height="513" alt="image" src="https://github.com/user-attachments/assets/dc5bbcb3-2be5-4d2c-9197-b041cb0c8420" />
<img width="945" height="521" alt="image" src="https://github.com/user-attachments/assets/4987d7c4-2544-4f75-959d-300002eef59d" />

**Confirmation suppression:**
<img width="945" height="507" alt="image" src="https://github.com/user-attachments/assets/57f28a85-a886-4fd9-bd76-3dbbc1e1f2bf" />


---

## 5. Cinématique de navigation

<img width="8768" height="9324" alt="image" src="https://github.com/user-attachments/assets/95f821ee-50ca-4454-bc1b-9e41b04504ab" />

