# 🎬 Retro Movie Finder

[![Kotlin](https://img.shields.io/badge/Kotlin-100%25-orange?logo=kotlin)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Android-100%25-brightgreen?logo=android)](https://developer.android.com/)
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)

> Una aplicación Android con estética **retro ochentera** para buscar, explorar y visualizar películas usando la API gratuita [OMDb](https://www.omdbapi.com/).

---


🎥 La app muestra un catálogo de películas con **estilo VHS**, colores neón y tipografía monospace.  
Se pueden consultar detalles de cada película: título, año, género, director, país, duración y sinopsis.

---

## 🕹️ Funcionalidades

- 🔍 **Buscar películas** por nombre
- 🖼️ **Ver lista con poster, título y año**
- 📝 **Detalle completo** de cada película:
    - Título
    - Año
    - Duración
    - Género
    - Director
    - País
    - Sinopsis
    - Poster con **Picasso**
- 🎨 **Estética retro** con colores neón y tipografía monospace
- 📼 Animación de carga tipo VHS
- 💾 Código modular y organizado (`activities`, `adapters`, `data`, `utils`)

---

## 📂 Estructura del proyecto

com.example.examenbuscadordepeliculas/
│
├── activities/
│   ├── MainActivity.kt
│   └── DetailActivity.kt
│
├── adapters/
│   └── MovieAdapter.kt
│
├── data/
│   ├── Movie.kt
│   ├── MovieResponse.kt
│   └── MovieDetail.kt
│
├── utils/
│   └── ApiService.kt
│
└── res/layout/
    ├── activity_main.xml
    ├── activity_detail.xml
    └── item_movie.xml

---

## 🧰 Tecnologías utilizadas

| Tecnología | Descripción |
|------------|------------|
| **Kotlin** | Lenguaje principal |
| **Android SDK** | Framework de desarrollo |
| **RecyclerView** | Lista dinámica de películas |
| **OkHttp** | Cliente HTTP para peticiones REST |
| **Picasso** | Carga de imágenes |
| **Gson** | Conversión JSON ↔ objetos Kotlin |
| **OMDb API** | Fuente de datos de películas |

---

## 🌐 API utilizada

**OMDb API (Open Movie Database)**

1. Regístrate en [OMDb API](https://www.omdbapi.com/apikey.aspx)
2. Activa el enlace que recibirás por correo
3. Inserta tu API Key en `ApiService.kt`:

## ⚡ Cómo ejecutar

Clonar el repositorio:

1. git clone https://github.com/MarioCaveroPerez/Examen-Buscador-de-Peliculas.git
2. Abrir en Android Studio
3. Insertar tu API Key
4. Ejecutar en un emulador o dispositivo Android

## 🎨 Diseño Retro

- Fondo oscuro (#0A0A0A)
- Colores neón (#00FF99, #FF3399, #00D4FF, #FFC500, #FF5E00)
- Tipografía monospace
- Efectos tipo CRT y VHS
- Ítems del RecyclerView con pósters, título y año destacados
  
## 👨‍💻 Autor

- Nombre: Mario Cavero Perez
- Curso: Desarrollo de aplicaciones con dispositivos moviles
- Proyecto: Examen Buscador de Películas

“Porque el cine no solo se ve… también se siente en 8 bits.” 💾
