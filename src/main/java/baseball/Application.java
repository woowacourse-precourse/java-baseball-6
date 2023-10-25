package baseball;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computerNumber = new Init().getComputerNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            Input input = new Input(userInput);
            input.checkException();


            Output output = new Output();
            output.setScore(computerNumber, userInput);
            output.printOutput();

            if (output.userWin()) {
                output.printGameEnd();
                String continueOrEnd = Console.readLine();

                InputContinueOrEnd inputContinueOrEnd = new InputContinueOrEnd();

                if (inputContinueOrEnd.error(continueOrEnd)) throw new IllegalArgumentException();


                if (inputContinueOrEnd.quit(continueOrEnd)) break;
                computerNumber = new Init().getComputerNumber();
            }
        }
    }
}
