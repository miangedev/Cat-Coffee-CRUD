# Cat Coffee - Sistema de Gestión de Campañas de Mercadeo

Proyecto desarrollado para la materia **Programación Orientada a Objetos** como parte del plan de estudios de Ingeniería de Sistemas.

> Estás en la rama `sqlite-ver`. Si prefieres la versión con MySQL, cambia a la rama [`mysql-ver`](../../tree/mysql-ver).

## Descripción

**Cat Coffee** es una aplicación de escritorio desarrollada en Java con interfaz gráfica Swing, conectada a una base de datos SQLite embebida. No requiere instalar ningún servidor de base de datos, la base de datos se incluye directamente en el proyecto como archivo `.db`.

El sistema permite gestionar campañas de mercadeo, activos promocionales, personas, préstamos, reservas y penalizaciones mediante operaciones CRUD completas. Incluye autenticación de usuarios, módulo de gestión de activos con registro de préstamos y módulo de reportes con consultas JOIN.

## Acceso al sistema

| Campo | Valor |
|---|---|
| Usuario | `Admin` |
| Contraseña | `1234` |

## Requisitos

- Java 17 o superior
- NetBeans 25
- SQLite JDBC (incluido en `lib/`)
- Apache Commons Codec (incluido en `lib/`)

## Configuración

La base de datos `Cat_Coffee_BD.db` ya está incluida en la raíz del proyecto con datos de prueba. Solo abre el proyecto en NetBeans y ejecuta.

Si necesitas reiniciar la base de datos desde cero:
```bash
sqlite3 Cat_Coffee_BD.db < Cat_Coffee_BD_SQLite.sql
```

## Tablas administradas

- Rol
- Personas
- Activos
- Categorias
- Campanas
- Prestamos de activos por persona
- Reservas de activos por cliente
- Penalizacion de prestamos

## Módulos del sistema

**Administración:** CRUD completo para las 8 tablas del sistema.

**Gestión de Activos:** Búsqueda de persona por documento, filtro de activos disponibles por categoría y nombre, registro de préstamos con cambio automático de estado del activo.

**Reportes:**
- Activos discriminados por categoría
- Activos prestados con información de penalización
- Penalizaciones por cliente según número de documento

**Login:** Autenticación con cifrado MD5.

## Tecnologías

- Java con NetBeans 25
- SQLite 3 (embebido, sin servidor)
- SQLite JDBC
- Swing para interfaz gráfica
- Apache Commons Codec (MD5)
- Patrón DAO con interfaz CRUD genérica

## Arquitectura
src/
├── dao/               # Interfaz CRUD y clase Conexion

├── modelo/            # Clases POJO y clases AdminBD por cada tabla

└── vista/             # Formularios Swing

Cat_Coffee_BD.db       # Base de datos SQLite incluida

Cat_Coffee_BD_SQLite.sql  # Script para regenerar la BD

## Autor

Miguel Angel Osorio Orduz
github.com/miangedev
github.com/miangedev/Cat-Coffee-CRUD

Programación Orientada a Objetos 2026
Docente: Alberto José Angarita Cuellar
