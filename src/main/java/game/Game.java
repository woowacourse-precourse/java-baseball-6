package game;

import static constant.Constant.ASK_INPUT_NUMBER_MSG;
import static constant.Constant.ASK_RESTART_MSG;
import static constant.Constant.BALL;
import static constant.Constant.DUPLI_EXCEPTION_MSG;
import static constant.Constant.EXIT_GAME_NUMBER;
import static constant.Constant.LENGTH_EXCEPTION_MSG;
import static constant.Constant.MAX_NUM;
import static constant.Constant.MIN_NUM;
import static constant.Constant.NOTHING_MSG;
import static constant.Constant.NUM_DIGITS;
import static constant.Constant.RANGE_EXCEPTION_MSG;
import static constant.Constant.RESTART_GAME_NUMBER;
import static constant.Constant.START_MSG;
import static constant.Constant.STRIKE;
import static constant.Constant.SUCCESS_MSG;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void run() {
        System.out.println(START_MSG);

        Game game = new Game();
        do {
            game.gameStart(0);
        } while (game.rerun());
    }

    //게임 재시작 여부
    public boolean rerun() {
        System.out.println(ASK_RESTART_MSG);
        String UserInput = Console.readLine();

        if (UserInput.length() > 1) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MSG);
        }

        char Input = UserInput.charAt(0);

        if (Input < RESTART_GAME_NUMBER && Input > EXIT_GAME_NUMBER) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MSG);
        }

        return isRerun(Input);
    }

    private boolean isRerun(char Input) {
        if (Input == RESTART_GAME_NUMBER) {
            return true;
        }
        if (Input == EXIT_GAME_NUMBER) {
            return false;
        }
        return false;
    }

    //게임 시작
    public void gameStart(int strike) {
        List<Integer> targetNumber = new ArrayList<>(getRandomNum());
        start(strike, targetNumber);
    }

    private int start(int strike, List<Integer> targetNumber) {
        if (strike == NUM_DIGITS) {
            System.out.println(NUM_DIGITS + SUCCESS_MSG);
            return 0;
        }
        System.out.print(ASK_INPUT_NUMBER_MSG);
        List<Integer> inputNumber = new ArrayList<>(getInputNum());
        strike = getResult(targetNumber, inputNumber);
        return start(strike, targetNumber);
    }

    //게임 결과 판독
    private int getResult(List<Integer> inputNumber, List<Integer> targetNumber) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < NUM_DIGITS; i++) {
            for (int j = 0; j < NUM_DIGITS; j++) {
                if (targetNumber.get(i).equals(inputNumber.get(j)) && i == j) {
                    strike++;
                }
                if (targetNumber.get(i).equals(inputNumber.get(j)) && i != j) {
                    ball++;
                }
            }
        }
        getHint(ball, strike);
        return strike;
    }

    private void getHint(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.print(NOTHING_MSG);
        }
        if (ball != 0) {
            System.out.print(ball + BALL + " ");
        }
        if (strike != 0) {
            System.out.print(strike + STRIKE);
        }
        System.out.println();
    }

    //랜덤값 추출
    private List<Integer> getRandomNum() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < NUM_DIGITS) {
            int Num = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!randomNumber.contains(Num)) {
                randomNumber.add(Num);
            }
        }
        return randomNumber;
    }

    //사용자 입력값
    private List<Integer> getInputNum() {

        String UserInput = Console.readLine();

        if (UserInput.length() > NUM_DIGITS) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MSG);
        }

        List<Integer> inputNum = new ArrayList<>();
        for (int i = 0; i < UserInput.length(); i++) {
            int num = charToInt(UserInput.charAt(i));

            if (num < MIN_NUM && num > MAX_NUM) {
                throw new IllegalArgumentException(RANGE_EXCEPTION_MSG);
            }
            if (!inputNum.isEmpty() && inputNum.contains(num)) {
                throw new IllegalArgumentException(DUPLI_EXCEPTION_MSG);
            }

            inputNum.add(num);
        }
        return inputNum;
    }

    private int charToInt(char ch) {
        return ch - '0';
    }
}

