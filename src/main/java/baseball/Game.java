package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private int strike;
    private int ball;

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void run() {
        do {
            play();
        } while (inputRegame());
    }

    private void play() {
        List<Integer> rivalNumber;
        List<Integer> userGuessNumber;
        int strike = 0;

        printStartMessage();
        rivalNumber = makeRivalNumber();
        System.out.println(rivalNumber);

        while (strike != 3) {
            userGuessNumber = inputUserGuess();
            checkScore(rivalNumber, userGuessNumber);
            printResult(getStrike(), getBall());
            strike = getStrike();
        }

        printFinishMessage();
    }

    private void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void printFinishMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private List<Integer> makeRivalNumber() {
        List<Integer> rivalNumber = new ArrayList<>();

        while (rivalNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!rivalNumber.contains(randomNumber)) {
                rivalNumber.add(randomNumber);
            }
        }
        return rivalNumber;
    }

    private List<Integer> inputUserGuess() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        if (input.length() > 3) {
            throw new IllegalArgumentException();
        }
        return toArrayList(input);
    }

    private List<Integer> toArrayList(String input) {
        List<Integer> userGuessNumber = new ArrayList<>();

        for (String number : input.split("")) {
            userGuessNumber.add(Integer.parseInt(number));
        }
        return userGuessNumber;
    }

    private void checkScore(List<Integer> rivalNumber, List<Integer> userGuessNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < rivalNumber.size(); i++) {
            if (rivalNumber.get(i).equals(userGuessNumber.get(i))) {
                strike++;
            } else if (userGuessNumber.contains(rivalNumber.get(i))) {
                ball++;
            }
        }
        setStrike(strike);
        setBall(ball);
    }

    private void printResult(int strike, int ball) {
        if (ball >= 1 && strike >= 1) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball >= 1 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike >= 1) {
            System.out.println(strike + "스트라이크");
        } else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
    }

    private boolean inputRegame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        }
        return false;
    }
}