# Spring Security Login Application

A robust Spring Boot application demonstrating user authentication and authorization using Spring Security 6.

## 🚀 Features

- User authentication with Spring Security
- Role-based access control
- User registration and login functionality
- Secure password handling
- Custom welcome and user pages
- Database persistence with JPA

## 🛠️ Technologies

- Java 23
- Spring Boot 3.4.1
- Spring Security 6
- Spring Data JPA
- Thymeleaf for server-side templating
- H2 Database (for development)
- Maven for dependency management

## 📋 Prerequisites

- Java Development Kit (JDK) 23 or later
- Maven 3.6+ installed
- Your favorite IDE (IntelliJ IDEA recommended)

## 🔧 Installation & Setup

1. Clone the repository:
```bash
git clone https://github.com/yourusername/spring-inloggning.git
cd spring-inloggning
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

## 🏗️ Project Structure

```
src/main/
├── java/se/mete/springinloggning/
│   ├── config/          # Security and application configuration
│   ├── controller/      # MVC controllers
│   └── model/          # Entity classes
└── resources/
    ├── templates/      # Thymeleaf templates
    └── application.properties  # Application configuration
```

## 🔐 Security Configuration

The application uses Spring Security for authentication and authorization. Key security features include:

- Form-based authentication
- Password encryption
- Role-based access control
- Session management
- CSRF protection

## 🌐 Available Endpoints

- `/` - Welcome page (accessible to all)
- `/login` - Login page
- `/user` - User dashboard (requires authentication)
- `/admin` - Admin dashboard (requires ADMIN role)

## 💻 Usage

1. Start the application
2. Navigate to `http://localhost:8080`
3. Use the following default credentials:
   - Username: `user`
   - Password: Check the console output for the generated password

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## ✍️ Author

Your Name

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Spring Security team for the robust security features
