package baseball;

import baseball.message.GameMessage;
import baseball.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private InputValidator validator = new InputValidator();
    private Computer computer = new Computer();
    private User user = new User();

    public void start() {
        System.out.println(GameMessage.GAME_START.getMessage());
        while (true) {
            progress();

            if (!isRestart()) {
                break;
            }
        }
    }

    public void progress() {
        computer.setComputerRandNum();

        while (true) {
            System.out.println(GameMessage.USER_INPUT.getMessage());
            String input = Console.readLine(); // 사용자 입력
            validator.validateInputNumber(input); // 입력값 검증
            user.setUserRandNum(input);

            GameResult result = computer.calculateResult(user.getUserRandNum());
            System.out.println(result.resultToString());

            if (result.isComplete()) { // 게임이 끝나는 조건
                System.out.println(GameMessage.GAME_COMPLETE.getMessage());
                break;
            }
        }
    }

    public boolean isRestart() {
        System.out.println(GameMessage.GAME_RESTART);
        String input = Console.readLine();
        validator.validateRestartChoice(input);

        if ("1".equals(input)) { // 게임 재시작
            return true;
        } else { // 게임 종료
            return false;
        }
    }
}
