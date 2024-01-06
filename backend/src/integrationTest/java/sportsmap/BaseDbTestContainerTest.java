package sportsmap;

import org.testcontainers.containers.PostgreSQLContainer;

public class BaseDbTestContainerTest extends PostgreSQLContainer<BaseDbTestContainerTest> {

    private static final String IMAGE_VERSION = "postgres:16-alpine";
    private static BaseDbTestContainerTest container;

    private BaseDbTestContainerTest() {
        super(IMAGE_VERSION);
    }

    public static BaseDbTestContainerTest getInstance() {
        if (container == null) {
            container = new BaseDbTestContainerTest();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
