package autotests.template;

import java.io.File;


public class ASDF {


    public static void main(String[] args) {
        File s = new File("");
        boolean x = s.delete();
        if (x){
            System.out.println("file delete");
        }
    }
}
