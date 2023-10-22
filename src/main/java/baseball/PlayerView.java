package baseball;

import camp.nextstep.edu.missionutils.Console;

public class PlayerView {
    public static String START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    public static String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    public static String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    public static String INPUT_RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    public static String RETRY_NUMBER = "1";
    public static String NOTHING = "낫싱";
    public static String STRIKE = "스트라이크";
    public static String BALL = "볼 ";

    public String input() {
        return Console.readLine();
    }

    public void output(String message) {
        System.out.print(message);
    }
}
