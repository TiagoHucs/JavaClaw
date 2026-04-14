# 🚀 JavaClaw

**JavaClaw** is basic but poweful intelligent assistant capable of executing tools.
---


<p align="center">
    <picture>
        <source media="(prefers-color-scheme: light)" srcset="https://raw.githubusercontent.com/TiagoHucs/JavaClaw/refs/heads/main/assets/javaclawlogo.png">
        <img src="https://raw.githubusercontent.com/TiagoHucs/JavaClaw/refs/heads/main/assets/javaclawlogo.png" alt="JavaClaw" width="500">

</picture>
</p>

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

- 📁 Example tool (`HelloTool`)
- 🔄 Integration with AI APIs (e.g., OpenRouter/OpenAI)
- 💬 Chat interface (in progress)
- 🧠 Dynamic tool execution

---

## 📦 Project Structure

```
java-claw/
 ├── tools/
 │   ├── hello/
 │   │   ├── HelloTool.java
 │   │   ├── hello-schema.json
 │   │   ├── DESCRIPTION.md
 │   ├── another/
 │   │   ├── AnotherTool.java
 │   │   ├── another-schema.json
 │   │   ├── DESCRIPTION.md
 ├── config/
 ├── service/
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

git clone https://github.com/your-user/java-claw.git
cd java-claw

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
"message": "Say hello for my friend Jhon"
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

JavaClaw aims to evolve into a fully autonomous agent capable of:

- Integrating with multiple tools

---

Made with 💻 + ☕
