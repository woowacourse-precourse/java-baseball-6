package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallUtils {

    private List<Integer> computer;
    public BallUtils() {}

    public boolean compareBalls(List<Integer> inputs) {
        if(computer.equals(inputs)) {
            return endGame();
        }
        int strikes = 0, ballCnts = 0;
        for(int idx = 0; idx < 3; idx++) {
            if(inputs.get(idx).equals(computer.get(idx))) {
                strikes++;
            } else if(computer.contains(inputs.get(idx))){
                ballCnts++;
            }
        }

        String result = "";
        if(ballCnts > 0) {
            result = ballCnts + "볼";
        }
        if(strikes > 0) {
            result = !result.isEmpty() ? String.join(" ", result, strikes + "스트라이크")
                    : strikes + "스트라이크";
        }
        if(result.isEmpty()) {
            result = "낫싱";
        }
        System.out.println(result);

        return false;
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
        boolean isEnd = false;
        while(!isEnd) {
            isEnd = compareBalls(DisplayBoard.inputNumbers());
        }
    }

    private void startGame() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private boolean endGame() {
        int input = DisplayBoard.inputEnd();
        if(input == 2) {
            return true;
        }
        if(input == 1) {
            startGame();
            return false;
        }
        throw new IllegalArgumentException("1이나 2가 아닌 수가 검증을 통과하였습니다.");
    }
}
