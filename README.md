# springboot-jwt-auth
This is an app which demonstrates the use of JWT (token) -based security implementation in SpringBoot framework

**Please use the Read-Only protocol to Clone the repository unless your are one of the maintainers:**
```
git clone git://github.roving.com/ES/springboot-jwt-auth.git
```



## Viewing the REST Web Service API Endpoint

*Once the application is running then you can view the REST Web Service API endpoints in Swagger UI from the browser by accessing : http://localhost:5000/swagger-ui.html .*



## Testing this application

*Once the application is running then you can demo it by using the following test procedure.*


### Issue GET request with no token (i.e., no *Authorization* header is specified). This results in 403 status.

```bash
curl http://localhost:5000/tasks
```


### Register a new user.

```bash
curl -i -H "Content-Type: application/json" -X POST -d '{ "username": "smysore", "password": "smysore123" }' http://localhost:5000/users/sign-up
```


### Login with user credentials to authenticate and generate token.

```bash
curl -i -H "Content-Type: application/json" -X POST -d '{ "username": "smysore", "password": "smysore123" }' http://localhost:5000/login
```
*In the generated response, Authorization header will be present containing the JSON Web Token (JWT) as a Bearer token.*


### Issue a POST request, passing valid token to create a new task.
*In the request, pass the Authorization header with the JWT as Bearer token. This is the JWT that was generated from the previous step*
```bash
curl -H "Authorization: Bearer JWTOKEN” -H "Content-Type: application/json" -X POST -d '{
 "description": “Take the car for repair”
}'  http://localhost:5000/tasks
```


### Issue a POST request, passing valid token to create a new task.

```bash
curl -H "Authorization: Bearer JWTOKEN” -H "Content-Type: application/json" -X POST -d '{
 "description": “Take the car for repair”
}'  http://localhost:5000/tasks
```


### Issue GET request, passing valid token to retrieve tasks.

```bash
curl -H "Authorization: Bearer JWTOKEN” http://localhost:5000/tasks
```

*Following is a sample request that is sending a JWT in Authorization header*
```bash
curl -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2UiLCJleHAiOjE1MzY2MDMwOTN9.eTsovcPk2nmEO186nM4TrIuPz6DyyTVEXUeVwOi2CqyUpw_1dhM6ZOps38shA6arHBp4nJ4u4tpqfPBHXAkJpw” http://localhost:5000/tasks
```
