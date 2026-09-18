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
- **Archivo y línea aproximada:** `PokemonScreen.kt Línea 38`
- **Concepto evaluado (Ejercicio de la guía):** `mutableStateOf y recomposición`
- **¿Por qué es un error conceptual / de lógica?:** `Al establecer que la variable de busqueda sea igual a "" en cada recomposición se va a borrar o directamente no dejará escribir en la barra de navegación`
- **Código de corrección:**
```kotlin
var busqueda by remember { mutableStateOf("") }
```

### Error 2
- **Archivo y línea aproximada:** `PokemonScreen.kt Línea 58`
- **Concepto evaluado (Ejercicio de la guía):** `Condiciones de búsqueda`
- **¿Por qué es un error conceptual / de lógica?:** `En el ejercicio se establece explícitamente que la búsqueda de un Pokemon se puede hacer mediante su nombre O su id de pokedex, pero en el código el filtrado requiere que  se establezca la ID Y el nombre para encontrar un pokemon`
- **Código de corrección:**
```kotlin
pokemon.name.contains(busqueda, ignoreCase = true) || (idFiltro != null && pokemon.id == idFiltro)
```

### Error 3
- **Archivo y línea aproximada:** `PokemonScreen.kt Línea 195`
- **Concepto evaluado (Ejercicio de la guía):** `Listas y maneras de eliminar`
- **¿Por qué es un error conceptual / de lógica?:** `Se vé en el código que cuando yo hago click en el botón de liberar en un pokemón en vez de eliminar el pokemon al que le hice click elimina automáticamente el primero pokemón que haya capturado`
- **Código de corrección:**
```kotlin
capturados.removeAll { it.id == pokemon.id }
```

### Error 4
- **Archivo y línea aproximada:** `PokemonScreen.kt Línea 157`
- **Concepto evaluado (Ejercicio de la guía):** `Eventos onClick`
- **¿Por qué es un error conceptual / de lógica?:** `En la sección de Card se establece un modifier clickable, el cuál muestra como si la tarjeta de cada pokemon hiciera algo cuando se clickea pero en realidad no hace nada.`
- **Código de corrección:**
```kotlin
Se podría agregar otra función que se acceda clickeando la tarjeta, o eliminar el modifier ya que cuenta como código muerto
```

### Error 5
- **Archivo y línea aproximada:** `PokemonScreen.kt Línea 121`
- **Concepto evaluado (Ejercicio de la guía):** `Intent y contexts`
- **¿Por qué es un error conceptual / de lógica?:** `Un Action_Send necesita un type que resuelva que apps pueden manejarlo. En el código no se establece lo cual puede llevar a que falle.`
- **Código de corrección:**
```kotlin
val sendIntent = Intent(Intent.ACTION_SEND).apply {
    type = "text/plain"
    putExtra(Intent.EXTRA_TEXT, "¡He capturado ${capturados.size} Pokémon en mi Pokédex!")
}
```

### Error 6
- **Archivo y línea aproximada:** `PokemonScreen.kt Línea 145`
- **Concepto evaluado (Ejercicio de la guía):** `LazyColumn`
- **¿Por qué es un error conceptual / de lógica?:** `Al no establecer una key para la lazy column compose va a identificar cada ítem por su posición en la lista, no por su veradera identidad que en este caso sería la ID `
- **Código de corrección:**
```kotlin
items(
    items = listaFiltrada,
    key = { pokemon -> pokemon.id }
) { pokemon ->
    ...
}
```

