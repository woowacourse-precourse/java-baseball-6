package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {

    public void play() {
        Computer computer = new Computer();
        Player player = new Player();

        List<Integer> randomNumberList = computer.generateRandomNumberList();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> playerNumberList = player.InputplayerNumber();

            GameResult gameResult = computer.judge(randomNumberList, playerNumberList);

            gameResult.printResult();

            if (gameResult.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            
        }
    }

    public boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String response = Console.readLine();

        Validator.isValidateRestartInput(response);

        if (response.equals("1")) {
            return true;
        }
        return false;
    }
}
