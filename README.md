# 🚀 LumaAssistant

**LumaAssistant** is an intelligent assistant capable of executing real actions on the local environment, going beyond simple text responses. It combines AI models with a tool-based system to automate tasks such as file and folder creation.

---

## 🧠 How it works

Luma follows a structured interaction flow with an AI API:

1. The user sends a message
2. The AI interprets the request
3. If needed, the AI requests a tool execution
4. Luma executes the tool locally
5. The result is sent back to the AI
6. The AI returns a final response to the user

👉 In short:
- The AI decides **what to do**
- Luma executes **how to do it**

---

## 🛠️ Current Features

- 📁 Directory creation (`CreateFolderTool`)
- 📄 File creation (`CreateFileTool`)
- 🔄 Integration with AI APIs (e.g., OpenRouter/OpenAI)
- 💬 Chat interface (in progress)
- 🧠 Dynamic tool execution

---

## 📦 Project Structure

```
luma-assistant/
 ├── tools/
 │   ├── createfile/
 │   │   ├── CreateFileTool.java
 │   │   ├── schema.json
 │   │   ├── DESCRIPTION.md
 │   ├── createfolder/
 │   │   ├── CreateFolderTool.java
 │   │   ├── schema.json
 │   │   ├── DESCRIPTION.md
 ├── config/
 ├── service/
 ├── controller/
 └── ...
```

---

## ⚙️ Requirements

- Java 17+
- Maven or Gradle
- AI API account (e.g., OpenRouter)

---

## ▶️ How to run

### 1. Clone the repository

git clone https://github.com/your-user/luma-assistant.git
cd luma-assistant

---

### 2. Configure environment variables

Set these variables:

LUMA_WORKSPACE=/path/to/workspace
OPENROUTER_API_KEY=your_api_key

---

### 3. Run the application

Using Maven:

mvn spring-boot:run

Or run via your IDE (IntelliJ, Eclipse, etc.)

---

### 4. Test

Example request:

{
  "message": "Create a folder called (names) with 2 files: women.txt and men.txt, each containing 3 names"
}

---

## 🔐 Security

- Restricts operations to `LUMA_WORKSPACE`
- Prevents path traversal (e.g., `../../`)
- Validates inputs before execution

---

## 🚀 Roadmap

- [ ] Multi-file creation support
- [ ] Full web interface
- [ ] Persistent memory system
- [ ] External plugins (dynamic tools)
- [ ] Advanced command execution

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the project
2. Create a branch (`feature/my-feature`)
3. Commit your changes
4. Open a Pull Request


---

## 💡 Vision

LumaAssistant aims to evolve into a fully autonomous agent capable of:

- Creating complete projects
- Automating development workflows
- Integrating with multiple tools

---

Made with 💻 + ☕
