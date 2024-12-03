# BOOKS API DEMO


"Android app built with jetpack compose that displays data from the Open Library API. The home screen will show a list of already read books, each featuring an cover , title and author name. When a user selects a book, it will be navigated to a detail screen with more in-depth information about that book. The project  complies to SOLID principles and follow a clean architecture design pattern.
"

![photo-collage png (1)](https://github.com/user-attachments/assets/9486af6b-2077-4f21-ad1e-016fa991fd41)

![photo-collage png](https://github.com/user-attachments/assets/b581a52e-fa79-4674-b388-fa8eb61fd255)

## PROJECT SPECIFICATION

### TECH STACK
* Kotlin
* Jetpack Compose for the UI
* Hilt for DI
* RX Kotlin & Flow - for making asynchronous calls
* Retrofit - for networking
* mockk - for unit testing
* Coil - Image Loader library.
* Lottie -  for animation

### API
* https://openlibrary.org/developers/api

  
### FEATURES
* Book List- Lists all the books already read with cover image ,title and author name
* Book  Details - Displays the details of selected book with the extra details
*   
  
### ARCHITECTURE & DESIGN PATTERN
* SOLID PRINCIPLE - The app follows SOLID design principles to ensure scalability and maintainability.
* CLEAN CODE ARCHITECTURE -The app's architecture is designed to be clean, separating concerns into distinct layers (e.g., UI, Domain, Data).
* MODULAR - The app codebase is modularized by layers (UI, Data, Domain), with the Domain module being independent of the other modules.
* DESIGN PATTERN - Application is developed using Test-Driven Development (TDD) and follows the Model-View-ViewModel (MVVM) design pattern

### IMPROVEMENTS
* RX kotlin can be optimized for more scalability 
* Furthermore cosmetics and refactoring is an endless thought








