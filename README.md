# Test connection to sqlserver

### gitbash
```
java -classpath sqlclient.jar;sqljdbc42.jar Main "jdbc:sqlserver://localhost:1433;databaseName=dbname" "SA" "passwd"
```

### linux for java 11
```
java --class-path mssql-jdbc-9.2.1.jre11.jar:sqlclient.jar Main "jdbc:sqlserver://host:41438;databaseName=dbname" "username" "passwd"
```