# java-swings
EcommerceReccomendationSystem using java swings
# E-Commerce Recommendation System

## Table of Contents
- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction
This is an E-Commerce Recommendation System built using Java and Java Swing for the user interface. The system provides various recommendation options, including personalized suggestions, cross-selling, upselling, and trending products. The project also incorporates search functionality using pattern matching and binary search to help users find products effectively.

## Project Structure
The project structure includes the following components:
EcommerceRecommendationSystem/
│
├── .idea/                                # IDE configuration files
│
├── EcommerceRecommendationSystem.iml      # IntelliJ project configuration file
├── .gitignore                             # Git ignore file
│
├── out/                                   # Compiled output files
│   └── production/                
│       └── EcommerceRecommendationSystem/
│           └── com/
│               └── example/
│                   └── ecommerce/
│                       ├── Dijkstra/                # Contains classes related to Dijkstra's algorithm
│                       ├── Graph/                   # Graph-related classes for recommendation calculations
│                       ├── Main.java                # Main class to run the program
│                       ├── MainFrame.java           # Main application frame
│                       ├── PatternMatching.java     # Pattern matching for search functionality
│                       ├── Product.java             # Product class model
│                       ├── ProductPanel.java        # Product display panel
│                       ├── RecommendationEngine.java # Core recommendation logic
│                       ├── RecommendationPanel.java # Recommendation display panel
│                       ├── Searching.java           # Search functionality
│                       ├── SearchPanel.java         # Search panel for user input
│                       ├── Sorting.java             # Sorting utility for products
│                       ├── User.java                # User model class
│                       ├── welcomeimage.jpg         # Welcome image for UI
│                       └── WelcomePanel.java        # Initial welcome screen panel
│
├── Resources/                             # Project resources like images
│   └── welcomeimage.jpg                   # Welcome image used in the UI
│
└── External Libraries/                    # Dependencies and external libraries

## Features
- **Product Panel**: Displays all available products with details.
- **Search Panel**: Allows users to search for products using pattern matching and binary search.
- **Recommendation Panel**: Provides recommendations based on various criteria:
  - Best Sellers
  - Related Products
  - New Arrivals
  - Trending Products
  - Cross-Selling and Upselling
  - Seasonal Discounts and Offers
- **Algorithm Integration**:
  - Utilizes Dijkstra's algorithm for optimized recommendation paths.
  - Implements search functionalities using binary search and pattern matching.

## Technologies Used
- **Java**: The core programming language.
- **Java Swing**: For building the graphical user interface.
- **Algorithms**: Dijkstra's algorithm, binary search, and pattern matching for efficient recommendations and search operations.

