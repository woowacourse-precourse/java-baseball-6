package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerGame {
    private String comAnswer;
    private String userAnswer;

    public ComputerGame() {
        comAnswer = computerRandomNum();
        System.out.println(comAnswer);
    }

    public void gameStart() {
        boolean success;
        do {
            UserInput input = new UserInput();
            userAnswer = input.userAnswer;
            success = getHint(userAnswer, comAnswer);
        } while (!success);

    }

    private String computerRandomNum() {
        //중복 없이 3개의 숫자로 구성
        String num = "";
        while (num.length() < 3) {
            String tmp = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!num.contains(tmp)) {
                num += tmp;
            }
        }
        return num;
    }

    private boolean getHint(String userAnswer, String computerAnswer) {
        String result = "";

        int ball = ballCnt(userAnswer, computerAnswer);
        int strike = strikeCnt(userAnswer, computerAnswer);
        ball -= strike;

        if (ball > 0) {
            result += ball + "볼 ";
        }
        if (strike > 0) {
            result += strike + "스트라이크 ";
        }
        if (ball == 0 && strike == 0) {
            result = "낫싱";
        }
        System.out.println(result);

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private int ballCnt(String userAnswer, String comAnswer) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            String cur = String.valueOf(userAnswer.charAt(i));
            if (comAnswer.contains(cur)) {
                cnt++;
            }
        }
        return cnt;
    }

    private int strikeCnt(String userAnswer, String comAnswer) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (comAnswer.indexOf(userAnswer.charAt(i)) == i) {
                cnt++;
            }
        }
        return cnt;
    }

}
