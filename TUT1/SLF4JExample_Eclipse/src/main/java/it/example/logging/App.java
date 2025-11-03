package it.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

// TODO: Auto-generated Javadoc
/**
 * The Class App.
 */
public class App {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        LOGGER.info("Application starting");

        // Example: add correlation id in MDC
        String correlationId = UUID.randomUUID().toString();
        MDC.put("correlationId", correlationId);
        try {
            LOGGER.debug("Debug enabled: {}", LOGGER.isDebugEnabled());
            simulateWork();
            LOGGER.info("Application finished successfully");
        } catch (Exception e) {
            LOGGER.error("Unhandled error in application", e);
        } finally {
            MDC.clear();
        }
    }

    /**
     * Simulate work.
     *
     * @throws InterruptedException the interrupted exception
     */
    private static void simulateWork() throws InterruptedException {
        LOGGER.trace("Entered simulateWork()");

        LOGGER.info("Processing item {} of {}", 1, 5);

        try {
            int result = riskyOperation(2);
            LOGGER.debug("Result of riskyOperation = {}", result);
        } catch (IllegalArgumentException ex) {
            // log with stacktrace and contextual info
            LOGGER.warn("Recoverable problem during processing: {}", ex.getMessage(), ex);
        }

        // Simulate long operation and show conditional logging
        for (int i = 0; i < 3; i++) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Loop index {} details: {}", i, expensiveToString(i));
            }
            Thread.sleep(200);
        }

        LOGGER.trace("Exiting simulateWork()");
    }

    /**
     * Risky operation.
     *
     * @param value the value
     * @return the int
     */
    private static int riskyOperation(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value must be >= 0");
        }
        // simple logic
        return value * 42;
    }

    /**
     * Expensive to string.
     *
     * @param i the i
     * @return the string
     */
    private static String expensiveToString(int i) {
        // pretend this is an expensive operation
        try {
            Thread.sleep(50);
        } catch (InterruptedException ignored) {}
        return "expensive(" + i + ")";
    }
}
