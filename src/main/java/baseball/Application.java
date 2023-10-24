package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        CreatingAnswer answerMachine = new CreatingAnswer();
        int randomAnswer = answerMachine.getRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            CheckingInput checkMachine = new CheckingInput();
            checkMachine.CheckAll(input);

            ComparingInput compareMachine = new ComparingInput();
            compareMachine.Compare(randomAnswer, input);
            compareMachine.PrintResults();

            if (compareMachine.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                String inputNum = Console.readLine();
                if (inputNum.equals("2")) {
                    break;
                } else {
                    randomAnswer = answerMachine.getRandomNumber();
                    System.out.println(randomAnswer);
                    System.out.println("숫자 야구 게임을 시작합니다.");
                }
            }

        }

    }
}
