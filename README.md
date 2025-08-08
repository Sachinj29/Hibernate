# 🌿 Hibernate Project Repository

Welcome to the **Hibernate Repository**!  
This project demonstrates the powerful features of Hibernate — the most popular Object-Relational Mapping (ORM) framework for Java.

---

## 📚 What is Hibernate?

**Hibernate** is an advanced ORM tool that maps Java classes to relational database tables. It eliminates boilerplate JDBC code and provides a seamless bridge between Java objects and database records.

### 🔥 Key Features of Hibernate:
- Transparent persistence with minimal configuration
- Automatic table creation
- Caching for performance optimization
- Lazy loading & eager fetching
- Built-in transaction management
- HQL (Hibernate Query Language) support
- Support for XML and Annotation-based configuration

---

## 🔍 Hibernate HQL (Hibernate Query Language)

**HQL** is similar to SQL, but it operates on **Java objects**, not table columns.  
It offers a more object-oriented approach to querying data.

### ✅ Example HQL Queries:
```java
// Fetch all users
String hql = "FROM User";
Query query = session.createQuery(hql);

// Fetch users with condition
String hql = "FROM User WHERE age > 25";
```

### Benefits:
- Database-independent queries
- Powerful and expressive
- Supports joins, group by, order by, etc.

---

## 🔗 Hibernate Mapping

Hibernate provides multiple ways to map Java classes with database tables.

### 1. ✍️ XML Mapping (Traditional)
- Uses `.hbm.xml` files
- Allows decoupling entity class from mapping logic

### 2. 🧩 Annotation-Based Mapping (Modern)
Example:
```java
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "emp_name")
    private String name;
}
```

### 3. 🔗 Relationships:
- **One-to-One**
- **One-to-Many**
- **Many-to-One**
- **Many-to-Many**

---

## ⚙️ application.properties

This file configures the Hibernate and database connection settings.

### 🔧 Sample:
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/hibernatedb
spring.datasource.username=root
spring.datasource.password=yourpassword

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### Properties Explained:
- `ddl-auto`: auto-creates or updates DB schema (`update`, `create`, `none`)
- `show-sql`: prints SQL queries in console
- `dialect`: adapts SQL for the selected database

---

## 🗃️ Supported Databases

This project supports popular RDBMS:
- ✅ MySQL
- ✅ PostgreSQL
- ✅ H2 (in-memory)
- ✅ Oracle (with proper dialect)

---

## 📂 Project Structure

```
Hibernate/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com.example.hibernate/
│       │       ├── entity/
│       │       ├── dao/
│       │       ├── service/
│       │       └── mainapp/
│       └── resources/
│           ├── application.properties
│           └── hibernate.cfg.xml (if XML config used)
│
├── pom.xml / build.gradle
└── README.md
```

---

## 🚀 How to Run the Project

1. Clone the repository  
   `git clone https://github.com/Sachinj29/Hibernate.git`

2. Configure database credentials in `application.properties`

3. Run the application using your IDE or:
   ```bash
   ./mvnw spring-boot:run
   ```

---
