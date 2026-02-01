package com.sentinel.simulator;

import java.time.Instant;

public class IncidentSimulator {
    public static String generateChaosScenario() {
        return String.format("""
            --- INCOMING TELEMETRY STREAM ---
            %s [K8S-EVENT] Pod 'payment-processor-7f8b' status: CrashLoopBackOff (Reason: OOMKilled)
            %s [APP-LOGS]  PAYMENT-SERVICE | ERROR: java.lang.OutOfMemoryError: Java heap space
            %s [METRICS]   KAFKA-CLUSTER  | Consumer Lag: 145,000 messages (Group: 'fulfillment-group')
            %s [APP-LOGS]  ORDER-API      | WARN: High latency on POST /orders (9500ms)
            %s [APP-LOGS]  ORDER-API      | ERROR: CircuitBreaker 'payment-service' is OPEN
            ----------------------------------
            """,
                Instant.now().minusSeconds(40),
                Instant.now().minusSeconds(35),
                Instant.now().minusSeconds(20),
                Instant.now().minusSeconds(10),
                Instant.now());
    }
}