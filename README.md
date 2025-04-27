# MultiModuleSampleApp

A clean and simple **Multi-Module Android App** built with **Kotlin**, following modern **Android development best practices**.  
This project demonstrates **multi-module architecture**, **dependency injection (Hilt)**, **Jetpack Compose**, and **Clean Architecture** structure.

## ✨ Features

- **Multi-Module Architecture**  
    Clear separation of concerns: `app`, `core`, `feature` layers.
    
- **Modern Android Stack**
    
    - Kotlin
        
    - Jetpack Compose for UI
        
    - Hilt for Dependency Injection
        
    - ViewModel + StateFlow for state management
        
- **Scalable & Maintainable** Codebase  
    Designed to grow with additional features and modules easily.
    
- **Clean Architecture Principles**
    
    - Separation between domain, data, and presentation layers
        
    - Clear boundaries and dependency rules
        

## 🛠️ Tech Stack

|Layer|Technologies|
|---|---|
|UI|Jetpack Compose, ViewModel, StateFlow|
|DI|Hilt|
|Language|Kotlin|
|Architecture|MVVM, Clean Architecture, Multi-Module Setup|

## 📂 Project Structure

```text
MultiModuleSampleApp/
├── app/             # Application setup and navigation
├── core/
│   ├── ui/          # Common UI components
│   └── network/     # Network utilities
├── feature/
│   ├── home/        # Home feature module
│   └── detail/      # Detail feature module
└── build.gradle     # Centralized dependencies management
```


## 🚀 Getting Started

1. **Clone the repository**
    
    `git clone https://github.com/lng8212/MultiModuleSampleApp.git`
    
2. **Open in Android Studio**  
    Android Studio Hedgehog or newer is recommended.
    
3. **Build and Run**  
    Make sure to sync Gradle and you're good to go!
    

## 🧩 Why Multi-Module?

Splitting your app into modules:

- Reduces build time
    
- Improves code organization
    
- Makes teamwork and feature scaling easier
    
- Enforces clean dependencies and ownership

## 📄 License

This project is licensed under the MIT License.
