package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
        // 게임 시작 메세지
        System.out.println(GAME_START_MESSAGE);
        // 게임 시작
        BaseballGame game = new BaseballGame();
    }
}

class BaseballGame {
    private static final int NUM_COUNT = 3;
    private static final String NUM_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int RESTART_GAME = 1;
    private static final int END_GAME = 2;

    BaseballGame() {
        // 랜덤 값 생성
        int[] randNum = getRandomNumber();
        int randomNumber = Array.intArray2Int(randNum);
        System.out.println(randomNumber);
        // 랜덤 값 생성
        boolean ans = false;
        while (!ans) {
            ans = game(randNum);
        }
        askRestart();
    }

    public boolean game(int[] answer) {
        int[] userNum = getUserInput(); // 값 입력
        //입력된 값 체크
        int[] result = checkAnswer(userNum, answer);
        if (result[1] == 3) { // 정답
            System.out.println("3스트라이크");
            System.out.println(SUCCESS_MESSAGE);
            return true;
        } else { // 오답
            showResult(result);
            return false;
        }
    }

    private static int[] getUserInput() {
        System.out.print(NUM_INPUT_MESSAGE);
        // 값 입력
        String numInput = readLine();
        Array.checkInputNum(Array.str2CharArr(numInput));
        return Array.charArr2IntArr(Array.str2CharArr(numInput));
    }

    private static int[] getRandomNumber() {
        int[] randNum = new int[NUM_COUNT];
        int insertedNumCnt = 0;
        while (insertedNumCnt < NUM_COUNT) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!Array.checkArrayContain(randNum, num)) {
                randNum[insertedNumCnt] = num;
                insertedNumCnt++;
            }
        }
        return randNum;
    }

    private static int[] checkAnswer(int[] input, int[] answer) {
        Result result = new Result(input, answer);
        int[] count = {result.cnt[0], result.cnt[1]};
        return count;
    }

    private static void showResult(int[] cnt) {
        String result = "";
        if (cnt[0] != 0) {
            result += cnt[0] + "볼";
        }
        if (cnt[1] != 0) {
            if (cnt[0] != 0) {
                result += " ";
            }
            result += cnt[1] + "스트라이크";
        }

        if (cnt[0] == 0 && cnt[1] == 0) {
            result += "낫싱";
        }
        System.out.println(result);
    }

    private static void askRestart() {
        System.out.println(RESTART_GAME_MESSAGE);
        int askRestart = Array.str2Int(readLine());
        if (askRestart == RESTART_GAME) {
            BaseballGame game = new BaseballGame();
        } else if (askRestart != END_GAME) {
            System.out.println("다시 입력해주세요.");
            askRestart();
        }
    }
}

class Result {
    int[] cnt = {0, 0}; // ball, strike, out

    Result(int[] input, int[] answer) {
        countBallandStrike(input, answer);
    }

    void countBallandStrike(int[] input, int[] answer) {
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[j] == answer[i]) {
                    if (i == j) { // strike
                        cnt[1]++;
                    } else cnt[0]++; // ball
                }
            }
        }
    }
}

class Array {
    static boolean checkArrayContain(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    static int intArray2Int(int[] arr) {
        int num = 0;
        for (int i : arr) {
            num *= 10;
            num += i;
        }

        return num;
    }

    static char[] str2CharArr(String str) {
        char[] c = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            c[i] = str.charAt(i);
        }
        return c;
    }

    static int charArr2Int(char[] arr) {
        int num = 0;
        for (char c : arr) {
            int digit = c - '0';
            num *= 10;
            num += digit;
        }
        return num;
    }

    static int[] charArr2IntArr(char[] arr) {
        int[] num = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';
            num[i] = digit;
        }
        return num;
    }

    static int str2Int(String str) {
        return charArr2Int(str2CharArr(str));
    }

    static void checkInputNum(char[] arr) {
        if (!checkInputNum_len(arr) || !checkInputNum_isNum(arr) || !checkInputNum_noSameNum(arr)) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

    static boolean checkInputNum_len(char[] arr) {
        return arr.length == 3;
    }

    static boolean checkInputNum_isNum(char[] arr) {
        for (int n : arr) {
            if (n < 49 || n > 57) {
                return false;
            }
        }
        return true;
    }

    static boolean checkInputNum_noSameNum(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[0] == arr[1]) {
                    return false;
                }
            }
        }
        return true;
    }

}