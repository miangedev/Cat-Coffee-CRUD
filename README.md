# Cat Coffee - Sistema de Gestión de Campañas de Mercadeo

Proyecto desarrollado para la materia **Programación Orientada a Objetos** como parte del plan de estudios de Ingeniería de Sistemas.

## Descripción

**Cat Coffee** es una aplicación de consola desarrollada en Java que conecta con una base de datos MySQL para gestionar las campañas de mercadeo de la organización. El sistema permite administrar la información relacionada con campañas, personas, activos y demás recursos asociados a las actividades de marketing, mediante operaciones CRUD sobre una base de datos relacional.

## Tablas administradas

* Rol
* Personas
* Activos
* Categorías
* Campañas
* Préstamos de activos por persona
* Reservas de activos por cliente
* Penalización de préstamos

## Tecnologías

* Java (NetBeans)
* MySQL
* JDBC (MySQL Connector)

## Arquitectura

El proyecto sigue el patrón **DAO (Data Access Object)**, separando la lógica de acceso a datos del resto de la aplicación mediante una interfaz CRUD genérica.

## Autor

Miguel Angel Osorio Orduz
