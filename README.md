# 📝 Online Examination Module

A web-based online examination management system built with **Java EE (Jakarta Servlets + JSP)**, **MySQL**, and **Apache Tomcat**. It supports two roles — **Admin** and **Student** — covering the full exam lifecycle from subject and question creation to exam scheduling, attempt tracking, and result management.

---

## 🚀 Features

### 👤 Admin
- Secure admin login
- Create and manage **subjects**
- Add, edit, and delete **questions** (MCQ with 4 options)
- Create **exams** — assign subjects, set date and duration
- Attach questions to specific exams
- View results across all students

### 🎓 Student
- Self-registration and login
- Browse available exams
- Attempt timed exams (MCQ format)
- Prevents re-attempting the same exam
- View personal exam results

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java EE — Jakarta Servlets, JSP |
| Frontend | JSP, HTML, CSS |
| Database | MySQL |
| Connection Pooling | Apache Commons DBCP2 |
| Build Tool | Apache Ant (NetBeans project) |
| Server | Apache Tomcat |
| Packaging | WAR (`Online_Exam_Management_System.war`) |

---

## 📁 Project Structure

```
Online_Examination_Module/
├── src/java/
│   ├── controller/         # Servlets (request handling)
│   │   ├── AdminLoginServlet.java
│   │   ├── StudentLoginServlet.java
│   │   ├── StudentRegisterServlet.java
│   │   ├── SubjectServlet.java
│   │   ├── QuestionServlet.java
│   │   ├── ExamServlet.java
│   │   ├── SubmitExamServlet.java
│   │   └── ResultServlet.java
│   ├── dao/                # Data Access Objects (DB queries)
│   │   ├── AdminDAO.java
│   │   ├── StudentDAO.java
│   │   ├── SubjectDAO.java
│   │   ├── QuestionDAO.java
│   │   ├── ExamDAO.java
│   │   └── ResultDAO.java
│   ├── model/              # POJOs / Entity classes
│   │   ├── Admin.java
│   │   ├── Student.java
│   │   ├── Subject.java
│   │   ├── Question.java
│   │   ├── Exam.java
│   │   ├── ExamQuestion.java
│   │   └── Result.java
│   └── util/
│       └── DBConnectionPool.java   # Apache DBCP2 connection pool
├── web/
│   └── admin/              # Admin JSP pages
│       ├── adminDashboard.jsp
│       ├── addSubject.jsp / editSubject.jsp
│       ├── addQuestion.jsp / editQuestion.jsp
│       ├── createExam.jsp
│       └── addExamQuestions.jsp
├── data_base.sql           # Database schema & seed data
├── dist/
│   └── Online_Exam_Management_System.war
└── build.xml               # Ant build file
```

---

## 🗄️ Database Schema

Run `data_base.sql` to set up the database. It creates the `online_exam_mgmt` database with the following tables:

| Table | Description |
|---|---|
| `admin` | Admin credentials |
| `student` | Registered student accounts |
| `subject` | Exam subjects |
| `question` | MCQ questions linked to subjects |
| `exam` | Exams with subject, date, and duration |
| `exam_question` | Many-to-many mapping of exams to questions |
| `result` | Student exam scores and attempt timestamps |

---

## ⚙️ Setup & Installation

### Prerequisites

- Java JDK 11+
- Apache Tomcat 10+
- MySQL 8+
- NetBeans IDE (recommended) or any IDE with Ant support

### 1. Clone the Repository

```bash
git clone https://github.com/TheDharmikVyas/Online_Examination_Module.git
cd Online_Examination_Module
```

### 2. Set Up the Database

```bash
mysql -u root -p < data_base.sql
```

This creates the `online_exam_mgmt` database with all tables and a default admin account.

**Default Admin Credentials:**
```
Username: sahil
Password: 123
```

### 3. Configure Database Connection

Edit `src/java/util/DBConnectionPool.java` and update your MySQL credentials:

```java
bd.setUrl("jdbc:mysql://localhost:3306/online_exam_mgmt?zeroDateTimeBehavior=CONVERT_TO_NULL");
bd.setUsername("your_username");
bd.setPassword("your_password");
```

> ⚠️ The default URL in the code points to the `mysql` system database. Make sure to change it to `online_exam_mgmt`.

### 4. Build & Deploy

**Using NetBeans:**
1. Open the project in NetBeans
2. Right-click project → **Clean and Build**
3. Deploy to Tomcat via the IDE

**Using the WAR file directly:**
```bash
cp dist/Online_Exam_Management_System.war <TOMCAT_HOME>/webapps/
```
Then start Tomcat and navigate to `http://localhost:8080/Online_Exam_Management_System/`.

---

## 🔗 Key Endpoints

| URL | Description |
|---|---|
| `/AdminLoginServlet` | Admin login handler |
| `/StudentLoginServlet` | Student login handler |
| `/StudentRegisterServlet` | Student registration |
| `/SubjectServlet` | CRUD for subjects |
| `/QuestionServlet` | CRUD for questions |
| `/ExamServlet` | Create and manage exams |
| `/SubmitExamServlet` | Handle exam submission & scoring |
| `/ResultServlet` | View results |

---

## 📌 Notes

- Each student can attempt each exam **only once** — duplicate attempts are blocked.
- Exams are scored automatically on submission by comparing selected answers against stored correct answers.
- Connection pooling is handled by **Apache Commons DBCP2** (pool size: 5–20 connections).

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.

---

## 👨‍💻 Author

**Dharmik Vyas** && **Sahil Vaja**  
[GitHub](https://github.com/TheDharmikVyas)
