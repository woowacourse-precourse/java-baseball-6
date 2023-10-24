package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        System.out.println("숫자 야구 게임을 시작합니다.");
        baseballGame.run();
    }
}

class BaseballGame {
    private List<Integer> computer = new ArrayList<>(3);
    private List<Integer> player = new ArrayList<>(3);
    private int status = 1;

    private void setComputer() {
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public BaseballGame() {
        setComputer();
    }

    private void setPlayer() {
        player.clear();
        System.out.print("숫자를 입력해주세요: ");
        String choiceNumber = Console.readLine();

        if (choiceNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char c : choiceNumber.toCharArray()) {
            int numericValue = Character.getNumericValue(c);

            if (numericValue < 1 || numericValue > 9 || player.contains(numericValue)) {
                throw new IllegalArgumentException();
            }
            player.add(numericValue);
        }
    }

    public void run() {
        while (status != 2) {
            int strike = 0;
            int ball = 0;
            int nothing = 0;
            setPlayer();
            if (status == 2) break;

            for (int i = 0; i < 3; i++) {
                if (!computer.contains(player.get(i))) {
                    nothing++;
                } else if (computer.indexOf(player.get(i)) == i) {
                    strike++;
                } else {
                    ball++;
                }
            }

            displayResult(strike, ball, nothing);
        }
    }

    private void displayResult(int strike, int ball, int nothing) {
        if (nothing == 3) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞혔습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            status = Integer.parseInt(Console.readLine());
            if (status == 1) setComputer();
        } else {
            if (ball != 0) System.out.printf("%d볼 ", ball);
            if (strike != 0) System.out.printf("%d스트라이크", strike);
            System.out.println();
        }
    }
}
