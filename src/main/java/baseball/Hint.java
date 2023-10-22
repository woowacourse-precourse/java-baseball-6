package baseball;

import java.util.List;


public class Hint {
    private List<Integer> computer;
    private String[] inputArr;

    public Hint(List<Integer> computer, String input) {
        this.computer = computer;
        this.inputArr = input.split("");
    }

    public boolean checkNumber() {
        StringBuilder sb = new StringBuilder();
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < computer.size(); i++) {
            int num = Integer.parseInt(inputArr[i]);
            if (computer.get(i) == num) {
                strike += 1;
            } else if (computer.contains(num)) {
                ball += 1;
            }
        }
        if (strike == 3) {
            System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (strike + ball == 0) {
            sb.append("유효");
        } else if (strike == 0) {
            sb.append(ball).append("볼");
        } else if (ball == 0) {
            sb.append(strike).append("스트라이크");
        } else {
            sb.append(ball).append("볼").append(" ").append(strike).append("스트라이크");
        }
        System.out.println(sb);
        return false;
    }
}
