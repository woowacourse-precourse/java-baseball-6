package baseball;

import baseball.FeedbackAssistant;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class Evaluator {
    private final FeedbackAssistant feedbackAssistant;
//    private static String userInput;
    Evaluator(){
        this.feedbackAssistant = new FeedbackAssistant();
    }
    public Boolean evaluateUserInput() throws IllegalArgumentException {
        String userInput = this.getUserInput();
        this.feedbackAssistant.printString(userInput);
        this.isValidInput(userInput);
        return true;
    }
    private static String getUserInput(){
        System.out.println("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    private static void isValidInput(String userInput) throws IllegalArgumentException {
        isLegthValid(userInput);
        isMadeOfUniqueDigit(userInput);
    }

    private static void isLegthValid(String userInput) throws IllegalArgumentException {
        if (userInput.length() != 3)
            throw new IllegalArgumentException("서로 다른 3자리 수를 입력하세요. 게임을 종료합니다.");
    }

    private static void isMadeOfUniqueDigit(String userInput) throws IllegalArgumentException {
        List<Character> temp = new ArrayList<Character>();
        for (int i = 0; i < userInput.length(); ++i){
            if (Character.isDigit(userInput.charAt(i)) == false)
                throw new IllegalArgumentException("서로 다른 3자리 수를 입력하세요. 게임을 종료합니다.");
            if (temp.contains(userInput.charAt(i)) == true)
                throw new IllegalArgumentException("서로 다른 3자리 수를 입력하세요. 게임을 종료합니다.");
            temp.add(userInput.charAt(i));
        }
    }

}