package baseball;

import baseball.controller.CalculateNumbers;
import baseball.controller.CheckNumbers;
import baseball.controller.GenerateNumbers;
import baseball.controller.InputCommand;
import baseball.model.ComputerNumberStorage;
import baseball.model.UserNumberStorage;
import baseball.view.PrintText;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        boolean gameContinue = true;
        PrintText.gameStart();
        while (gameContinue) {
            // 숫자야구 진행
            playGame();

            // 게임을 완전히 끝낼 건지 의사 묻기
            PrintText.playAgain();
            String quitCommand = InputCommand.inputNumber();

            // 입력받은 숫자의 숫자 유효성 검사 및 예외처리
            if (!CheckNumbers.checkQuitNumbers(quitCommand)) {
                throw new IllegalArgumentException();
            }

            // "2"라면 반복문 종료 => 전체 프로그램 종료
            if (quitCommand.equals("2")) {
                gameContinue = false;
            }
        }
    }

    // 숫자야구 한 판을 담당하는 playGame() 메소드
    private static void playGame() {

        // 컴퓨터 랜덤 숫자 생성 및 저장
        List<Integer> comNumberList = GenerateNumbers.makeRandomNumbers();
        ComputerNumberStorage com_memory = new ComputerNumberStorage(comNumberList);

        // 유저가 숫자야구 정답을 맞출 때까지 계속 반복함
        boolean userCorrect = false;
        while (!userCorrect) {

            // 사용자의 숫자 입력 받기
            PrintText.inputNumber();
            String userNumber = InputCommand.inputNumber();

            // 입력받은 숫자의 유효성 검사 및 예외처리
            if (!CheckNumbers.checkNormalNumbers(userNumber)) {
                throw new IllegalArgumentException();
            }

            List<Integer> userNumberList = UserNumberStorage.strToList(userNumber);

            // 낫띵, 볼, 스트라이크가 몇개인지 체크 후 반환
            List<Integer> result = CalculateNumbers.checkBall(com_memory.getNumbers(), userNumberList);
            PrintText.calculateResult(result.get(0), result.get(1), result.get(2));

            // 만약 3스트라이크이면, 성공 문구를 출력 후 while문을 종료
            if (result.get(2) == 3) {
                PrintText.success();
                userCorrect = true;
            }
        }
    }
}
