package autotests.template.oop.abstraction;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        if(1<2 & 1==1 ){
            System.out.println("123");
        }
        if (2<2 && 1==1){
            System.out.println("444");
        }
        if(1<2 | 1==1 ){
            System.out.println("123");
        }
        if (1<2 || 1==1){
            System.out.println("444");
        }
        String[] list = {"123", "456", "789", "101"};
        String[] list2 =  new String[4];
        List<String> list3 = new ArrayList<>();
    }
}
