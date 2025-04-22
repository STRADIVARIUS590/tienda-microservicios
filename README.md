# tienda-microservicios

## 1 - BASE DE DATOS

1. Instalar ORACLE DATABASE 21c Y CONFIGURAR UNA CONEXIÓN

2. CREAR BASE DE DATOS  
   - Correr script de DDL localizado en `./SQL/ProyectoFinal.sql`

3. SEMBRAR BASE DE DATOS  
   - Correr script DML localizado en `./SQL/insert.sql`

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

### 2.5 - Api gateway

- Configurar BD  
  Abrir archivo `./tienda-gateway/src/main/resources/application.properties`  
  Configurar credenciales de base de datos:

```properties
spring.datasource.url={{url}}
spring.datasource.username={{username}}
spring.datasource.password={{password}}
```

- Desde la terminal, navegar hacia `/tienda/tienda-gateway`  
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
2. Correr el comando:

```bash
npm install
```

3. Correr el comando:

```bash
ng serve -o
```
