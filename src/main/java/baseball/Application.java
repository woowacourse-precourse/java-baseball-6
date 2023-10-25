package baseball;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game rightAnswer = new Game();
        //Game.init(rightAnswer);
    }
}
class Array {
    static boolean checkArrayContains(final int[] arr, final int number) {
        for (int value : arr) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }

    static boolean checkArrayContains(final char[] arr, final char number) {
        for (int value : arr) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }

    static char[] getCharArrayFromString(String str) {
        char[] charArray = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }

        return charArray;
    }

    static int getIndexFromValue(final int[] arr, final int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
class Game {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    static final int NUMBER_COUNT = 3;
    private static final int NEW_GAME = 1;
    private static final int QUIT_GAME = 2;

    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = Game.NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_CHECK_MESSAGE = "게임을 새로 시작하려면 " + Game.NEW_GAME + ", 종료하려면 " + Game.QUIT_GAME + "를 입력하세요.";

    int[] number = new int[NUMBER_COUNT];

}


