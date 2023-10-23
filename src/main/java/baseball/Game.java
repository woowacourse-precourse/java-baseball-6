package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private List<Integer> computer;
    private List<Integer> player;

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");

    }

    public void run() {
        setComputer();
        player = new ArrayList<>();

        getPlayer();
        while (!isAnswer()) {
            getPlayer();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }

    private boolean isAnswer() {
        int strike = 0, ball = 0;
        for (Integer number : player) {
            if (!computer.contains(number)) continue;
            if (computer.indexOf(number) == player.indexOf(number)) strike++;
            else ball++;
        }
        printResult(strike, ball);
        return strike == 3;
    }

    private void printResult(int strike, int ball) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball != 0) System.out.print(ball + "볼 ");
        if (strike != 0) System.out.print(strike + "스트라이크 ");
        System.out.println();
    }

    //사용자로부터 서로 다른 3개의 숫자를 입력받음
    private void getPlayer() {
        String input = Console.readLine();
        isValid(input);
        player = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            player.add(input.charAt(i) - '0');
        }
    }

    private void isValid(String input) {
        if (!input.matches("[0-9]+"))       // 숫자가 아니면
            throw new IllegalArgumentException();
        if (input.length() != 3)                // 숫자 3개가 아니면
            throw new IllegalArgumentException();
    }

    // 임의의 수 3개를 생성
    private void setComputer() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
