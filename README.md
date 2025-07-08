# Quantum Bookstore

A Java implementation of an online bookstore system that handles different types of books (paper, ebook, showcase) with inventory management capabilities.

## Features

- **Book Types**:
  - 📖 Paper Books (with stock management)
  - 💻 EBooks (with file type support)
  - 🖼️ Showcase Books (not for sale)

- **Core Operations**:
  - Add books to inventory
  - Remove outdated books (based on publication year)
  - Purchase books with automatic fulfillment:
    - Physical books shipped to address
    - EBooks delivered via email
  - Inventory management

## Class Structure

```
src/
├── main/
│   └── java/
│       └── org/
│           └── os/
│               ├── model/          # Book classes
│               │   ├── Book.java
│               │   ├── PaperBook.java
│               │   ├── EBook.java
│               │   └── ShowcaseBook.java
│               ├── service/        # Service interfaces (no real implementation)
│               │   ├── ShippingService.java
│               │   └── MailService.java
│               └── QuantumBookstore.java
|               └── Main.java
└── test/
    └── java/
        └── org/
            └── os/
                └── QuantumBookstoreFullTest.java  # Comprehensive tests
```

## Getting Started

### Prerequisites

- Java JDK 11+
- Gradle 7+

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Nada-ibrahim12/Quantum-Bookstore
   cd Quantum-Bookstore
   ```

2. Build the project:
   ```bash
   gradle build
   ```

### Running Tests

```bash
gradle test
```

## Design Principles

- **Extensible**: Easy to add new book types without modifying existing code
- **SOLID Compliant**:
  - Single Responsibility (separate book types, services)
  - Open/Closed (extendable without modification)
  - Liskov Substitution (all books behave as Book)
  - Interface Segregation
  - Dependency Inversion

## Testing Strategy

Comprehensive test coverage including:
- Book addition/removal
- Purchasing scenarios
- Inventory management
- Edge cases (insufficient stock, invalid operations)

## Future Enhancements

1. Database persistence
2. REST API interface
3. User authentication
4. Shopping cart functionality
5. Advanced search/filtering

![image](https://github.com/user-attachments/assets/491df57e-68d2-41ea-b028-60bc4e1d9a37)
![image](https://github.com/user-attachments/assets/c022da1e-48e2-40f8-8bce-8347c89ccab1)
![image](https://github.com/user-attachments/assets/b5a4b405-34a1-4a7c-a9cf-fdc3f056b6d5)
![image](https://github.com/user-attachments/assets/f1c7db41-045d-4784-9d14-417d62ad0a14)
![image](https://github.com/user-attachments/assets/4f38942b-64ad-4f52-8ed3-930eb2220211)


### Key Features of This README:

1. **Clear Structure**: Organized sections for easy navigation
2. **Visual Hierarchy**: Using emojis and markdown formatting
3. **Usage Examples**: Quick start code samples
4. **Design Documentation**: Highlights architectural decisions
5. **Future Roadmap**: Shows potential growth areas
6. **Build Instructions**: Simple setup commands
