package baseball;

import java.util.Arrays;

public class Application {
    // TODO: 프로그램 구현
    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        InputNumber inputNumber = new InputNumber();
        CompareNumber compareNumber = new CompareNumber();


        int[] a = inputNumber.createInputArr();
        int[] b = randomNumber.createRanArr();
        compareNumber.compareNumber(a,b);

    }


}
