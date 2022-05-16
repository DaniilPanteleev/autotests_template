package autotest.production.entities;


import lombok.Builder;

@Builder
public class PutUserinfoToServer extends BaseBody {

    private String name;
    private String lastName;
}
