# 🛡️ Distributed AI Sentinel
### *Turning Distributed System Chaos into Deterministic Action*

The **Distributed AI Sentinel** is a Java-based SRE Orchestrator that uses local LLMs to perform **Causal Inference** across microservice boundaries. It bridges the gap between raw observability data (logs, traces, metrics) and actionable root-cause analysis.

---

## 🏗️ System Architecture & Design Decisions

### 1. The Reasoning Engine (Local-First AI)
* **Design Choice:** Leverages **Ollama (Llama 3.2)** via **LangChain4j**.
* **Rationale:** Enterprise infrastructure data is sensitive. A "Local-First" approach ensures that logs and proprietary architecture patterns never leave the private network, addressing the data sovereignty and security requirements of large-scale organizations (e.g., Finance, Automotive, Healthcare).

### 2. Contextual Awareness (RAG Pipeline)
* **Design Choice:** In-memory Vector Store with **mxbai-embed-large** embeddings.
* **Rationale:** General-purpose LLMs lack "Tribal Knowledge." By implementing **Retrieval-Augmented Generation**, the Sentinel cross-references live telemetry against internal runbooks and architecture docs to provide context-specific fixes, reducing MTTR (Mean Time To Recovery) significantly.

### 3. Agentic Observability
* **Vision:** Rather than static dashboards, the Sentinel treats the system as a "Living Knowledge Graph."
* **Current State:** Simulations of K8s events, Kafka lag, and Spring Boot logs are processed through a reasoning loop.
* **Roadmap:** Integration with Fabric8 K8s Client and Prometheus API for autonomous system probing.



---

## 🛠️ Tech Stack
* **Runtime:** Java 21 (Leveraging Virtual Threads for high-concurrency telemetry ingestion)
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
  
### 2 Build the project 
* Clone the repository:
  ```bash
  git clone [https://github.com/anupamojha-eng/distributed-ai-sentinel.git](https://github.com/YOUR_USERNAME/distributed-ai-sentinel.git)
cd distributed-ai-sentinel
mvn clean install
    ```

### 3. Run the Sentinel
* Execute the main class:
* ```bash
    mvn exec:java -Dexec.mainClass="com.sentinel.SentinelApp"
    ```


I'm looking to connect with other Platform Engineers and Architects who are exploring **Agentic Infrastructure**. If you're building in this space, let's talk.