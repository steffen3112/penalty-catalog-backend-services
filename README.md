This project composes the RESTful Web-Services for the penalty-catalog project (https://github.com/steffen3112/penalty-catalog).
###Build:
The whole Project is a selfcontained maven project. It is built upon the plain JavaEE APIs.
Furthermore TomEE is used as Application Server, which is also part of the Build Process. Credentials have to be set during build.
####Maven-Build:
```
1.  git clone https://github.com/steffen3112/penalty-catalog-backend-services.git
2.  mvn -DjdbcUrlPGRDB=<your-POSTGRES-URL> -DuserPGRDB=<your-POSTGRES-User> -DpwdPGRDB=<your-POSTGRES-PWD>
3.  mvn tomee:build
```
######Run:
```
    mvn tomee:run
```

#####Docker-Build:
```

```