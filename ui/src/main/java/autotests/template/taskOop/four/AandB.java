package autotests.template.taskOop.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AandB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        if (a < b) {
            for (int i = a; i <= b; i++) {
                System.out.println(i);
            }
        } else for (int i = a; i >= b; i--) {
            System.out.println(i);
        }
    }
}
