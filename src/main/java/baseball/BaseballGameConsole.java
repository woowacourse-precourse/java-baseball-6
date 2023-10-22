package baseball;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGameConsole {
    static final int MIN = 1;
    static final int MAX = 9;
    static final int SIZE = 3;
    static final int START_NUM = 1;
    static final int END_NUM = 2;
    private boolean isContinue;
    private List<Integer> hitterSelection;
    private String pitcherSelection;
    private BallCount ballCount;
    private boolean strikeOut;

    void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        isContinue = true;

        while (isContinue) {
            play();
            checkContinue();
        }
    }

    private void play() {
        strikeOut = false;
        getHitterSelection();

        while (!strikeOut) {
            getPitcherSelection();
            getBallCount();
            printBallCount();
            checkStrikeOut();
        }
    }

    private void getPitcherSelection() {
        System.out.print("숫자를 입력해주세요 : ");
        pitcherSelection = Console.readLine();

        checkValidPitcherSelection();
    }

    private void checkValidPitcherSelection() {
        String regex = String.format("^[%d-%d]{%d}$", MIN, MAX, SIZE);
        boolean isValid = pitcherSelection.matches(regex) && !isDuplicated();

        if (!isValid) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated() {
        Set<Character> set = new HashSet<>();

        for (char c : pitcherSelection.toCharArray()) {
            if (!set.add(c)) {
                return true;
            }
        }
        return false;
    }

    private void getHitterSelection() {
        hitterSelection = new ArrayList<>();

        while (hitterSelection.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!hitterSelection.contains(randomNumber)) {
                hitterSelection.add(randomNumber);
            }
        }
    }

    private void getBallCount() {
        ballCount = new BallCount();

        for (int i = 0; i < pitcherSelection.length(); i++) {
            char numChar = pitcherSelection.charAt(i);
            int num = Character.getNumericValue(numChar);

            if (num == hitterSelection.get(i)) {
                ballCount.addStrike();
            } else if (hitterSelection.contains(num)) {
                ballCount.addBall();
            }
        }
    }

    private void printBallCount() {
        if (ballCount.getStrike() == 0 && ballCount.getBall() == 0) {
            System.out.println("낫싱");
        } else {
            String message = "";
            if (ballCount.getBall() > 0) {
                message = ballCount.getBall() + "볼";
            }
            if (ballCount.getStrike() > 0) {
                message += (message.isEmpty() ? "" : " ") + ballCount.getStrike() + "스트라이크";
            }
            System.out.println(message);
        }
    }

    private void checkStrikeOut() {
        if (ballCount.getStrike() == SIZE) {
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", SIZE);
            strikeOut = true;
        }
    }

    private void checkContinue() {
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n", START_NUM, END_NUM);
        String continueAnswer = Console.readLine();
        String regex = String.format("^[%d-%d]$", START_NUM, END_NUM);

        if (!continueAnswer.matches(regex)) {
            throw new IllegalArgumentException();
        }

        if (Integer.toString(END_NUM).equals(continueAnswer)) {
            isContinue = false;
        }
    }
}
