# Gestión de Inventario

Aplicación de escritorio para gestionar el inventario de productos de un negocio: alta, edición, eliminación y visualización de stock, con un panel de indicadores estilo dashboard.

Proyecto realizado como parte de la FP Dual (DAM) en el IES Delgado Hernández, con FCT en el IES El Valle (Hinojos, Huelva).

## Tecnologías

- **Java 17**
- **JavaFX 21** — interfaz gráfica (FXML + CSS)
- **Maven** — gestión de dependencias y build
- **MySQL** — persistencia de datos

## Estructura del proyecto

```
src/main/java/org/example/
├── Main.java                  # Punto de arranque
├── App.java                   # Clase principal de JavaFX (extends Application)
│
├── model/                     # Clases de datos
│   ├── Producto.java
│   ├── Categoria.java
│   ├── Proveedor.java
│   ├── Movimiento.java
│   └── TipoMovimiento.java    # enum: ENTRADA / SALIDA
│
├── dao/                       # Acceso a datos (MySQL)
│   ├── Conexion.java
│   ├── ProductoDAO.java       # interfaz
│   └── ProductoDAOImpl.java
│
├── service/                   # Lógica de negocio
│   └── InventarioService.java
│
└── controller/                # Controladores de las vistas FXML
    └── PrincipalController.java

src/main/resources/
├── view/
│   └── principal.fxml
└── css/
    └── estilos.css
```

## Funcionalidades

- Listado de productos en tabla, con selección para editar
- Alta, edición y eliminación de productos
- Panel de indicadores (KPI): total de productos, valor del inventario y avisos de stock bajo
- Persistencia en base de datos MySQL

## Configuración

### 1. Base de datos

Crea la base de datos y la tabla ejecutando:

```sql
CREATE DATABASE IF NOT EXISTS pepitopicapiedra;

USE pepitopicapiedra;

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DOUBLE NOT NULL,
    stock INT NOT NULL
);
```

### 2. Conexión

Edita `src/main/java/org/example/dao/Conexion.java` con tu usuario y contraseña de MySQL:

```java
private static final String URL = "jdbc:mysql://localhost:3306/pepitopicapiedra";
private static final String USUARIO = "usuario";
private static final String PASSWORD = "tu_contraseña";
```

### 3. Ejecutar

Desde IntelliJ: clic derecho en `Main.java` → **Run 'Main.main()'**.

Desde terminal, con el plugin de Maven configurado:

```bash
mvn javafx:run
```

## Requisitos

- JDK 17 o superior
- MySQL Server en ejecución (puerto 3306 por defecto)
- Maven (o usar el integrado en IntelliJ)

## Autor

Antonio Manuel Rodríguez Palenzuela 
