package baseball;

import java.util.List;

public class Judge {

    List<Integer> computer;
    private int strikeCount = 0;
    private int ballCount = 0;

    public Judge(List<Integer> _computer) {
        this.computer = _computer;
    }

    private void check(int inputNumber, int inputPos) {
        // inputOrder: 각 숫자의 위치
        if (computer.get(inputPos) == inputNumber) {
            strikeCount++;
            return;
        }
        if (computer.contains(inputNumber)) {
            ballCount++;
        }
    }

    private boolean announce() {
        // 낫싱
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return false;
        }

        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        System.out.println();

        // 정답
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public boolean makeJudgement(String inputString) {
        strikeCount = 0;
        ballCount = 0;
        check(Character.getNumericValue(inputString.charAt(0)), 0);
        check(Character.getNumericValue(inputString.charAt(1)), 1);
        check(Character.getNumericValue(inputString.charAt(2)), 2);
        return announce();
    }
}
