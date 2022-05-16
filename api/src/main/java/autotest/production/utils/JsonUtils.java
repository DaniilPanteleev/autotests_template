package autotest.production.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public final class JsonUtils {

    private JsonUtils() {
    }

    public static <T> List<T> deserializeJsonArrayFromFile(String fileName, Class<T> classToDeserialize) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, classToDeserialize);
            return mapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName), type);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Error while deserialize file: %s to class: %s", fileName, classToDeserialize.getName()));
        }
    }

    public static <T> T deserializeJsonFromFile(String fileName, Class<T> classToDeserialize) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName), classToDeserialize);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Error while deserialize file: %s to class: %s", fileName, classToDeserialize.getName()));
        }
    }

}
