package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

    public static void main(String[] args) {
        int answer = 135;
        String value;

        List<Integer> computer;
        int value1;
        int ten = 1;
        String contiuneGame = "0";
        // TODO: 프로그램 구현
        while (true) {

            if (Objects.equals(contiuneGame, "2")) {
                break;
            }
            if (Objects.equals(contiuneGame, "1")) {
                answer = 589;
            }

            System.out.println("숫자야구 게임을 시작합니다.");
            computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            ten = 1;
          /*  answer = 0;
            for (int i = 0; i < 3; i++) {
                answer += computer.get(i) * ten;
                ten = ten * 10;

            }
*/
            while (true) {
                System.out.print("숫자를 입력해주세요: ");
                value = Console.readLine();
                value1 = Integer.valueOf(value);
                if (value1 < 100 || value1 > 999) {
                    throw new IllegalArgumentException();
                }
                RoundBaseball round = new RoundBaseball(value1, answer);
                round.playBaseBall();
                if (round.getStrike() == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    contiuneGame = Console.readLine();
                    break;


                }
            }
        }

    }

}

class RoundBaseball {
    private int answer;
    private int value;
    private int strike = 0;
    private int ball = 0;

    RoundBaseball(int value, int answer) {
        this.value = value;
        this.answer = answer;
    }

    public void playBaseBall() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 0) {
                    if (answer / 100 == value / 100) {
                        strike++;
                    }
                }
                if (i == 0 && j == 1) {
                    if (answer / 100 == value / 10 % 10) {
                        ball++;
                    }
                }
                if (i == 0 && j == 2) {
                    if (answer / 100 == value % 10) {
                        ball++;
                    }
                }
                if (i == 1 && j == 0) {
                    if (answer / 10 % 10 == value / 100) {
                        ball++;
                    }
                }
                if (i == 1 && j == 1) {
                    if (answer / 10 % 10 == value / 10 % 10) {
                        strike++;
                    }
                }
                if (i == 1 && j == 2) {
                    if (answer / 10 % 10 == value % 10) {
                        ball++;
                    }
                }
                if (i == 2 && j == 0) {
                    if (answer % 10 == value / 100) {
                        ball++;
                    }
                }
                if (i == 2 && j == 1) {
                    if (answer % 10 == value / 10 % 10) {
                        ball++;
                    }
                }
                if (i == 2 && j == 2) {
                    if (answer % 10 == value % 10) {
                        strike++;
                    }
                }

            }
        }
        if (ball == 0 & strike == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0 & strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0 & strike != 0) {
            System.out.println(strike + "스트라이크");

        }
        if (ball != 0 & strike != 0) {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }
    }

    public int getStrike() {
        return strike;
    }
}
