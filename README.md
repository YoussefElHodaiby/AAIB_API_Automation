# 🚀 AAIB API Automation Framework

> **API automation testing framework built with Java, RestAssured, TestNG, and Allure Reports. It's designed to test the reqres.in demo API**

---

## 🛠️ Tech Stack

| Technology | Description |
|------------|-------------|
| **Java** | Core programming language |
| **Maven** | For build and dependency management |
| **RestAssured** | To handle API requests and validations |
| **TestNG** | For organizing and running test cases |
| **Allure** | For generating clean, visual test reports |

---

## 📋 Prerequisites

**Before you get started, make sure you have:**

- ☑️ Java 11 or higher
- ☑️ Maven 3.6+
- ☑️ Allure CLI 

---

## 🏃 Getting Started

### **1. Clone the Repository**
```bash
git clone <repository-url>
cd AAIB_API_Automation
```

### **2. Run the Tests**
```bash
# Run all tests
mvn clean test

# Run a specific test class
mvn test -Dtest=UserWorkflowTest

# Run a specific test method
mvn test -Dtest=test_oneflow
```

### **3. Generate Allure Report**
```bash
# Serve the report (requires Allure CLI)
allure serve allure-results

# Or generate a static report
allure generate allure-results --clean -o allure-report
```

---

## 🎯 Test Coverage

| Operation | Endpoint | Status |
|-----------|----------|---------|
| Create User | POST /api/users | ✅ |
| Update User | PUT /api/users/{id} | ✅ |
| Get User | GET /api/users/{id} | ✅ |
| Delete User | DELETE /api/users/{id} | ✅ |

---

## 📝 Notes

> **Important Information:**
> 
> This framework uses the reqres.in demo API, which returns mock responses.
> GET requests work for predefined users (IDs 1–12).
> CREATE and UPDATE operations simulate success but don't persist data.
> Ideal for practicing API automation concepts or building a proof of concept.

---

## 📁 Project Structure

```
src/test/java/
├── base/
│   └── BaseTest.java          # Base test configuration
├── pages/
│   └── UserAPI.java           # API endpoints and methods
└── tests/
    └── test_oneflow.java      # Single flow test
```

---

*Happy Testing! 🧪*
