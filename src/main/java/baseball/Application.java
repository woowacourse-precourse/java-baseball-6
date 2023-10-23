package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 1. 정답 생성
        CreatingAnswer answerMachine = new CreatingAnswer();
        int randomAnswer = answerMachine.getRandomNumber();
        System.out.println(randomAnswer);

        // 2. 사용자 입력 받기
        String input = Console.readLine();
        CheckingInput checkMachine = new CheckingInput();
        checkMachine.CheckAll(input);

        // 3. 값을 비교하고, 출력하기
        ComparingInput compareMachine = new ComparingInput();
        compareMachine.Compare(randomAnswer, input);
        compareMachine.PrintResults();
    }
}
