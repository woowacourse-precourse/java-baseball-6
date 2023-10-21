package runGame;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import error.ErrorManage;

import java.util.ArrayList;
import java.util.List;

import static runGame.constant.*;

public class RunGame {
    private String computer_num;

    public RunGame() {
        List<Integer> c_number = new ArrayList<>();
        while (c_number.size() < ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!c_number.contains(randomNumber)) {
                c_number.add(randomNumber);
            }
        }
        String List_to_String = c_number.toString();
        computer_num = List_to_String.replaceAll("[^0-9]", "");
    }

    public static void run() {
        System.out.println(START_GAME);
        RunGame runGame;

        do {
            runGame = new RunGame();
            runGame.gaemStart();
        } while (runGame.gameOver());
    }

    private void gaemStart() {
        ErrorManage errorManage = new ErrorManage();
        String number; // 유저가 입력한 숫자

        do {
            System.out.print(INPUT_NUMBER);
            number = Console.readLine();
            errorManage.inputNumberErrorManage(number);
        } while (!gameResult(number).equals(SUCCESS));
    }

    private String gameResult(String number) {
        String result = NumOfStrikeAndBall(isStrike(number), isBall(number));
        System.out.println(result);

        return result;
    }

    private boolean gameOver() {
        ErrorManage errorManage = new ErrorManage();
        String exit;

        System.out.println(GAME_OVER);
        System.out.println(RESTART_GAEM);

        exit = Console.readLine();
        errorManage.exitNumberErrorManage(exit);

        return exit.equals(RESTART_NUMBER);
    }

    private int isStrike(String numbers) {
        int strike = 0;

        for (int i = 0; i < computer_num.length(); i++) {
            if (numbers.charAt(i) == computer_num.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int isBall(String numbers) {
        int ball = 0;

        for (int i = 0; i < numbers.length(); i++) {
            String number = numbers.substring(i, i + 1);
            if (computer_num.contains(number)) {
                ball++;
            }
        }
        return ball;
    }

    private String NumOfStrikeAndBall(int strike, int ball) {
        String answer = "";

        if (strike == 0 && ball == 0) {
            answer = NOTHING;
        }

        answer += NumOfBall(ball - strike);
        answer += NumOfStrike(strike);

        return answer;
    }

    private String NumOfStrike(int strike) {
        if (strike > 0) {
            return strike + STRIKE;
        }

        return "";
    }

    private String NumOfBall(int ball) {
        if (ball > 0) {
            return ball + BALL;
        }

        return "";
    }


}
