package baseball;

import baseball.logic.Compare;
import baseball.logic.ComputerCreateRandomNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    private final ComputerCreateRandomNumber createRandomNumber;
    private final Compare compare;

    public Application() {
        this.createRandomNumber = new ComputerCreateRandomNumber();
        this.compare = new Compare();
    }

    // 숫자 야구 게임 실행. 재시작이 false가 되면 종료
    public void run() {
        boolean restartGame;

        do {
            playBaseBallGame();
            restartGame = askRestartOrEnd();
        } while (restartGame);
    }

    // 컴퓨터 랜덤값 추출 및 사용자 입력값 확인 후 실제 비교 로직으로 이동
    private void playBaseBallGame() {
        List<Integer> computerInput = createRandomNumber.createRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isCorrectNumber = false;

        while (!isCorrectNumber) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();

                String result = compare.getGameResult(computerInput, userInput);
                System.out.println(result);

                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞혔습니다! 게임 종료");
                    isCorrectNumber = true;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
            }
        }
    }

    // 종료되면 새로 시작할지, 종료할지 물어봄. 이외의 숫자 혹은 문자열이 입력되면 IllegalArgumentException 발생
    private boolean askRestartOrEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        int againGame = Integer.parseInt(Console.readLine());

        if (againGame == 2) {
            return false;
        }
        else if (againGame != 1) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        return true;
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
