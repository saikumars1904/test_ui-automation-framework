
# Java Test Automation Framework

This is a robust, modular, and scalable **Java-based Test Automation Framework**. It supports **data-driven testing**, **cloud execution**, **fake data generation**, and **reporting**, providing end-to-end visibility into test executions.

## 🚀 About Me

I'm a passionate **SDET (Software Development Engineer in Test)** with hands-on experience in building robust test automation frameworks and ensuring software quality through scalable and maintainable test solutions.

- 🔭 Currently working on: Java-based automation frameworks with TestNG, Selenium, API testing, and CI/CD integration, API Testing with Postman and RestAssured 
- 🌱 Learning more about: Playwright, Cloud-based testing, and advanced DevOps practices  
- 💬 Ask me about: Test Automation, Selenium, Rest Assured, Playwright, Java, CI/CD, API Testing  
- 📫 How to reach me: [akashdebnath4070@gmail.com](mailto:akashdebnath4070@gmail.com)  
- ⚡ Fun fact: I break software professionally to make it better 🛠️✨

---

## Author

- [@akash0107](https://github.com/akash0107)
- Emailaddress: akashdebnath4070@gmail.com




## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/akash0107)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/akashdebnath)



## Pre-requisites

## ✅ Tech Stack & Libraries Used

| Category            | Tools/Libraries                               |
|---------------------|-----------------------------------------------|
| Programming Language| Java 21                                       |
| Test Runner         | TestNG                                        |
| Data-Driven Support | OpenCSV, Apache POI (Excel), GSON (JSON)      |
| Cloud Execution     | LambdaTest                                    |
| Fake Test Data      | Java Faker Library                            |
| Headless Execution  | Chrome/Firefox/Edge (headless mode)                |
| Reporting           | ExtentReports                                 |
| Logging             | Log4j                                         |

---

## Features

📊 Reporting & Logs

**Extent Report**: Generated at reports/reports.html

**Logs**: Saved in logs/ directory with timestamped filenames.

**Screenshots**: capture screenshots on test failure.

🔍 **Data-Driven Testing Support**
This framework supports reading test data from:

CSV files using OpenCSV

Excel (.xlsx) using Apache POI

JSON using GSON

You can place test data in the **testData** folder and map them using data providers inside your TestNG test classes.

🎭 **Fake Data Generation**

To generate dynamic and random test data (like names, emails, addresses, etc.), this framework uses the Java Faker library. It helps in making your tests more realistic and less reliant on hardcoded data.

## Installation

## Setup Instruction

**Clone the repository**

```bash
git clone https://github.com/akash0107/test-ui-automation-framework.git
cd your-repo-directory

```

**Build the project**

```bash
mvn clean install

```

**Local Execution**

```bash
mvn test -X -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=false

```

**LambdaTest execution**

```bash
mvn test -X -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false

```
🔹 Headless execution can be enabled/disabled with -DisHeadless=true/false.

##Integrated the project with GitHub Actions.
This automation framework is integrated with Github Actions
This tests will be executed everyday at 11:30 IST PM
you can view the report https://akash0107.github.io/test-ui-automation-framework/report.html
