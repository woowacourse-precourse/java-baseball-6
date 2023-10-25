package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game rightAnswer = new Game(); // 새 게임을 시작할 때 정답을 생성
        Game.init(rightAnswer); // 게임 초기화 및 실행
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

    int[] number = new int[NUMBER_COUNT]; // 게임의 정답 숫자 배열

    Game() {
        int nowRandomNum;
        int nowNumberIndex = 0;

        while (nowNumberIndex < NUMBER_COUNT) {
            nowRandomNum = this.getRandomNumber(); // 1에서 9 사이의 난수 생성

            if (!Array.checkArrayContains(number, nowRandomNum)) { // 중복되지 않는 숫자를 선택
                number[nowNumberIndex++] = nowRandomNum;
            }
        }
    }

    Game(String str) {
        for (int i = 0; i < Game.NUMBER_COUNT; i++) {
            number[i] = Integer.parseInt(str.charAt(i) + ""); // 문자열로부터 숫자 배열 생성
        }
    }

    private int getRandomNumber() {
        return pickNumberInRange(Game.START_RANGE, Game.END_RANGE); // 지정 범위에서 무작위 숫자 반환
    }

    public static void init(Game rightAnswer) {
        Game answer = Game.getAnswer(); // 사용자 입력을 받아 게임 숫자를 생성

        Hint hint = new Hint();
        hint.compareAnswer(answer, rightAnswer); // 답안과 사용자 입력을 비교하여 스트라이크와 볼 계산
        hint.showResult(); // 게임 결과 출력

        if (hint.strike != Game.NUMBER_COUNT) { // 정답이 아니면 게임을 다시 시작
            Game.init(rightAnswer);
            return;
        }

        int newGameAnswer = Game.checkNewGameStart(); // 새 게임 시작 또는 종료 여부 확인
        if (newGameAnswer == Game.NEW_GAME) {
            rightAnswer = new Game(); // 새 게임을 시작
            Game.init(rightAnswer);
        }
    }

    private static Game getAnswer() {
        System.out.print(GET_NUMBER_MESSAGE);
        String userInput = readLine();
        Game.checkInputValue(userInput); // 사용자 입력 유효성 검사

        return new Game(userInput); // 사용자 입력으로부터 게임 숫자 생성
    }

    private static int checkNewGameStart() {
        System.out.println(SUCCESS_MESSAGE);
        System.out.println(NEW_GAME_CHECK_MESSAGE);

        String newGameAnswer = readLine();
        return Game.getNewGameAnswerNumber(newGameAnswer); // 새 게임 시작 또는 종료 여부 입력 받음
    }

    private static int getNewGameAnswerNumber(String str) {
        int intValue;
        try {
            intValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(); // 잘못된 입력 처리
        }

        if (intValue != 1 && intValue != 2) {
            throw new IllegalArgumentException(); // 1 또는 2가 아닌 입력 처리
        }

        return intValue;
    }

    public String toString() {
        return "number: " + this.number[0] + this.number[1] + this.number[2];
    }

    static void checkInputValue(final String str) {
        if (!Game.checkInputLength(str)) {
            throw new IllegalArgumentException(); // 입력 길이 검사
        }
        if (!Game.checkInputNumber(str)) {
            throw new IllegalArgumentException(); // 입력이 숫자가 아닌 경우 처리
        }
        if (!Game.checkEqualNumber(str)) {
            throw new IllegalArgumentException(); // 중복된 숫자가 있는 경우 처리
        }
    }

    static boolean checkInputLength(final String str) {
        return str.length() == Game.NUMBER_COUNT; // 입력 길이가 정확한지 확인
    }

    static boolean checkInputNumber(String str) {
        try {
            int numberValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false; // 숫자가 아닌 입력 처리
        }
        char[] numberArray = Array.getCharArrayFromString(str);
        return !Array.checkArrayContains(numberArray, '0'); // 숫자 0이 없는지 확인
    }

    static boolean checkEqualNumber(String str) {
        char[] checkEqual = new char[str.length()];
        char[] word = Array.getCharArrayFromString(str);

        for (int i = 0; i < str.length(); i++) {
            if (Array.checkArrayContains(checkEqual, word[i])) {
                return false; // 중복된 숫자 처리
            }
            checkEqual[i] = word[i];
        }

        return true;
    }
}

class Hint {
    int ball, strike; // 볼과 스트라이크 개수를 추적

    private static final String BALL_WORD = "볼";
    private static final String STRIKE_WORD = "스트라이크";
    private static final String NOT_MATCH_WORD = "낫싱";

    public String toString() {
        return "ball: " + this.ball + ", strike: " + this.strike;
    }

    private void addBallCount() {
        this.ball++; // 볼 카운트 증가
    }

    private void addStrikeCount() {
        this.strike++; // 스트라이크 카운트 증가
    }

    void compareAnswer(Game answer, Game rightAnswer) {
        int nowNumber;

        for (int i = 0; i < Game.NUMBER_COUNT; i++) {
            nowNumber = answer.number[i];

            if (!Array.checkArrayContains(rightAnswer.number, nowNumber)) {
                continue; // 숫자가 정답에 없으면 다음으로
            }
            if (i == Array.getIndexFromValue(rightAnswer.number, nowNumber)) {
                addStrikeCount(); // 숫자가 같고 위치도 같으면 스트라이크
                continue;
            }

            addBallCount(); // 숫자가 같고 위치가 다르면 볼
        }
    }

    void showResult() {
        String result = "";
        if (this.ball != 0) {
            result += this.ball + BALL_WORD; // 볼이 있는 경우 추가
        }

        if (this.strike != 0) {
            if (this.ball != 0) {
                result += " "; // 볼과 스트라이크 사이에 공백
            }
            result += this.strike + STRIKE_WORD; // 스트라이크가 있는 경우 추가
        }

        if (result.equals("")) {
            result = NOT_MATCH_WORD; // 볼과 스트라이크가 없는 경우 "낫싱" 출력
        }

        System.out.println(result);
    }
}
