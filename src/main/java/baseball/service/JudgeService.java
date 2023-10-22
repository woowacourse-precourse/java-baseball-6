package baseball.service;

import baseball.domain.Judge;
import java.util.List;

public class JudgeService {
    private Judge judge;

    public JudgeService() {
        judge = new Judge();
    }

    public void judgeResult(List<Integer> computerNum, List<Integer> userNum) { // 들여쓰기 초과
        for (int num : userNum) {
            if(computerNum.contains(num) && computerNum.indexOf(num) == userNum.indexOf(num)){
                judge.increaseStrike();
            }
            if (computerNum.contains(num) && computerNum.indexOf(num) != userNum.indexOf(num)){
                judge.increaseBall();
            }
        }
    }

    public boolean checkThree() {
        int strike = judge.getStrike();
        if (strike == 3) {
            return true;
        }
        return false;
    }

    public void printResult() {
        int strike = judge.getStrike();
        int ball = judge.getBall();
        if (strike != 0 && ball != 0) { // N 스트라이크, N 볼
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (strike != 0 && ball == 0) { // N 스트라이크, 노 볼
            System.out.println(strike + "스트라이크");
        }
        if (strike == 0 && ball != 0) { // 노 스트라이크, N 볼
            System.out.println(ball + "볼");
        }
        if (strike == 0 && ball == 0) { // 노 스트라이크, 노 볼
            System.out.println("낫싱");
        }
    }

    public void resetResult() {
        judge.reset();
    }

}
