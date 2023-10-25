package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        CreateNumber createNumber = new CreateNumber();
        UserInput userInput = new UserInput();
        CompareNumber compareNumber = new CompareNumber();
        ResultOutput resultOutput = new ResultOutput();
        String userChoice;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            List<Integer> computerNumber = createNumber.createComputerNumber();
            List<Integer> userNumber;
            boolean isCorrect;

            do{
                userNumber = userInput.getInput();
                int[] strikesAndBalls = compareNumber.compareNumber(userNumber,computerNumber);
                isCorrect = resultOutput.outputResult(strikesAndBalls[0],strikesAndBalls[1]);
            }while (!isCorrect);

            userChoice = GameMenu.getUserChoice();
            computerNumber.clear();
        } while (GameMenu.RESTART.equals(userChoice));

        if (GameMenu.END.equals(userChoice)) {
            System.out.println("게임을 종료합니다.");
        }
    }
}
