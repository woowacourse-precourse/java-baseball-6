package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game { // 숫자 야구 게임 진행

    static final int NUMBER_COUNT = 3; // 맞춰야 하는 숫자 개수 (3개)
    private static final int RESTART_NUMBER = 1; // 게임 재시작 숫자 : 1
    private static final int QUIT_NUMBER = 2; // 게임 종료 숫자 : 2
    
    // 사용자에게 출력되는 메시지
    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_CHECK_MESSAGE = "게임을 새로 시작하려면 " + RESTART_NUMBER + ", 종료하려면 " + QUIT_NUMBER + "를 입력하세요.";

    int[] numberArr = new int[NUMBER_COUNT]; // 숫자를 저장할 배열

    private int getRandomNumber() { // 컴퓨터의 숫자를 위한 범위 내의 난수를 생성해 반환
        return Randoms.pickNumberInRange(1, 9);
    }

    public Game() { // 컴퓨터의 숫자 초기화
        int comNumberIndex = 0;

        while (comNumberIndex < NUMBER_COUNT) {
            int comNumber = this.getRandomNumber();
            if (!BallStrike.checkArrayContains(numberArr, comNumber)) {
                numberArr[comNumberIndex++] = comNumber;
            }
        }
    }

    public Game(String str) { // 플레이어 숫자 입력받기
        for (int i = 0; i < Game.NUMBER_COUNT; i++) {
            numberArr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
    }

    // 플레이어 입력을 받고 답변 제공 & 게임 재시작/종료 여부 확인
    public static void replyToPlayer(Game rightAnswer) {
        Game answer = getAnswer();
        BallStrike ballStrike = new BallStrike();

        ballStrike.compareAnswer(answer, rightAnswer);
        ballStrike.showResult();

        if (ballStrike.strike != Game.NUMBER_COUNT) {
            replyToPlayer(rightAnswer);
            return;
        }

        int newOrOver = Game.checkRestartGame();
        if (newOrOver == Game.RESTART_NUMBER) {
            rightAnswer = new Game();
            replyToPlayer(rightAnswer);
        }
    }

    private static Game getAnswer() { // 플레이어의 입력값 받기
        System.out.print(GET_NUMBER_MESSAGE);
        String playerInput = Console.readLine();
        checkValidInput(playerInput);
        return new Game(playerInput);
    }

    // 플레이어의 입력값이 유효한 값인지 확인
    static void checkValidInput(final String str) {
        if (!isAbleLength(str)) {
            throw new IllegalArgumentException();
        }
        if (!isCorrectNumber(str)) {
            throw new IllegalArgumentException();
        }
        if (!hasNoDuplicates(str)) {
            throw new IllegalArgumentException();
        }
    }

    static boolean isAbleLength(final String str) { // 입력값의 길이가 3이 맞는가?
        return str.length() == NUMBER_COUNT;
    }

    static boolean isCorrectNumber(String str) { // 입력값이 숫자이며 주어진 범위 속에 있는가?
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        char[] numberArr = getCharFromString(str);
        return !checkArrayContains(numberArr, '0');
    }

    static boolean hasNoDuplicates(String str) { // 입력된 숫자에 중복이 없는가?
        char[] checkArr = new char[str.length()];
        char[] checkOne = getCharFromString(str);

        for (int i = 0; i < str.length(); i++) {
            if (checkArrayContains(checkArr, checkOne[i])) {
                return false;
            }
            checkArr[i] = checkOne[i];
        }
        return true;
    }

    static char[] getCharFromString(String str) { // 문자열 속 문자를 배열에 담아 저장하기
        char[] charArr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            charArr[i] = str.charAt(i);
        }
        return charArr;
    }

    // 배열에 찾는 값이 존재하는지 확인
    static boolean checkArrayContains(final char[] arr, final char number) {
        for (int val : arr) {
            if (val == number) {
                return true;
            }
        }
        return false;
    }

    // 정답 성공 후 게임 재시작 여부 확인
    private static int checkRestartGame() {
        System.out.println(SUCCESS_MESSAGE);
        System.out.println(NEW_GAME_CHECK_MESSAGE);

        String newOrOver = Console.readLine();
        return getAnswerAboutNewGame(newOrOver);
    }

    // 다음 게임 실행 여부에 대한 답변 유효성 검증
    private static int getAnswerAboutNewGame(String str) {
        int val;
        try {
            val = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (val != 1 && val != 2) { // 1 또는 2가 아닐 경우
            throw new IllegalArgumentException();
        }
        return val;
    }

}
