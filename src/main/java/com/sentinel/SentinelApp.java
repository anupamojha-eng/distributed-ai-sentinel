package com.sentinel;

import com.sentinel.config.AiConfig;
import com.sentinel.simulator.IncidentSimulator;

public class SentinelApp {
    public static void main(String[] args) {
        var agent = AiConfig.createAgent();

        // Simulate the live stream
        String liveStream = IncidentSimulator.generateChaosScenario();
        System.out.println(liveStream);

        System.out.println(">>> SENTINEL: ANALYZING LIVE STREAM FOR CAUSAL LINKS...");
        String diagnosis = agent.diagnose(liveStream);

        System.out.println("\n--- SENTINEL SRE ANALYSIS ---");
        System.out.println(diagnosis);
        System.exit(0);
    }
}