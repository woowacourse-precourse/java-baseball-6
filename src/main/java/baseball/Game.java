package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    boolean gameClear = false;
    List<Integer> computer = null;
    List<Integer> userGuess = null;
    int strike = 0;
    int ball = 0;


    public Game() {
        startAnnounce();
        computerPickNum();

        do {
            inputGuess();
            this.strike = 0;
            this.ball = 0;
            checkResult();
            printResult();
        } while (strike != 3);
        gameClearAnnounce();
    }

    private void printResult() {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }

        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }
    }

    private void computerPickNum() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.computer = computer;
    }

    private void inputGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> userGuess = new ArrayList<>();
        input.chars().forEach(i -> userGuess.add(i - 48));

        this.userGuess = userGuess;
    }

    private void checkResult() {
        for (int i = 0; i < 3; i++) {
            if (userGuess.get(i).equals(computer.get(i))) {
                strike++;
            } else {
                for (int j = 0; j < 3; j++) {
                    if (userGuess.get(i).equals(computer.get(j))) {
                        ball++;
                    }
                }
            }
        }
    }

    private void startAnnounce() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void gameClearAnnounce() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


}
