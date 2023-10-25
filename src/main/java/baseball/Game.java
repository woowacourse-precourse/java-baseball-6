package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    public void run() {
        do {
            play();
        } while (inputRegame());
    }

    private void play() {
        List<Integer> rivalNumber;
        List<Integer> userGuessNumber;
        Score score = new Score();
        score.setStrike(0);

        printStartMessage();
        rivalNumber = makeRivalNumber();
        System.out.println(rivalNumber);
        while (score.getStrike() != 3) {
            userGuessNumber = inputUserGuess();
            checkScore(score, rivalNumber, userGuessNumber);
            printResult(score.getStrike(), score.getBall());
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
        isNumber(input);
        isTripleDigit(input);
        hasNoOverlap(input);
        return toArrayList(input);
    }

    private void isNumber(String input) throws IllegalArgumentException {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void isTripleDigit(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void hasNoOverlap(String input) throws IllegalArgumentException {
        Set<Character> uniqueSet = new HashSet<>();

        for (char c : input.toCharArray()) {
            uniqueSet.add(c);
        }
        if (uniqueSet.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> toArrayList(String input) {
        List<Integer> userGuessNumber = new ArrayList<>();

        for (String number : input.split("")) {
            userGuessNumber.add(Integer.parseInt(number));
        }
        return userGuessNumber;
    }

    private void checkScore(Score score, List<Integer> rivalNumber, List<Integer> userGuessNumber) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < rivalNumber.size(); i++) {
            if (rivalNumber.get(i).equals(userGuessNumber.get(i))) {
                strikeCount++;
            } else if (userGuessNumber.contains(rivalNumber.get(i))) {
                ballCount++;
            }
        }
        score.setStrike(strikeCount);
        score.setBall(ballCount);
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
        isValidRegameInput(input);
        return input.equals("1");
    }

    private void isValidRegameInput(String input) throws IllegalArgumentException {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}