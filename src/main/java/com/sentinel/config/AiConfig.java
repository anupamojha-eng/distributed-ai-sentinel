package com.sentinel.config;

import com.sentinel.agent.SREAgent;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.ollama.OllamaEmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import java.time.Duration;

public class AiConfig {
    public static SREAgent createAgent() {
        // 1. Chat Model
        var chatModel = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("llama3.2")
                .timeout(Duration.ofMinutes(2))
                .temperature(0.0)
                .build();

        // 2. Embedding Model (mxbai-embed-large)
        var embeddingModel = OllamaEmbeddingModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("mxbai-embed-large")
                .build();

        // 3. Knowledge Store
        Document runbook = FileSystemDocumentLoader.loadDocument("src/main/resources/runbook.txt");
        var embeddingStore = new InMemoryEmbeddingStore<dev.langchain4j.data.segment.TextSegment>();

        // Ingest data
        EmbeddingStoreIngestor.builder()
                .embeddingModel(embeddingModel)
                .embeddingStore(embeddingStore)
                .build()
                .ingest(runbook);

        // 4. FIX: Pass the embeddingModel to the retriever
        ContentRetriever retriever = EmbeddingStoreContentRetriever.builder()
                .embeddingStore(embeddingStore)
                .embeddingModel(embeddingModel) // This was missing
                .maxResults(2)
                .build();

        return AiServices.builder(SREAgent.class)
                .chatLanguageModel(chatModel)
                .contentRetriever(retriever)
                .build();
    }
}