package autotest.production.entities;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostUserinfoToServerInfo  extends BaseBody{

    private int age;
    private int growth;

}
