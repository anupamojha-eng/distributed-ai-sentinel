# 🛡️ Distributed AI Sentinel
### *Turning Distributed System Chaos into Deterministic Action*

The **Distributed AI Sentinel** is a Java-based SRE Orchestrator that uses local LLMs to perform **Causal Inference** across microservice boundaries. It bridges the gap between raw observability data (logs, traces, metrics) and actionable root-cause analysis.

---

## 🏗️ System Architecture & Design Decisions

### 1. The Reasoning Engine (Local-First AI)
* **Design Choice:** Leverages **Ollama (Llama 3.2)** via **LangChain4j**.
* **Rationale:** Enterprise infrastructure data is sensitive. A "Local-First" approach ensures that logs and proprietary architecture patterns never leave the private network, addressing the data sovereignty and security requirements of large-scale organizations.

### 2. Contextual Awareness (RAG Pipeline)
* **Design Choice:** In-memory Vector Store with **mxbai-embed-large** embeddings.
* **Rationale:** General-purpose LLMs lack "Tribal Knowledge." By implementing **Retrieval-Augmented Generation**, the Sentinel cross-references live telemetry against internal runbooks to provide context-specific fixes, reducing MTTR (Mean Time To Recovery).

### 3. Agentic Observability
* **Vision:** Rather than static dashboards, the Sentinel treats the system as a "Living Knowledge Graph."
* **Current State:** Simulations of K8s events, Kafka lag, and Spring Boot logs are processed through a reasoning loop.
* **Roadmap:** Integration with Fabric8 K8s Client and Prometheus API for autonomous system probing.

---

## 🛠️ Tech Stack
* **Runtime:** Java 21 (Virtual Threads)
* **AI Framework:** LangChain4j
* **Inference Engine:** Ollama (Llama 3.2 + mxbai-embed-large)
* **Build Tool:** Maven

---

## 🚀 Getting Started

### 1. Prerequisites
* Install [Ollama](https://ollama.com/)
* Pull the required models:
  ```bash
  ollama pull llama3.2
  ollama pull mxbai-embed-large