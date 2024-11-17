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




**Objective:**
Create an assignment submission portal with the following functionality and structure.

### Scenario:

You are tasked with developing a backend system for an assignment submission portal. The system should support users and admins where:

- **Users** can upload assignments.
    - Assignments in this case can just be an object like below
        
        ```json
        {
            'userId':Soumik,
            'task':'Hello World',
            'admin':'Alok',
        }
        ```
        
- **Admins** can accept or reject these assignments.
    - Admin can see all assignments tagged to them
	- Admins will see each the user name, task and timedate data
- Admin can either reject or accept them

### Requirements:

1. **Database:**
    - Use MongoDB as your database.
2. **Structure and Functionality:**
    - There should be two types of users: **Admin** and **User**.
    - **Users** can:
        - Register and log in.
        - Upload assignments.
    - **Admins** can:
        - Register and log in.
        - View assignments tagged to them.
        - Accept or reject assignments.
		3. **Endpoints:**
    - **User Endpoints:**
        - `POST /register` - Register a new user.
        - `POST /login` - User login.
        - `POST /upload` - Upload an assignment.
        - `GET /admins`- fetch all admins
    - **Admin Endpoints:**
        - `POST /register` - Register a new admin.
        - `POST /login` - Admin login.
        - `GET /assignments` - View assignments tagged to the admin.
        - `POST /assignments/:id/accept` - Accept an assignment.
        - `POST /assignments/:id/reject` - Reject an assignment.
4. **Validation:**
    - Ensure all inputs are validated.
    - Provide proper error messages for invalid inputs.
5. **User Management:**
    - Implement proper user management.
    - (Optional) Implement OAuth2 for user authentication.
6. **Modularity:**
    - Ensure the code is modular and well-structured for readability and maintainability.

### Deliverables:
- A fully functional backend system that meets the requirements.
- Proper documentation on how to set up and run the system.
- Clear and concise comments in your code for readability.

### Submission:

Please submit your completed project via a GitHub repository link. Ensure that your repository is public or provide access to the reviewers.

---

**Good Luck**


curl --location --request POST 'http://localhost:8080/api/assignments/6739c310b389d90c16782545/accept' \
--header 'Cookie: JSESSIONID=1A1AFCFC5DDAD3F6A0893FFFDF8EFC86'



