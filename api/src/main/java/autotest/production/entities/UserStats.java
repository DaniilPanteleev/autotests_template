package autotest.production.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserStats {

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("growth")
    private Integer growth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserStats userStats = (UserStats) o;
        return Objects.equals(age, userStats.age) && Objects.equals(growth, userStats.growth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, growth);
    }

    @Override
    public String toString() {
        return "UserStats{" +
                "age=" + age +
                ", growth=" + growth +
                '}';
    }
}
