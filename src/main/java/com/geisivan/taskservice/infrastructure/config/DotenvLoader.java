package com.geisivan.taskservice.infrastructure.config;

import com.geisivan.taskservice.infrastructure.exception.custom.EnvironmentVariableNotFoundException;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
public class DotenvLoader {

    private DotenvLoader(){}

    private static final Dotenv dotenv =
            Dotenv.configure().ignoreIfMissing().load();

    private static final List<String> REQUIRED_VARIABLES = List.of(
            "DB_HOST",
            "DB_PORT",
            "MONGO_DB",
            "USER_URL",
            "SERVER_PORT"
    );

    public static void load() {

        REQUIRED_VARIABLES.forEach(DotenvLoader::setSystemProperty);

        log.info("All required environment variables loaded successfully");
    }

    private static void setSystemProperty(String key) {

        String value = dotenv.get(key);

        if (value == null || value.isBlank()) {
            throw new EnvironmentVariableNotFoundException(key);
        }

        System.setProperty(key, value);
    }
}
