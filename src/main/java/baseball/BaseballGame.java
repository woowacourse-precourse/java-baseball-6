package baseball;

import static baseball.Constant.NUMBER_LENGTH;
import static baseball.Constant.TARGET_STRIKE;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private boolean isGameRunning;
    private List<Integer> answer;
    private List<Integer> player;
    private Integer ball;
    private Integer strike;

    public BaseballGame() {
        isGameRunning = true;
    }

    // 난수를 뽑고, isGameRunning의 상태에 따라 게임을 구동
    public void start() {
        answer = pickRandomNumber();

        while (isGameRunning) {
            player = inputNumber();
            judge(answer, player);
            end();
        }
    }

    // 1~9까지 중복되지 않는 난수 n개를 생성
    private List<Integer> pickRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private List<Integer> inputNumber() {
        List<Integer> numbers = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String numberString = Console.readLine();

        if (numberString.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("숫자는 " + NUMBER_LENGTH + "자리여야 합니다.");
        }

        for (int i = 0; i < numberString.length(); i++) {
            char c = numberString.charAt(i);
            numbers.add(Character.getNumericValue(c));
        }

        return numbers;
    }

    private void judge(List<Integer> computer, List<Integer> player) {
        strike = 0;
        ball = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                strike++;
            } else if (player.contains(computer.get(i))) {
                ball++;
            }
        }

        printJudge();
    }

    private void end() {
        if (strike == TARGET_STRIKE) {
            System.out.println(NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            inputEnd();
        }
    }

    private void inputEnd() {
        String endString;

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            endString = Console.readLine();

            if (endString.equals("1")) {
                answer = pickRandomNumber();
                break;
            } else if (endString.equals("2")) {
                isGameRunning = false;
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    private void printJudge() {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ballToString() + strikeToString());
        }
    }

    private String ballToString() {
        if (ball == 0) {
            return "";
        } else {
            return ball.toString() + "볼 ";
        }
    }

    private String strikeToString() {
        if (strike == 0) {
            return "";
        } else {
            return strike.toString() + "스트라이크";
        }
    }
}
