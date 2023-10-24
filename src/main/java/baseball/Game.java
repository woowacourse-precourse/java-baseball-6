package baseball;


import java.util.Scanner;
import java.util.stream.IntStream;

public class Game{
    int[] answer;
    Computer computer;
    public void play(User user) {
        int strike = 0;

        while (strike != 3) {
            Stage stage = new Stage();
            int[] user_try = user.callNumber();
            strike = stage.getStrike(this.answer, user_try);
            int ball = stage.getBall(this.answer, user_try, strike);
            System.out.println(stage.getResult(strike, ball));
        }
    }

    public String askRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("3게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    }







