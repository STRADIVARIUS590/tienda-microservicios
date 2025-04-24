# tienda-microservicios

Este proyecto consiste en una arquitectura de microservicios para una tienda, compuesta por un servidor central, microservicios de clientes, productos y pedidos, y un frontend en Angular.

---

## ✅ Requisitos

Asegúrate de tener instalados los siguientes componentes antes de continuar:

### 🧩 Backend (Java/Spring Boot)
- [Java 17 o superior](https://adoptium.net/)
- [Apache Maven 3.8+](https://maven.apache.org/)
- [Oracle Database 21c](https://www.oracle.com/database/technologies/oracle21c-downloads.html)

### 🌐 Frontend (Angular)
- [Node.js 18+](https://nodejs.org/)
- [Angular CLI](https://angular.io/cli)

Instala Angular CLI globalmente si aún no lo tienes:
```bash
npm install -g @angular/cli
```

---

## 1 - BASE DE DATOS

1. Instalar **ORACLE DATABASE 21c** y configurar una conexión local

2. Crear base de datos:  
   - Ejecutar el script de DDL localizado en `./SQL/ProyectoFinal.sql`

3. Sembrar base de datos:  
   - Ejecutar el script DML localizado en `./SQL/insert.sql`

---

## 2 - SERVICIOS

### 2.1 - Servidor

- Configurar BD  
  Abrir archivo `./tienda-server/src/main/resources/application.properties`  
  Configurar credenciales de base de datos:

```properties
spring.datasource.url={{url}}
spring.datasource.username={{username}}
spring.datasource.password={{password}}
```

- Desde la terminal, navegar hacia `/tienda/server`  
- Correr el comando:

```bash
mvn spring-boot:run
```

O usando el wrapper:

```bash
./mvnw spring-boot:run
```

---

### 2.2 - Microservicio de clientes

- Configurar BD  
  Abrir archivo `./ms-clientes/src/main/resources/application.properties`  
  Configurar credenciales de base de datos:

```properties
spring.datasource.url={{url}}
spring.datasource.username={{username}}
spring.datasource.password={{password}}
```

- Desde la terminal, navegar hacia `/tienda/ms-clientes`  
- Correr el comando:

```bash
mvn spring-boot:run
```

O usando el wrapper:

```bash
./mvnw spring-boot:run
```

---

### 2.3 - Microservicio de productos

- Configurar BD  
  Abrir archivo `./ms-productos/src/main/resources/application.properties`  
  Configurar credenciales de base de datos:

```properties
spring.datasource.url={{url}}
spring.datasource.username={{username}}
spring.datasource.password={{password}}
```

- Desde la terminal, navegar hacia `/tienda/ms-productos`  
- Correr el comando:

```bash
mvn spring-boot:run
```

O usando el wrapper:

```bash
./mvnw spring-boot:run
```

---

### 2.4 - Microservicio de pedidos

- Configurar BD  
  Abrir archivo `./ms-pedidos/src/main/resources/application.properties`  
  Configurar credenciales de base de datos:

```properties
spring.datasource.url={{url}}
spring.datasource.username={{username}}
spring.datasource.password={{password}}
```

- Desde la terminal, navegar hacia `/tienda/ms-pedidos`  
- Correr el comando:

```bash
mvn spring-boot:run
```

O usando el wrapper:

```bash
./mvnw spring-boot:run
```

---

### 2.5 - API Gateway

- Desde la terminal, navegar hacia `/tienda/ms-pedidos`  
- Correr el comando:

```bash
mvn spring-boot:run
```

O usando el wrapper:

```bash
./mvnw spring-boot:run
```

## 3 - FRONT END

1. Desde la terminal, navegar hacia la carpeta `frontend-tiendaapp`  
2. Instalar dependencias con:

```bash
npm install
```

3. Ejecutar la app Angular:

```bash
ng serve -o
```

---
