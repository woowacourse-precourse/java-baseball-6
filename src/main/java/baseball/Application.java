package baseball;

import java.util.Arrays;



public class Application {
    // TODO: 프로그램 구현
    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        InputNumber inputNumber = new InputNumber();
        CompareNumber compareNumber = new CompareNumber();
        ReturnCount returnCount = new ReturnCount();
//        CompareNumber.CountDTO countDTO = new CompareNumber.CountDTO();
//        CompareNumber.CountDTO countDTO = new CompareNumber.CountDTO();
//        int[] a = inputNumber.createInputArr();
//        int[] b = randomNumber.createRanArr();
//        int strike = countDTO.getStrike();
//        int ball = countDTO.getBall();
//        compareNumber.getCount(a,b);
//        compareNumber.returnCount();
        int[] b = randomNumber.createRanArr();
        while(true){
            int[] a = inputNumber.createInputArr();
            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(b));
            String count = returnCount.count(a,b);
            System.out.println(count);
        }


    }


}
