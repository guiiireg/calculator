# Calculatrice Graphique en Java

Une calculatrice graphique complète développée en Java avec une interface Swing, offrant des fonctionnalités de base et un mode scientifique avancé.

## Prérequis

- Java Development Kit (JDK) 8 ou supérieur
- Un environnement de développement Java (IDE recommandé : IntelliJ IDEA, Eclipse, ou VS Code)

## Installation

1. Clonez ce dépôt ou téléchargez les fichiers source
2. Naviguez vers le répertoire du projet
3. Compilez le programme :
```bash
javac Calculator.java
```
4. Exécutez la calculatrice :
```bash
java Calculator
```

## Fonctionnalités

### Mode Standard
- Opérations arithmétiques de base :
  - Addition (+)
  - Soustraction (-)
  - Multiplication (*)
  - Division (/)
- Nombres décimaux (utilisation du point)
- Effacement (C)
- Affichage des résultats en temps réel

### Mode Scientifique
- Fonctions trigonométriques :
  - Sinus (sin)
  - Cosinus (cos)
  - Tangente (tan)
  - Les angles sont en degrés
- Fonctions mathématiques avancées :
  - Racine carrée (√)
  - Carré (x²)
  - Puissance (x^y)

## Guide d'utilisation

### Interface
- **Écran d'affichage** : Affiche les nombres saisis et les résultats
- **Boutons numériques** : 0-9 pour saisir les nombres
- **Boutons d'opérations** : +, -, *, / pour les calculs de base
- **Bouton Mode** : Bascule entre le mode standard et scientifique
- **Bouton C** : Efface l'affichage et réinitialise la calculatrice

### Opérations de base
1. Entrez le premier nombre
2. Cliquez sur l'opérateur souhaité
3. Entrez le second nombre
4. Appuyez sur "=" pour obtenir le résultat

### Fonctions scientifiques
1. Cliquez sur "Mode" pour activer le mode scientifique
2. Entrez le nombre
3. Sélectionnez la fonction souhaitée (sin, cos, tan, √, x², x^y)
4. Pour x^y, entrez le second nombre après avoir sélectionné l'opération

## Gestion des erreurs
- Affichage d'un message d'erreur pour les entrées vides
- Protection contre les racines carrées de nombres négatifs
- Gestion des nombres décimaux

## Notes techniques
- Interface développée avec Java Swing
- Gestion des événements avec ActionListener
- Support des opérations en chaîne
- Interface responsive et intuitive
