package autotest.production.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserinfoResponse {

    @JsonProperty("isCreated")
    private boolean created;

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("info")
    private UserStats info;

    @JsonProperty("colors")
    private List<String> colors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetUserinfoResponse that = (GetUserinfoResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(info, that.info) && Objects.equals(colors, that.colors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, info, colors);
    }

    @Override
    public String toString() {
        return "GetUserinfoResponse{" +
                "created=" + created +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", info=" + info +
                ", colors=" + colors +
                '}';
    }
}
