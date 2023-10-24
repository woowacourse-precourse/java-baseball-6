package baseball.view;

import baseball.model.Computer;
import baseball.model.User;

public class GameService {
    Computer computer = new Computer();
    User user = new User();
    boolean finishFlag = false;

    //사용자 입력 설정
    public void setUserInput() {
        user.setInput();
    }

    //볼 개수 카운트
    public static int countBall(String input, String target) {
        int ball = 0;
        for (int i = 0; i < input.length(); i++) {
            //입력 값의 i번째 자리 값을 타켓이 i번째 자리가 아닌 다른 자리에 포함하고 있는 경우
            if (input.charAt(i) != target.charAt(i) && (target.contains(input.substring(i, i + 1)))) {
                ball += 1;
            }
        }
        return ball;
    }

    //스트라이크 개수 카운트
    public static int countStrike(String input, String target) {
        int strike = 0;
        for (int i = 0; i < input.length(); i++) {
            //i번째 자리 값이 서로 일치하는 경우
            if (input.charAt(i) == target.charAt(i)) {
                strike += 1;
            }
        }
        return strike;
    }

    //비교 결과 계산
    public String compare() {
        String result = "";

        int ball = countBall(user.getInput(), computer.getAnswer());
        int strike = countStrike(user.getInput(), computer.getAnswer());

        //모든 자리를 맞힌 경우
        if (strike == 3) {
            //게임 종료
            finishFlag = true;
        }

        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        if (ball > 0) {
            result += ball + "볼 ";
        }
        if (strike > 0) {
            result += strike + "스트라이크";
        }

        return result;
    }

    public boolean getFinishFlag() {
        return finishFlag;
    }
}
