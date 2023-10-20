package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        PrintGuide printGuide = new PrintGuide();
        NumberMaker numberMaker = new NumberMaker();

        printGuide.printGameStart();

        List<Integer> randomNumbers = numberMaker.makeRandomNumbers();
        System.out.println(randomNumbers);


    }
}
