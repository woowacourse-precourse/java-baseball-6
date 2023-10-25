package baseball.view;

import baseball.model.Command;
import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String printGameResult(String hint) {
        System.out.println(hint);
        if (hint.equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String command = Console.readLine();
            validateCommand(command);
            return command;
        }
        return "";
    }

    private void validateCommand(String command) {
        boolean isRestartCommand = command.equals(Command.RESTART.getValue());
        boolean isFinishCommand = command.equals(Command.FINISH.getValue());
        if (!isRestartCommand && !isFinishCommand) {
            throw new IllegalArgumentException("the command must be 1 or 2");
        }
    }
}
