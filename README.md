# 🚀 LumaAssistant

**LumaAssistant** is basic but poweful intelligent assistant capable of executing tools.
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

- 📁 Example tool (`CommandVoyagerTool`)
- 🔄 Integration with AI APIs (e.g., OpenRouter/OpenAI)
- 💬 Chat interface (in progress)
- 🧠 Dynamic tool execution

---

## 📦 Project Structure

```
luma-assistant/
 ├── tools/
 │   ├── voyager/
 │   │   ├── CommandVoyagerTool.java
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
- Maven
- AI API account (e.g., OpenRouter)

---

## ▶️ How to run

### 1. Clone the repository

git clone https://github.com/your-user/luma-assistant.git
cd luma-assistant

---

### 2. Configure environment variables

Set these variables:

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
"message": "Turn on Voyager instruments"
}

---

## 🚀 Roadmap

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

- Integrating with multiple tools

---

Made with 💻 + ☕
