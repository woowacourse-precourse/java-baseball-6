package runGame;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import error.ErrorManage;
import java.util.List;

public class RunGame {
    String computer_num;

    public RunGame() {
        List<Integer> c_num = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        String List_to_String = c_num.toString();
        computer_num = List_to_String.replaceAll("[^0-9]", "");
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            RunGame runGame = new RunGame();
            runGame.gaemStart();
        } while (gameOver());

        Console.close();
    }

    private void gaemStart() {
        ErrorManage errorManage = new ErrorManage();
        String number; // 유저가 입력한 숫자

        do {
            System.out.print("숫자를 입력해주세요 : ");
            number = Console.readLine();
            errorManage.inputNumberErrorManage(number);
        } while (!gameResult(number).equals("3스트라이크"));
    }

    private String gameResult(String number) {
        int strike = isStrike(number);
        int ball = isBall(number);
        String result = NumOfStrikeAndBall(strike, ball);
        System.out.println(result);

        return result;
    }

    private boolean gameOver() {
        ErrorManage errorManage = new ErrorManage();
        String exit;

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        exit = Console.readLine();
        errorManage.exitNumberErrorManage(exit);
        return exit.equals("1");
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
            answer = "낫싱";
        }

        answer += NumOfBall(ball - strike);
        answer += NumOfStrike(strike);

        return answer;
    }

    private String NumOfStrike(int strike) {
        if (strike > 0) {
            return strike + "스트라이크";
        }

        return "";
    }

    private String NumOfBall(int ball) {
        if (ball > 0) {
            return ball + "볼 ";
        }

        return "";
    }


}
