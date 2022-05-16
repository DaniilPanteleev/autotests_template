package autotest.production.config;

public final class Config {

    public final static String url;
    public final static Integer port;

    private Config() {}

    static {
        url = "https://e54df3b1-f490-4d19-8175-cb2c67d68fbe.mock.pstmn.io";
        port = 443;
    }
}
