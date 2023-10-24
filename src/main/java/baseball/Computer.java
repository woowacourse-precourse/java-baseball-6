package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers;
    private int ball;
    private int strike;

    public Computer() {
        this.numbers = new ArrayList<>();
        this.ball = 0;
        this.strike = 0;
    }

    public void setNewNumbers() {
        clearNumbers();
        while (this.numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.numbers.contains(randomNumber)) {
                this.numbers.add(randomNumber);
            }
        }
    }

    public boolean getResult(List<Integer> playerNumbers) {
        clearScore();
        checkNumbers(playerNumbers);
        printResult();
        return isEnd();
    }

    private void checkNumbers(List<Integer> playerNumbers) {
        for (int i=0;i<3;i++) {
            int playerNumber = playerNumbers.get(i);
            if (playerNumber==this.numbers.get(i)) {
                this.strike += 1;
            } else if (this.numbers.contains(playerNumber)) {
                this.ball += 1;
            }
        }
    }

    private void printResult() {
        StringBuilder builder = new StringBuilder();
        if (this.ball>0) {
            builder.append(this.ball).append("볼");
        }
        if (this.strike>0) {
            if (this.ball>0) {
                builder.append(" ");
            }
            builder.append(this.strike).append("스트라이크");
        }
        if (this.strike+this.ball==0) {
            builder.append("낫싱");
        }
        System.out.println(builder);
    }

    private boolean isEnd() {
        if (this.strike==3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private void clearScore() {
        this.ball = 0;
        this.strike = 0;
    }

    private void clearNumbers() {
        this.numbers = new ArrayList<>();
        clearScore();
    }

}
