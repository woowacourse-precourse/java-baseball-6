package baseball;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    static final int NUMBER_COUNT = 3;
    private static final int REPLAY = 1;
    private static final int EXIT = 2;

    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String COMPLETE_MESSAGE = Game.NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CHECK_MESSAGE = "게임을 새로 시작하려면 " + Game.REPLAY + ", 종료하려면 " + Game.EXIT + "를 입력하세요.";

    int[] computerNum = new int[NUMBER_COUNT];

    Game() {
        int currentRandomNum;
        int currentNumberIndex = 0;

        while (currentNumberIndex < NUMBER_COUNT) {
            currentRandomNum = pickNumberInRange(Game.MIN_NUMBER, Game.MAX_NUMBER);

            if (!Array.checkArrayContains(computerNum, currentRandomNum)) {
                computerNum[currentNumberIndex++] = currentRandomNum;
            }
        }
    }

    Game(String str) {
        for (int i = 0; i < Game.NUMBER_COUNT; i++) {
            computerNum[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }

    public static void init(Game computer) {
        Game player = Game.getPlayerAnswer();

        Hint hint = new Hint();
        hint.compareAnswer(player, computer);
        hint.showResult();

        if (hint.strike != Game.NUMBER_COUNT) {
            Game.init(computer);
            return;
        }

        int newGameAnswer = Game.checkReplayOrExit();
        if (newGameAnswer == Game.REPLAY) {
            computer = new Game();
            Game.init(computer);
        }
    }

    private static Game getPlayerAnswer() {
        System.out.print(GET_NUMBER_MESSAGE);
        String playerInput = readLine();
        Game.checkInputException(playerInput);

        return new Game(playerInput);
    }

    private static int checkReplayOrExit() {
        System.out.println(COMPLETE_MESSAGE);
        System.out.println(CHECK_MESSAGE);

        String newGameAnswer = readLine();
        return Game.getNewGameAnswerNumber(newGameAnswer);
    }

    private static int getNewGameAnswerNumber(String str) {
        int intValue;
        try {
            intValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (intValue != REPLAY && intValue != EXIT) {
            throw new IllegalArgumentException();
        }

        return intValue;
    }

    static void checkInputException(final String str) {
        if (!Game.checkInputLength(str)) {
            throw new IllegalArgumentException();
        }
        if (!Game.checkInputNumber(str)) {
            throw new IllegalArgumentException();
        }
        if (!Game.checkEqualNumber(str)) {
            throw new IllegalArgumentException();
        }
    }

    static boolean checkInputLength(final String str) {
        return str.length() == Game.NUMBER_COUNT;
    }

    static boolean checkInputNumber(String str) {
        try {
            int numberValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        char[] numberArray = Array.getCharArrayFromString(str);
        return !Array.checkArrayContains(numberArray, '0');
    }

    static boolean checkEqualNumber(String str) {
        char[] checkEqual = new char[str.length()];
        char[] word = Array.getCharArrayFromString(str);

        for (int i = 0; i < str.length(); i++) {
            if (Array.checkArrayContains(checkEqual, word[i])) {
                return false;
            }
            checkEqual[i] = word[i];
        }

        return true;
    }
}
