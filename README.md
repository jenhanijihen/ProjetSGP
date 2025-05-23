# 🏭 Projet Système de Gestion de Production (SGP)

## Description du projet

Ce projet consiste à développer une application web de gestion de production, permettant le suivi des produits, des machines, des techniciens, des maintenances et des ordres de fabrication. Il est construit avec une architecture moderne basée sur un backend Spring Boot et un frontend Angular, respectant les bonnes pratiques de développement.

Le système permet :
- La gestion complète (CRUD) des entités Produit, Machine, Technicien, Ordre de Fabrication, et Maintenance.
- La planification et le suivi des ordres de fabrication.
- La gestion des affectations des machines et des techniciens.
- La planification et le suivi des maintenances

---

## 🛠️ Technologies utilisées

### Backend
- Java 17
- Spring Boot 3+
- Spring Data JPA
- H2 Database (ou autre)
- Maven
- MapStruct (pour mapping DTOs)

### Frontend
- Angular 16+
- TypeScript
- Bootstrap 5
- Angular Forms & Reactive Forms

### Autres
- Docker
- Docker Compose

---

## 📦 Installation & Exécution

### Prérequis
- Docker & Docker Compose
- Node.js (si tu veux exécuter Angular sans Docker)

### ⚙️ Lancement via Docker (recommandé)

1. Cloner le projet :
   ```bash
   git clone https://github.com/ton-utilisateur/projet-sgp.git
   cd projet-sgp

