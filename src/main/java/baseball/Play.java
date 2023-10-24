package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Play {

    private static final int START = 1;
    private static final int END = 9;
    static final int COUNT = 3;
    private static final int NEW_PLAY = 1;
    private static final int QUIT_PLAY = 2;
    private static final String NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_PLAY_MESSAGE = "게임을 새로 시작하려면 " + NEW_PLAY + ", 종료하려면 " + QUIT_PLAY + "를 입력하세요.";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    int ball_cnt = 0;
    int strike_cnt = 0;
    int answer[] = new int[COUNT];
    int input[] = new int[COUNT];

    Play() {
        createNumArray(answer);
    }

    public void playStart() {
        System.out.println(NUMBER_MESSAGE);
        String inputStringNum = readLine();
        checkInput(inputStringNum);
        for (int i = 0; i < COUNT; i++) {
            input[i] = Integer.parseInt(inputStringNum.charAt(i) + "");
        }
        compare(answer, input);
        show();
        if (strike_cnt == COUNT) {
            System.out.println(SUCCESS_MESSAGE);
            System.out.println(NEW_PLAY_MESSAGE);
            String choice = readLine();
            if (Integer.parseInt(choice) == NEW_PLAY) {
                startAgain();
            }
        } else {
            playStart();
        }
    }

    private void createNumArray(int a[]) {
        int randomNum = 0;
        int randomNumCnt = 0;

        while (randomNumCnt < COUNT) {
            randomNum = Randoms.pickNumberInRange(START, END);

            if (checkNotContains(answer, randomNum)) {
                answer[randomNumCnt++] = randomNum;
            }
        }
    }

    void show() {
        String result = "";
        if (ball_cnt != 0) {
            result += ball_cnt + BALL + " ";
        }
        if (strike_cnt != 0) {
            if (ball_cnt == 0) {
                result += strike_cnt + STRIKE;
            } else {
                result += strike_cnt + STRIKE;
            }
        }

        if (ball_cnt + strike_cnt == 0) {
            result = NOTHING;
        }
        if (strike_cnt != COUNT) {
            ball_cnt = 0;
            strike_cnt = 0;
        }

        System.out.println(result);
    }

    private void compare(int answer[], int input_string_num[]) {
        int num = 0;
        for (int i = 0; i < COUNT; i++) {
            num = input_string_num[i];
            if (checkNotContains(answer, num)) {
                continue;
            }
            if (returnIndex(answer, num, i)) {
                strike_cnt++;
                continue;
            }
            ball_cnt++;
        }
    }

    private void startAgain() {
        Play play = new Play();
        int answer[] = new int[COUNT];
        int input[] = new int[COUNT];
        strike_cnt = 0;
        ball_cnt = 0;
        play.playStart();

    }

    private void checkInput(String inputValue) {
        if (!checkLength(inputValue)) {
            throw new IllegalArgumentException();
        }
        if (!checkInt(inputValue)) {
            throw new IllegalArgumentException();
        }
        if (!checkInputSame(inputValue)) {
            throw new IllegalArgumentException();
        }
        if (!checkIncludeZero(inputValue)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkLength(String inputValue) {
        if (inputValue.length() != COUNT) {
            return false;
        }
        return true;
    }

    private boolean checkInt(String inputValue) {
        try {
            Integer.parseInt(inputValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkInputSame(String inputValue) {
        int count = 0;
        char[] num = changeStringToChar(inputValue);
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : num) {
            if (map.get(c) == null) {
                map.put(c, count);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        if (map.size() != COUNT) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkIncludeZero(String inputValue) {
        char c[] = changeStringToChar(inputValue);
        for (char value : c) {
            if (value == '0') {
                return false;
            }
        }
        return true;
    }


    private char[] changeStringToChar(String inputValue) {
        char c[] = new char[COUNT];
        for (int i = 0; i < COUNT; i++) {
            c[i] = inputValue.charAt(i);
        }
        return c;
    }


    private boolean checkNotContains(int a[], int num) {

        for (int now_num : a) {
            if (now_num == num) {
                return false;
            }
        }
        return true;
    }

    private boolean returnIndex(int answer[], int num, int index) {
        for (int i = 0; i < COUNT; i++) {
            if (num == answer[i] && index == i) {
                return true;
            }
        }
        return false;
    }
}
