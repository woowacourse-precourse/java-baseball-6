package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    public List<Integer> getRandomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 입력받은 숫자 Integer형 리스트로 변환
    public List<Integer> splitInput(String[] strList) {
        List<Integer> result = new ArrayList<>();
        for (String str : strList) {
            result.add(Integer.parseInt(str));
        }
        return result;
    }

    // strike 개수 카운트
    public int checkStrike(List<Integer> answer, List<Integer> input) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(answer.get(i), input.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    // ball 개수 카운트
    public int checkBall(List<Integer> answer, List<Integer> input) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (answer.get(i).equals(input.get(j))) {
                    ball++;
                }
            }
        }
        return ball;
    }

    // 게임 종료 입력
    public int endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    // 입력값 validation
    void checkInput(List<Integer> input) {
        if (input.size() > 3) {
            throw new IllegalArgumentException();
        }
        for (Integer each : input) {
            if (each < 0 || each > 9) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answer = getRandomNum();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputStr = Console.readLine();
            List<Integer> input = splitInput(inputStr.split(""));
            checkInput(input);
            int strike = checkStrike(answer, input);
            if (strike == 3) {
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                int res = endGame();
                if (res == 1) {
                    answer = getRandomNum();
                    continue;
                } else if (res == 2) {
                    break;
                } else {
                    throw new IllegalArgumentException();
                }
            }
            int ball = checkBall(answer, input) - strike;
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else {
                if (ball != 0) {
                    System.out.print(ball + "볼");
                }
                if (ball != 0 && strike != 0) {
                    System.out.print(" ");
                }
                if (strike != 0) {
                    System.out.print(strike + "스트라이크");
                }
                System.out.println();
            }
        }
    }
}
