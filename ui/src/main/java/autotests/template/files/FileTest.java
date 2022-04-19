package autotests.template.files;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

public class FileTest {
    public static void main(String[] args) throws URISyntaxException, IOException {
        System.out.println(System.getProperty("user.dir"));
        File file = new File(Thread.currentThread().getContextClassLoader().getResource("Test1.txt").toURI());
        System.out.println( FileUtils.readLines(file, Charset.defaultCharset()));
    }
}
