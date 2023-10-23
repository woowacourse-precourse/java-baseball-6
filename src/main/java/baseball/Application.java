package baseball;

import java.util.Arrays;

public class Application {
    // TODO: 프로그램 구현
    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        InputNumber inputNumber = new InputNumber();
//        System.out.println(randomNumber.createRanArr());
        int[]  a = inputNumber.createInputArr();
        inputNumber.checkNum(a);
    }


}
