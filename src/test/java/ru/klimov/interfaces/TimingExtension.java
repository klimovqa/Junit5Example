package ru.klimov.interfaces;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(TimingExtension.class);

    Logger logger = LoggerFactory.getLogger(TimeExecutionLogger.class.getName());

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        extensionContext.getStore(NAMESPACE)
                .put(extensionContext.getUniqueId(), System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        long startTime = (long) extensionContext.getStore(NAMESPACE)
                .get(extensionContext.getUniqueId());
        long executionTime = System.currentTimeMillis() - startTime;

        logger.info("Время выполнения теста: " + executionTime + " миллисекунд");
    }
}
