# 💰 Smart Budget Assistant

An intelligent Java-based personal budgeting desktop application that helps users track their income & expenses, categorize them into "Needs" and "Wants", and gain insights into their financial behavior. Designed with a beginner-friendly GUI and extensible architecture for AI-based guidance and mobile app integration.


---

## 📌 Features
### ✅ Core Features (MVP)
- 💵 Track income & expenses manually
- 📂 Categorize expenses into "Needs" and "Wants"
- 🎯 Set monthly budget and savings goals
- 📊 Visual reports (bar/pie charts, monthly summary)
- 🧠 Rule-based categorization engine

### 🚀 Upcoming Features (Planned)
- 📷 Receipt scanning using OCR (Tesseract)
- 🤖 AI chatbot for financial guidance
- 👤 User authentication system
- 🗃 Data storage with SQLite/PostgreSQL
- 📄 Export reports as PDF
- 📱 Mobile version with Android (Java/Kotlin)

---

## 🛠 Tech Stack

| Layer         | Technology               |
|---------------|---------------------------|
| Frontend (GUI) | JavaFX, FXML, SceneBuilder |
| Backend        | Java (OOP), SQLite (JDBC) 
| AI & OCR       | Python (Tesseract OCR, Chatbot with scikit-learn/transformers) |
| Reports        | Apache PDFBox or iText   |
| Version Control| Git, GitHub              |

---

## 📁 Project Structure

Smart_Budget_Assistant/
├── src/ # Java source code
│ ├── Main.java
│ └── controllers/
├── resources/ # FXML, images, styles
│ ├── MainView.fxml
│ └── styles.css
├── docs/ # PPT, planning docs
├── README.md
└── .gitignore

---
## 🚀 Getting Started

### 1. Requirements

- Java 17+
- JavaFX SDK
- VS Code with Java Extension Pack
- SceneBuilder (for FXML editing)

### 2. Setup

1. Clone the repo:
   ```bash
   git clone https://github.com/anumita-14/smart-budget-assistant.git
   cd smart-budget-assistant

2. Open in VS Code. Make sure JavaFX is configured correctly.

3. Run the app:

Use Main.java as the entry point.

Load FXML files in your code.

---

👥 Team
Anumita Menon (@anumita-14)

Jafita Sharon (co-developer)

---

🌟 Future Goals
Android mobile version (Java or Kotlin)

AI integration for behavioral spending predictions

Smart reminders and daily budgeting

Cloud sync and user profiles

---

📜 License
MIT License – feel free to use, modify, and distribute.

Made with ❤️ by Anumita & Jafita

