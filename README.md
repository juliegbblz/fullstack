# Gestion de Films et d'Acteurs - Application Full-Stack

Cette application est un projet complet (Front-end et Back-end) permettant de gérer une base de données de films et d'acteurs. Elle offre des fonctionnalités CRUD complètes et permet de gérer le casting (association et dissociation entre films et acteurs).

## 🛠 Technologies utilisées

**Front-end (Angular) :**

* Architecture en composants Standalone
* Gestion d'état réactive avec les **Signals** (`signal`, `computed`) et **`effect`**
* Nouveau Control Flow Angular (`@if`, `@for`, `@empty`)
* Formulaires template-driven (`[(ngModel)]`)
* Appels HTTP centralisés dans des Services avec gestion des erreurs (`catchError`)

**Back-end (Spring Boot) :**

* API RESTful
* Spring Data JPA / Hibernate
* Base de données PostgreSQL
* Initialisation automatique des données via `data.sql`

---

## ⚡ La réactivité avec `effect`

L'application utilise massivement les nouvelles API réactives d'Angular, et notamment **`effect()`**.

Un `effect` est une fonction qui s'exécute automatiquement à chaque fois qu'un ou plusieurs signaux qu'elle lit sont modifiés. Dans ce projet, `effect` joue un rôle central pour la synchronisation des données :

* **Détection des routes :** Les paramètres de route (comme l'`id` d'un film ou d'un acteur) sont récupérés sous forme de signaux via `input()`.
* **Appels HTTP réactifs :** L'`effect` "écoute" ces signaux d'identifiant. Dès que l'ID change (par exemple, passage d'un film à un autre), l'`effect` se redéclenche automatiquement, lance la requête HTTP correspondante (`service.getById()`), et met à jour les signaux contenant les données du film ou de l'acteur pour rafraîchir l'interface sans recharger la page.

---

## ⚙️ Prérequis

* **Node.js** et **Angular CLI** installés pour le front-end.
* **Java 17+** et **Maven/Gradle** pour le back-end.
* **PostgreSQL** installé et démarré sur le port `5433`.

---

## 🚀 Installation et exécution

### 1. Back-end (Spring Boot)

1. Assurez-vous que votre base de données PostgreSQL est active avec la configuration suivante (modifiable dans `application.yml`) :
* **URL :** `jdbc:postgresql://localhost:5433/film-db`
* **Utilisateur :** `postgres`
* **Mot de passe :** `16062004`


2. Ouvrez le projet Spring Boot dans votre IDE (Eclipse, IntelliJ, VS Code).
3. Lancez la classe principale (souvent `App.java` ou `Application.java`).
4. Au démarrage, Hibernate créera automatiquement les tables et le fichier `src/main/resources/data.sql` insérera les données de test (films et acteurs). L'API sera accessible par défaut sur `http://localhost:8080`.

### 2. Front-end (Angular)

1. Ouvrez un terminal dans le dossier du projet Angular.
2. Installez les dépendances :
```bash
npm install

```


3. Démarrez le serveur de développement :
```bash
ng serve

```


4. Ouvrez votre navigateur sur `http://localhost:4200`.

*(Note : Assurez-vous que le proxy Angular `proxy.conf.json` est bien configuré pour rediriger les appels `/api/*` vers `http://localhost:8080` afin d'éviter les erreurs CORS).*

---

## ✨ Fonctionnalités principales

### Côté Films

* **Lister les films :** Affichage sous forme de cartes avec mise en évidence conditionnelle des films sortis avant l'an 2000.
* **Consulter un film :** Affichage des détails du film, formatage de la date en français avec `DatePipe`, et affichage du casting.
* **Créer/Modifier un film :** Formulaire réactif pour ajouter ou mettre à jour un film.
* **Supprimer un film :** Bouton de suppression directement accessible depuis les cartes ou les détails.

### Côté Acteurs

* **Lister les acteurs :** Vue d'ensemble de la base d'acteurs.
* **Consulter un acteur :** Affichage de la page de profil de l'acteur et de sa filmographie complète en réutilisant le composant `FilmCard`.

### Casting (Associations)

* **Associer :** Possibilité d'ajouter un acteur existant à un film via une liste déroulante sur la page de détail ou d'édition d'un film.
* **Dissocier :** Possibilité de retirer un acteur du casting d'un film.
