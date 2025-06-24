# **SharedPreferences App - S9**

Aplicación Android de ejemplo que demuestra el uso avanzado de SharedPreferences para almacenamiento persistente de datos con múltiples funcionalidades.

## **📱 Descripción**

Esta aplicación implementa un sistema completo de SharedPreferences que permite:
* Contador automático de visitas a la aplicación
* Gestión completa de perfil de usuario (nombre, edad, email)
* Sistema de temas dinámico (modo claro/oscuro)
* Persistencia de todas las preferencias entre sesiones

## **🚀 Características**

* **PreferencesManager**: Clase wrapper centralizada para manejo de SharedPreferences
* **Contador de Visitas**: Incremento automático y opción de reseteo
* **Perfil de Usuario**: Formulario completo con validación de campos
* **Modo Claro/Oscuro**: Cambio de tema en tiempo real con Switch
* **Múltiples Activities**: MainActivity y ProfileActivity con navegación fluida
* **Tipos de datos soportados**: String, Int, Boolean
* **Interfaz intuitiva**: Layouts responsivos con ConstraintLayout
* **Persistencia completa**: Todos los datos se mantienen al cerrar la aplicación

## **📋 Requisitos**

* Android Studio Arctic Fox o superior
* SDK mínimo: API 21 (Android 5.0)
* SDK objetivo: API 34 (Android 14)
* Kotlin 1.9.0


## **💻 Uso**

### **Pantalla Principal**
1. **Ver contador**: Observa cómo aumenta automáticamente cada vez que abres la app
2. **Resetear contador**: Presiona "Resetear Contador" para volver a cero
3. **Cambiar tema**: Usa el Switch "Modo Oscuro" para alternar entre temas
4. **Acceder al perfil**: Presiona "Perfil de Usuario" para ir a la segunda pantalla

### **Pantalla de Perfil**
1. **Guardar datos**: Completa nombre, edad y email, luego presiona "Guardar"
2. **Cargar datos**: Presiona "Cargar" para recuperar los datos guardados
3. **Validación**: La app verifica que todos los campos estén completos

## **📂 Estructura del Proyecto**

```
SharedPreferences_Loma/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/sharedpreferences_loma/
│           │   ├── MainActivity.kt
│           │   ├── ProfileActivity.kt
│           │   ├── PreferencesManager.kt
│           │   └── UserProfile.kt
│           ├── res/
│           │   ├── layout/
│           │   │   ├── activity_main.xml
│           │   │   └── activity_profile.xml
│           │   ├── values/
│           │   │   ├── colors.xml
│           │   │   ├── strings.xml
│           │   │   └── themes/
│           │   │       ├── themes.xml
│           │   │       └── themes.xml (night)
│           │   └── mipmap/
│           └── AndroidManifest.xml
└── README.md
```

## **🎯 Funcionalidades Implementadas**

### **1. Contador de Visitas**
- Incremento automático al abrir la app
- Botón de reseteo
- Persistencia entre sesiones

### **2. Perfil de Usuario**
- Campos: Nombre, Edad, Email
- Validación de campos obligatorios
- Botones separados para guardar/cargar
- Mensajes de confirmación

### **3. Sistema de Temas** 
- Modo Claro: Fondo blanco, texto negro
- Modo Oscuro: Fondo gris, texto blanco
- Cambio instantáneo con Switch
- Aplicación en ambas Activities

## **🔧 Componentes Técnicos**

* **PreferencesManager**: Gestión centralizada de todas las preferencias
* **UserProfile**: Data class para modelado de datos
* **ConstraintLayout**: Layouts responsivos y modernos
* **Toast Messages**: Feedback visual para el usuario
* **Intent Navigation**: Navegación fluida entre Activities