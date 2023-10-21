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
    private int[] ballCount;
    private boolean strikeOut;

    void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.isContinue = true;

        while (this.isContinue) {
            play();
            checkContinue();
        }
    }

    private void play() {
        this.strikeOut = false;
        getHitterSelection();

        while (!this.strikeOut) {
            getPitcherSelection();
            getBallCount();
            printBallCount();
            checkStrikeOut();
        }
    }

    private void getPitcherSelection() {
        System.out.print("숫자를 입력해주세요 : ");
        this.pitcherSelection = Console.readLine();

        checkValidPitcherSelection();
    }

    private void checkValidPitcherSelection() {
        String regex = String.format("^[%d-%d]{%d}$", MIN, MAX, SIZE);
        boolean isValid = this.pitcherSelection.matches(regex) && !isDuplicated();

        if (!isValid) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated() {
        Set<Character> set = new HashSet<>();

        for (char c : this.pitcherSelection.toCharArray()) {
            if (!set.add(c)) {
                return true;
            }
        }
        return false;
    }

    private void getHitterSelection() {
        this.hitterSelection = new ArrayList<>();

        while (this.hitterSelection.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!this.hitterSelection.contains(randomNumber)) {
                this.hitterSelection.add(randomNumber);
            }
        }
    }

    private void getBallCount() {
        this.ballCount = new int[2]; // [0] : strike, [1] : ball

        for (int i = 0; i < this.pitcherSelection.length(); i++) {
            char numChar = this.pitcherSelection.charAt(i);
            int num = Character.getNumericValue(numChar);
            if (num == this.hitterSelection.get(i)) {
                this.ballCount[0]++;
            } else if (this.hitterSelection.contains(num)) {
                this.ballCount[1]++;
            }
        }
    }

    private void printBallCount() {
        if (this.ballCount[0] == 0 && this.ballCount[1] == 0) {
            System.out.println("낫싱");
        } else {
            String message = "";
            if (this.ballCount[1] > 0) {
                message = this.ballCount[1] + "볼";
            }
            if (this.ballCount[0] > 0) {
                message += (message.isEmpty() ? "" : " ") + this.ballCount[0] + "스트라이크";
            }
            System.out.println(message);
        }
    }

    private void checkStrikeOut() {
        if (this.ballCount[0] == SIZE) {
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", SIZE);
            this.strikeOut = true;
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
            this.isContinue = false;
        }
    }
}
