# Mini Gestor de Tareas (Doble Persistencia)

Este proyecto implementa una aplicación de consola en **TypeScript** que gestiona una lista de tareas utilizando dos fuentes de datos simultáneas: una base de datos local (**SQLite**) y una API REST remota simulada (**JSON Server**).

El objetivo es demostrar el uso del patrón Repositorio/Servicio para abstraer el origen de datos y manejar la sincronización entre un entorno online y offline.

## 🚀 Características

  * **Persistencia Local:** Gestión de tareas en una base de datos SQLite (`tareas.db`) usando `better-sqlite3`.
  * **Persistencia Remota:** Comunicación con una API REST mediante `fetch`.
  * **Gestión Dual:** Capa de servicio (`ServicioTareas`) que permite elegir el origen de la operación (`local` o `remoto`).
  * **Sincronización:** Funcionalidad para volcar el estado del servidor remoto a la base de datos local.
  * **Modelado:** Uso de interfaces y tipos TypeScript estrictos.

## 🛠️ Requisitos Técnicos

  * Node.js (v18 o superior recomendado)
  * npm

## 📦 Instalación

1.  Navega a la carpeta del proyecto:

    ```bash
    cd unidad-3/mini-gestor-tareas
    ```

2.  Instala las dependencias:

    ```bash
    npm install
    ```

## ▶️ Ejecución

Para ver el proyecto en funcionamiento, necesitarás **dos terminales**:

### Terminal 1: API Simulada (Backend)

Levanta el servidor mock que simula la API remota en el puerto 3000.

```bash
npm run api
```

*Esto utilizará el archivo `db.json` como base de datos del servidor.*

### Terminal 2: Aplicación Cliente (CLI)

Ejecuta la lógica principal de la aplicación.

```bash
npm start
```

*Esto compilará y ejecutará `src/index.ts` usando `ts-node`.*

### Tests

Para ejecutar las pruebas unitarias (Jest):

```bash
npm test
```

## 📂 Estructura del Proyecto

El código fuente se encuentra en la carpeta `src/`:

  * **`models.ts`**: Define la interfaz `Tarea` y los tipos `Origen` e `IdTarea`.
  * **`db.ts`**: Configuración de la conexión a SQLite e inicialización de la tabla.
  * **`repositorioTareasSqlite.ts`**: Implementación de las operaciones CRUD directas contra SQLite.
  * **`apiTareasRemota.ts`**: Cliente HTTP que encapsula las llamadas `fetch` al servidor REST.
  * **`servicioTareas.ts`**: Lógica de negocio. Decide a qué repositorio llamar según el parámetro `origen` y maneja la sincronización.
  * **`index.ts`**: Punto de entrada. Ejecuta un flujo de ejemplo: crea tarea remota, lista, sincroniza y muestra datos locales.

## 🔄 Estrategia de Sincronización

La sincronización implementada en `ServicioTareas` sigue una estrategia **Remoto hacia Local (Unidireccional Destructiva)**:

1.  **Descarga:** Se obtienen todas las tareas actuales desde la API Remota (`apiTareasRemota.getAll()`).
2.  **Limpieza:** Se eliminan todos los registros de la base de datos local SQLite (`localRepo.borrarTodas()`).
3.  **Volcado:** Se insertan las tareas descargadas en local, preservando sus IDs originales para mantener la coherencia.

Esto asegura que la base de datos local sea una copia exacta (espejo) del servidor en el momento de la sincronización.

## ⚙️ Configuración

  * **Base de datos local:** Se crea automáticamente el archivo `tareas.db` en la raíz del proyecto.
  * **API Remota:** Configurada por defecto en `http://localhost:3000/tareas`. Si deseas usar otro backend (ej. Spring Boot), modifica la constante `BASE_URL` en `src/apiTareasRemota.ts`.