### Curso de Spring e React
- 01 Introdução
- 02 Criando o projeto

### Ddepencias
- Spring Boot DevTools
- Lombok
- Spring Web Web
- Spring Data JPA

- 03 - Gerando Tabela
### Configurar o properties
```
# Configuração do Servidor
server.port=8080

# Configuração do SQLite
spring.datasource.url=jdbc:sqlite:./dados/database.db
spring.datasource.driver-class-name=org.sqlite.JDBC

# Configuração do JPA/Hibernate
spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Desabilitar a feature do Hibernate que tenta buscar informações de banco de dados
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```

# Pom xml
```
      <!-- SQLite JDBC Driver -->
        <dependency>
            <groupId>org.xerial</groupId>
            <artifactId>sqlite-jdbc</artifactId>
            <version>3.44.1.0</version>
        </dependency>
        
        <!-- Hibernate SQLite Dialect -->
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-community-dialects</artifactId>
        </dependency>

```

# jjwt
```
	<!-- JJWT -->
	<dependency>
		<groupId>io.jsonwebtoken</groupId>
		<artifactId>jjwt-api</artifactId>
		<version>0.11.5</version>
	</dependency>
	<dependency>
		<groupId>io.jsonwebtoken</groupId>
		<artifactId>jjwt-impl</artifactId>
		<version>0.11.5</version>
		<scope>runtime</scope>
	</dependency>
	<dependency>
		<groupId>io.jsonwebtoken</groupId>
		<artifactId>jjwt-jackson</artifactId>
		<version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>

```

# Perfil
```
public enum Perfil {
    ADMIN,
    USER
}
```
