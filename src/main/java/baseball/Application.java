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
        CheckingAnswer checkMachine = new CheckingAnswer();
        checkMachine.CheckAll(input);
    }
}
