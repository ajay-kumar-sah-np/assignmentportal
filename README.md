Steps to run project:
1. JDK 17 is required.
2. clone the project and import as maven project.


**Curls for reference:**
curl --location 'http://localhost:8080/api/users/register' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=1A1AFCFC5DDAD3F6A0893FFFDF8EFC86' \
--data '{
    "username": "Hello World",
    "password": "Alok",
    "role": "USER"
}'



curl --location 'http://localhost:8080/api/users/login' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=1A1AFCFC5DDAD3F6A0893FFFDF8EFC86' \
--data '{
    "username": "Hello World",
    "password": "Alok"
}'



curl --location 'http://localhost:8080/api/assignments/upload' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=1A1AFCFC5DDAD3F6A0893FFFDF8EFC86' \
--data '{
    "id": "sss",
    "username": "Hello World",
    "password": "Alok",
    "role": "admin"
}'



curl --location --request POST 'http://localhost:8080/api/assignments/6739c310b389d90c16782545/accept' \
--header 'Cookie: JSESSIONID=1A1AFCFC5DDAD3F6A0893FFFDF8EFC86'



