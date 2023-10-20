package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        PrintMessage printMessage = new PrintMessage();
        printMessage.printGameStartMessage();

        AnswerNumberGenerator answerNumberGenerator = new AnswerNumberGenerator();
        List<Integer> answerNumberList = answerNumberGenerator.getAnswerNumberList();
    }
}