package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args){
        System.out.println("야구게임시작");
        NumberManager numberManager = new NumberManager();
        List<Integer> randNum = numberManager.createRandomNumber();
        List<Integer> num = numberManager.receiveNumber();

        System.out.println("randnum = "+randNum);
        System.out.println("num = "+num);

    }
}
