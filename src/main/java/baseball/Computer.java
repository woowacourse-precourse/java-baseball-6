package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {

    private List<Integer> target;

    private Boolean solved;

    public Computer(List<Integer> target) {
        this.target = target;
        this.solved = false;
    }

    public Computer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.target = computer;
        this.solved = false;
    }

    public List<Integer> getTarget() {
        return target;
    }

    public Boolean getSolved() {
        return solved;
    }

    // 사용자가 컴퓨터의 수를 맞췄을 경우, 상태를 true로 바꿔준다.
    private void makeSolved() {
        this.solved = true;
    }

    // 스트라이크, 볼, 낫싱 판단 후, 판단 결과 리턴
    public String getGuessResult(List<Integer> guess) {
        List<Integer> result = guessNumbers(guess);

        String resultString = "";

        Integer strikeCount = result.get(0);
        Integer ballCount = result.get(1);

        if (strikeCount == 0 && ballCount == 0){
            return "낫싱";
        }

        if (ballCount > 0) {
            resultString = resultString + result.get(1) + "볼 ";
        }

        if (strikeCount > 0) {
            resultString = resultString + result.get(0) + "스트라이크";
        }



        return resultString;

    }

    // 입력받는 리스트와 컴퓨터의 리스트를 비교해서 스트라이크/볼/낫싱 판단
    // [스트라이크 개수, 볼 개수]
    private List<Integer> guessNumbers(List<Integer> guess) {
        System.out.println("guess = " + guess);
        System.out.println("target = " + target);
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (!guess.isEmpty() && !target.isEmpty()) {
                if (guess.get(i).equals(target.get(i))) {
                    strike += 1;
                } else if (target.contains(guess.get(i))) {
                    ball += 1;
                }
            }
        }

        // 3스트라이크일 경우, 정답 처리
        if (strike == 3) {
           makeSolved();
        }

        return new ArrayList<>(Arrays.asList(strike, ball));
    }

    // 게임 재시작 시, target을 변경하는 코드
    public void changeTarget(List<Integer> target) {
        this.target = target;
        this.solved = false;
    }
}
