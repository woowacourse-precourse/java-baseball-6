package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game computerAnswer = new Game();
        Game.gaming(computerAnswer);
    }
}

class Array {
    static boolean checkContains(final int[] arr, final int correctNumber) {
        for (int element : arr) {
            if (element == correctNumber) {
                return true;
            }
        }
        return false;
    }

    static boolean checkContains(final char[] arr, final char correctNumber) {
        for (int element : arr) {
            if (element == correctNumber) {
                return true;
            }
        }
        return false;
    }

    static char[] getCharArray(String str) {
        char[] charArray = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }
        return charArray;
    }
}

class Game {
    static final int NUMBER_COUNT = 3;

    int[] number = new int[NUMBER_COUNT];

    Game() {
        int numberIndex = 0;
        while (numberIndex < NUMBER_COUNT) {
            int randomNumber = pickNumberInRange(1,9);
            if (!Array.checkContains(number, randomNumber)) {
                number[numberIndex++] = randomNumber;
            }
        }
    }

    Game(String str) {
        for (int i = 0; i < Game.NUMBER_COUNT; i++) {
            number[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }

    public static void gaming(Game computerAnswer) {
        Game answer = Game.getAnswer();

        Hint hint = new Hint();
        hint.compareAnswer(answer, computerAnswer);
        hint.printHint();

        if (hint.strike != Game.NUMBER_COUNT) {
            Game.gaming(computerAnswer);
            return;
        }

        int newGameAnswer = Game.checkNewGameStart();
        if (newGameAnswer == 1) {
            computerAnswer = new Game();
            Game.gaming(computerAnswer);
        }
    }

    private static Game getAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        Game.checkInput(userInput);
        return new Game(userInput);
    }

    static void checkInput(final String str) {
        if (!Game.checkLength(str)) {
            throw new IllegalArgumentException();
        }
        if (!Game.checkType(str)) {
            throw new IllegalArgumentException();
        }
        if (!Game.checkZero(str)) {
            throw new IllegalArgumentException();
        }
        if (!Game.checkSameNumber(str)) {
            throw new IllegalArgumentException();
        }
    }

    static boolean checkLength(final String str) {
        return str.length() == Game.NUMBER_COUNT;
    }

    static boolean checkType(String str) {
        try {
            int intValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    static boolean checkZero(String str) {
        char[] numberArray = Array.getCharArray(str);
        return !Array.checkContains(numberArray, '0');
    }

    static boolean checkSameNumber(String str) {
        char[] checkEqual = new char[str.length()];
        char[] word = Array.getCharArray(str);

        for (int i = 0; i < str.length(); i++) {
            if (Array.checkContains(checkEqual, word[i])) {
                return false;
            }
            checkEqual[i] = word[i];
        }
        return true;
    }

    private static int checkNewGameStart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String newGameAnswer = readLine();
        return Game.getCheckedAnswer(newGameAnswer);
    }

    private static int getCheckedAnswer(String str) {
        int intValue;
        try {
            intValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (intValue != 1 && intValue != 2) {
            throw new IllegalArgumentException();
        }
        return intValue;
    }
}

class Hint {
    int ball, strike;

    void compareAnswer(Game answer, Game computerAnswer) {
        for (int i = 0; i < Game.NUMBER_COUNT; i++) {
            int curNumber = answer.number[i];

            if (!Array.checkContains(computerAnswer.number, curNumber)) {
                continue;
            } else if (computerAnswer.number[i] == curNumber) {
                this.strike++;
            } else {
                this.ball++;
            }
        }
    }

    void printHint() {
        String result = "";

        if (this.ball != 0) {
            result += this.ball + "볼";
        }
        if (this.strike != 0) {
            if (this.ball != 0) {
                result += " ";
            }
            result += this.strike + "스트라이크";
        }
        if (result.equals("")) {
            result = "낫싱";
        }

        System.out.println();
        System.out.println(result);
    }
}