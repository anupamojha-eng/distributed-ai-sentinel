# Distributed AI Sentinel 🚀

### The "Method in the Madness" for Distributed Systems
In high-scale microservice environments, a single failure often ripples through the network, creating a cascade of cryptic logs. The **Distributed AI Sentinel** is an AI-Native Infrastructure agent designed to perform **Causal Discovery** across service boundaries using local LLMs.

---

## 🏗️ Architectural Vision
Standard Observability tells you *when* a system is failing. This Sentinel tells you *why*. 
By leveraging **OpenTelemetry** trace propagation and **LangChain4j**, it reconstructs the span tree and uses a local reasoning engine to identify root causes in seconds, not hours.

## 🛠️ Tech Stack
- **Language:** Java 21 (leveraging Virtual Threads for high-concurrency telemetry ingestion)
- **AI Orchestration:** LangChain4j
- **Inference Engine:** Ollama (running Llama3/Mistral locally)
- **Tracing Standard:** OpenTelemetry (W3C Trace Context)

## 🚀 Quick Start
1. **Ensure Ollama is running:** `ollama run llama3`
2. **Clone and Run:**
   ```bash
   mvn clean install
   java -jar target/sentinel-1.0.jar
