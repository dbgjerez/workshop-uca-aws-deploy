# Workshop AWS
Aplicación ejemplo para desplegar sobre AWS. En este caso se utilizará EC2

# Prerequisitos
* OpenJDK 8
* Maven

# Construcción
Modificar fichero application.yml con datos configuración MySQL
```bash
mvn clean package
```

# Ejecución
```bash
java -jar -Dspring.profiles.active=mysql workshop-uca-aws-deploy-0.0.1-SNAPSHOT.jar
```