### Error 7
- **Archivo y línea aproximada:** `strings.xml`
- **Concepto evaluado (Ejercicio de la guía):** `Separacion de responsabilidades`
- **¿Por qué es un error conceptual / de lógica?:** `Podemos ver que casi todos los textos están "hardcodeados" dentro de los archivos, cuando en realidad deberían estar en recursos y ser llamados a partir de referencias por el código cuando sea necesario. Hacerlo de esta manera conlleva muchos problemas como tenér que recompilar cada vez que se haga un cambio  o tener que buscar el texto por todo tu código, además de la consistencia de este.`
- **Código de corrección:**
```xml
<resources>
    <string name="app_name">PokeCompose</string>
    <string name="titulo_pokedex">Pokédex Kanto &amp; Johto</string>
    <string name="hint_buscar">Buscar por nombre o número…</string>
    <string name="label_capturados">Capturados: %1$d de %2$d</string>
    <string name="label_faltantes">Faltan capturar: %1$d Pokémon</string>
    <string name="label_progreso">Progreso de Pokédex: %1$s%%</string>
    <string name="boton_compartir">Compartir mi equipo</string>
    <string name="boton_capturar">Capturar</string>
    <string name="boton_liberar">Liberar</string>
    <string name="mensaje_compartir">¡He capturado %1$d Pokémon en mi Pokédex!</string>
</resources>
```

### Error 8
- **Archivo y línea aproximada:** `PokemonLogic.kt Línea 21`
- **Concepto evaluado (Ejercicio de la guía):** `Operaciones con variables`
- **¿Por qué es un error conceptual / de lógica?:** `Se puede ver en la función que al hacer la cuenta de la cantidad de pokemones restantes para alcanzar el 100% de la pokedex los operadores se encuentran invertidos dando como resultado un número negativo`
- **Código de corrección:**
```kotlin
fun calcularRestantes(total: Int, capturados: Int): Int {
    return total - capturados
}
```

### Error 9
- **Archivo y línea aproximada:** `PokemonLogic.kt Línea 27`
- **Concepto evaluado (Ejercicio de la guía):** `When/In y rangos`
- **¿Por qué es un error conceptual / de lógica?:** `En el código se ve que el primer rango para la región de Kanto es equivocado, ya que al ser de 1 a 251 cubre también toda el rango de Johto`
- **Código de corrección:**
```kotlin
fun clasificarGeneracion(id: Int): String {
    return when (id) {
        in 1..151 -> "Kanto (Gen 1)"
        in 152..251 -> "Johto (Gen 2)"
        else -> "Desconocida"
    }
}
```

### Error 10
- **Archivo y línea aproximada:** `PokemonLogic.kt Línea 18`
- **Concepto evaluado (Ejercicio de la guía):** `Conversión de tipos`
- **¿Por qué es un error conceptual / de lógica?:** `Al hacer la división entre dos números que son enteros nos va a dar como resultado un entero, por lo tanto, por más de que luego lo pase a Double, el resultado siempre va a devolver .00`
- **Código de corrección:**
```kotlin
fun calcularPorcentajeProgreso(capturados: Int, total: Int): Double {
    if (total == 0) return 0.0
    return (capturados.toDouble() / total.toDouble()) * 100
}
```


## 5. Registro a completar sobre el uso de Asistentes de IA

Si utilizaste asistentes de Inteligencia Artificial para consultar dudas conceptuales, completá el siguiente registro:

### Registro de Uso de IA
- **1. Problema o duda conceptual:** `Como principio envié los archivos relevantes a la IA y le pedí de manera explícita comenzar con PokemonScreen marcando los errores que identifque. Ignorá cualquier "bomba" lógica que encuentres y no me muestres la respuesta hasta que yo no te lo pida`
- **2. Prompt enviado a la IA:** `Te envié los archivos necesario para mi práctica de parcial, podés ver la consigna en el archivo "Consigna_Parcial", empecemos buscando errores en el archivo PokemonScreen.kt`
- **3. Explicación útil que aportó:** `A partir de esa prompt pude identificar múltiples errores, algunos de los cuales tuve que ignorar ya que no venían a ser conocimientos que ví durante la cursada. Y problemas que ví que no entendía bien porque estaban identificados, pregunté cual era el problema y confirmé con el contenido de la guía de ejercicios`
- **4. Decisión y código propio aplicado:** `A partir de la respuesta hecha por la IA redacté los reportes de los problemas y corregí a mano los errores que sabía como corregir. Hubo errores en los cuales le pedí ayuda para solucionarlos`

> **Recordatorio:** El objetivo didáctico no es penalizar el uso de IA, sino validar que comprendas plenamente el razonamiento detrás de cada corrección aplicada.
