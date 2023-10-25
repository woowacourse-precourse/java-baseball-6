package baseball.view;

import baseball.config.Config;
import baseball.domain.BaseballNumbers;
import baseball.domain.Command;
import baseball.util.Parser;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final int MAX_NUMBER = Config.getMaxNumbers();
    private static final String MSG_START = "숫자 야구 게임을 시작합니다.";
    private static final String MSG_REQUESTING_INPUT = "숫자를 입력해주세요. : ";
    private static final String MSG_GAME_OVER = MAX_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MSG_ASK_IF_CONTINUES = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요. %n";


    public static void printStart() {
        System.out.println(MSG_START);
    }

    public static void printRequestingInput() {
        System.out.print(MSG_REQUESTING_INPUT);
    }

    public static void printGameOver() {
        System.out.println(MSG_GAME_OVER);
        System.out.printf(MSG_ASK_IF_CONTINUES, Command.getRestart(), Command.getExit());
    }

    public static String getUserInput() {
        return Console.readLine();
    }

    public static BaseballNumbers getUserNumbers() {
        BaseballNumbers userNumbers = Parser.parseStringToBaseballNumbers(InputView.getUserInput());
        return userNumbers;
    }

    /* 값 확인용 */
    public static void printCheat(BaseballNumbers computerNumbers) {
        int index = 0;
        while (Config.isNotMaxNumbers(index)) {
            System.out.print(computerNumbers.get(index));
            index++;
        }
        System.out.println();
    }

}
