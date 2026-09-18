# Primer Parcial Parte Práctica: Auditoría y Refactorización en Jetpack Compose
**Materia:** Programación de Aplicaciones Móviles / Desarrollo de Aplicaciones I  
**Institución:** Universidad Argentina de la Empresa (UADE)  
**Facultad:** Facultad de Ingeniería y Cs. Exactas  

---

## 1. Contexto y Objetivos

La empresa *PokeCorp* ha recibido un prototipo funcional de su nueva aplicación móvil de Pokédex (**PokeCompose**), construida en **Kotlin** y **Jetpack Compose con Material 3**. La aplicación utiliza un repositorio local con los 251 Pokémon de Kanto y Johto, permite buscar por nombre o por número de Pokédex, calcular el porcentaje de completitud y los Pokémon restantes, marcar Pokémon capturados o liberarlos del equipo, y compartir el progreso.

Aunque el código compila y la aplicación puede iniciar, el equipo de desarrollo junior ha incurrido en **10 errores conceptuales y de lógica de programación graves** que violan los principios fundamentales del modelo declarativo de Compose, el tipado de Kotlin, la lógica booleana y el manejo de colecciones vistos en los **Ejercicios**.

Tu objetivo en esta parte del exámen es actuar como **Revisor Senior de Código (Code Reviewer)**:
1. **Identificar** los 10 errores analizando el código fuente (no es obligatorio disponer de un emulador, los errores son evidentes mediante lectura estática de código).
2. **Justificar** por qué cada fragmento representa un error conceptual o de lógica.
3. **Corregir** cada error en el código para que el proyecto funcione de forma coherente y siga las mejores prácticas de la materia.

---

## 2. Pautas de Trabajo

- **Archivos a inspeccionar:**
  - `app/src/main/java/com/uade/pokecompose/ui/PokemonScreen.kt`
  - `app/src/main/java/com/uade/pokecompose/logic/PokemonLogic.kt`
  - `app/src/main/res/values/strings.xml`
- No agregues librerías externas adicionales ni alteres las versiones de Gradle. No es necesario.
- Cada error resuelto y justificado correctamente tiene un valor de **2,5 puntos** (Total: 25 puntos).
- Si utilizás un asistente de Inteligencia Artificial para consultas conceptuales, deberan completar el **Registro Obligatorio de uso de IA**

---

## 3. Matriz 

Completá la siguiente tabla para cada uno de los 10 errores encontrados:

### Error 1
- **Archivo y línea aproximada:** `...`
- **Concepto evaluado (Ejercicio de la guía):** `...`
- **¿Por qué es un error conceptual / de lógica?:** `...`
- **Código de corrección:**
```kotlin
// Escribí aquí tu corrección
```

### Error 2
- **Archivo y línea aproximada:** `...`
- **Concepto evaluado (Ejercicio de la guía):** `...`
- **¿Por qué es un error conceptual / de lógica?:** `...`
- **Código de corrección:**
```kotlin
// Escribí aquí tu corrección
```

### Error 3
- **Archivo y línea aproximada:** `...`
- **Concepto evaluado (Ejercicio de la guía):** `...`
- **¿Por qué es un error conceptual / de lógica?:** `...`
- **Código de corrección:**
```kotlin
// Escribí aquí tu corrección
```

### Error 4
- **Archivo y línea aproximada:** `...`
- **Concepto evaluado (Ejercicio de la guía):** `...`
- **¿Por qué es un error conceptual / de lógica?:** `...`
- **Código de corrección:**
```kotlin
// Escribí aquí tu corrección
```

### Error 5
- **Archivo y línea aproximada:** `...`
- **Concepto evaluado (Ejercicio de la guía):** `...`
- **¿Por qué es un error conceptual / de lógica?:** `...`
- **Código de corrección:**
```kotlin
// Escribí aquí tu corrección
```

### Error 6
- **Archivo y línea aproximada:** `...`
- **Concepto evaluado (Ejercicio de la guía):** `...`
- **¿Por qué es un error conceptual / de lógica?:** `...`
- **Código de corrección:**
```kotlin
// Escribí aquí tu corrección
```

### Error 7
- **Archivo y línea aproximada:** `...`
- **Concepto evaluado (Ejercicio de la guía):** `...`
- **¿Por qué es un error conceptual / de lógica?:** `...`
- **Código de corrección:**
```kotlin
// Escribí aquí tu corrección
```

### Error 8
- **Archivo y línea aproximada:** `...`
- **Concepto evaluado (Ejercicio de la guía):** `...`
- **¿Por qué es un error conceptual / de lógica?:** `...`
- **Código de corrección:**
```kotlin
// Escribí aquí tu corrección
```

### Error 9
- **Archivo y línea aproximada:** `...`
- **Concepto evaluado (Ejercicio de la guía):** `...`
- **¿Por qué es un error conceptual / de lógica?:** `...`
- **Código de corrección:**
```kotlin
// Escribí aquí tu corrección
```

### Error 10
- **Archivo y línea aproximada:** `...`
- **Concepto evaluado (Ejercicio de la guía):** `...`
- **¿Por qué es un error conceptual / de lógica?:** `...`
- **Código de corrección:**
```kotlin
// Escribí aquí tu corrección
```

## 5. Registro a completar sobre el uso de Asistentes de IA

Si utilizaste asistentes de Inteligencia Artificial para consultar dudas conceptuales, completá el siguiente registro:

### Registro de Uso de IA
- **1. Problema o duda conceptual:** `...`
- **2. Prompt enviado a la IA:** `...`
- **3. Explicación útil que aportó:** `...`
- **4. Decisión y código propio aplicado:** `...`

> **Recordatorio:** El objetivo didáctico no es penalizar el uso de IA, sino validar que comprendas plenamente el razonamiento detrás de cada corrección aplicada.
