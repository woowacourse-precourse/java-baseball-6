package baseball;

import java.security.PrivateKey;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game rightAnswer = new Game();
        Game.start(rightAnswer);
    }
}

class Game {
    static private String INSERT_BLOCK = "숫자를 입력해주세요 : ";
    static private String GAME_START_COMMENT = "숫자 야구 게임을 시작합니다.";
    int[] answer = new int[3];
    boolean firstTime = true;

    Game() {
        System.out.println(GAME_START_COMMENT);
        int numberCount = 0;
        while (numberCount < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (Game.checkNum(randomNumber, answer)) {
                answer[numberCount] = randomNumber;
                numberCount++;
            }
        }
    /*    for (int j = 0; j < 3; j++) {
            System.out.print(answer[j]);
            System.out.println();
        }*/
    }

    Game(String input) {
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(input.charAt(i) + "");
        }
    }

    static void start(Game rightAnswer) {
        Game answer = Game.insert();
        Game.checkAnswer(answer, rightAnswer);
    }

    static Game insert() {
        System.out.print(INSERT_BLOCK);
        String input = readLine();
        Game.checkIsValidInput(input);
        return new Game(input);
    }

    static void checkAnswer(Game answer, Game rightAnswer) {
        int ballCount = 0;
        int strikeCount = 0;
        String nothing = "낫싱";
        String stringAnswer = Array.makeArrayToString(answer.answer);
        String stringRightAnswer = Array.makeArrayToString(rightAnswer.answer);
        for (int i = 0; i < stringRightAnswer.length(); i++) {
            for (int j = 0; j < stringAnswer.length(); j++) {
                if (stringRightAnswer.charAt(i) == stringAnswer.charAt(j)) {
                    if (i == j) {
                        strikeCount++;
                    }
                    if (i != j) {
                        ballCount++;
                    }
                }
            }
        }
        if (strikeCount > 0 && ballCount > 0 && strikeCount != 3) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            Game.start(rightAnswer);
        } else if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + "볼");
            Game.start(rightAnswer);
        } else if (strikeCount > 0 && ballCount == 0 && strikeCount != 3) {
            System.out.println(strikeCount + "스트라이크");
            Game.start(rightAnswer);
        } else if (strikeCount == 3) {
            System.out.println(strikeCount + "스트라이크");
            int newGameAnswer = Game.newGameSelection();
            if (newGameAnswer == 1) {
                rightAnswer = new Game();
                Game.start(rightAnswer);
            }
        } else if (strikeCount == 0 && ballCount == 0) {
            System.out.println(nothing);
            Game.start(rightAnswer);
        }
    }

    static int newGameSelection() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        System.out.print("게임을 다시 하시겠습니까?");
        String selection = readLine();
        return Game.getNewGameSelection(selection);
    }

    static int getNewGameSelection(String str) {
        int value;
        try {
            value = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
        if (value != 1 && value != 2) {
            System.out.println("입력값이 1또는 2가 아닙니다.");
            throw new IllegalArgumentException();
        }
        return value;
    }

    static boolean checkNum(int a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (b[i] == a) {
                return false;
            }
        }
        return true;
    }

    static void checkIsValidInput(String str) {
        if (!checkInputLength(str)) {
            System.out.println("올바르지 않은 길이의 입력값입니다.");
            throw new IllegalArgumentException();
        }
        if (!checkRightInput(str)) {
            System.out.println("올바르지 않은 형태의 입력값입니다.");
            throw new IllegalArgumentException();
        }
        if (!checkNoZero(str)) {
            System.out.println("입력값에 0이 포함되어있으면 안됩니다.");
            throw new IllegalArgumentException();
        }
        if (!checkSameNumber(str)) {
            System.out.println("서로 다른 숫자를 입력해야합니다.");
            throw new IllegalArgumentException();
        }
    }

    static boolean checkRightInput(String a) {
        try {
            int value = Integer.parseInt(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean checkInputLength(String a) {
        return a.length() == 3;
    }

    static boolean checkNoZero(String a) {
        int[] checkList = Array.makeStringToArray(a);
        for (int i : checkList) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean checkSameNumber(String a) {
        boolean[] checkList = new boolean[9];
        int[] inputValue = Array.makeStringToArray(a);
        int cnt = 0;
        for (int i = 1; i < checkList.length + 1; i++) {
            for (int j = 0; j < inputValue.length; j++) {
                if (inputValue[j] == i) {
                    checkList[i - 1] = true;
                }
                if (!checkList[i - 1]) {
                    checkList[i - 1] = false;
                }
            }
        }
        for (boolean j : checkList) {
            if (j == true) {
                cnt++;
            }
        }
        if (cnt == 3) {
            return true;
        }
        return false;
    }
}


class Array {
    static String makeArrayToString(int[] a) {
        String result = "";


        for (int i = 0; i < a.length; i++) {
            result = result + a[i];
        }
        return result;
    }

    static int[] makeStringToArray(String str) {
        int[] arr = new int[3];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.charAt(i) + "");
        }
        return arr;
    }
}
