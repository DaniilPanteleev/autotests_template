package autotest.production.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseBody {

    private String toJson(JsonInclude.Include include) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(include);
        mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.DEFAULT));

        String json;
        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(String.format("Exception while serializing DTO %s", this.getClass().getName()));
        }

        return json;
    }

    public String toJson() {
        return toJson(JsonInclude.Include.ALWAYS);
    }

    public String toJsonWithoutNull() {
        return toJson(JsonInclude.Include.NON_NULL);
    }

}
