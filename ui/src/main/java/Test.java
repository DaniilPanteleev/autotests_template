public class Test {
    public static void main(String[] args) {
        int[] list = {0, 1, 3, 4};
        Integer result = null;
        if (list[0] != 0){
            result = 0;
        }

        for(int i = 0; i < list.length; i++){
            if (i < list.length -1 && list[i+1] - list[i] ==2){
                result =list[i] + 1;
            }

        }
        if (result == null){
            result = list[list.length-1] +1;

        }
        System.out.println(result);


    }
}
