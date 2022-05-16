package autotest.production.entities;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PostUserinfoToServer extends BaseBody{

    private String name;
    private String lastName;
    private PostUserinfoToServerInfo info;
    private List<String> colors;

}
