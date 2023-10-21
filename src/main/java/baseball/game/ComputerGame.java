package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerGame {
    final static int ANSWER_LEN = 3;

    /**
     * 전체 게임 시작
     */
    public void gameStart() {
        String comAnswer = getComputerRandomNumber();

        boolean success;
        do {
            // 사용자에게 입력을 받는다
            UserInput input = new UserInput();
            String userAnswer = input.userAnswer;

            success = getHint(userAnswer, comAnswer);
        } while (!success);

    }

    /**
     * 컴퓨터(상대방) 랜덤 숫자 생성
     */
    private String getComputerRandomNumber() {
        //중복 없이 3개의 숫자로 구성
        String num = "";
        while (num.length() < ANSWER_LEN) {
            String tmp = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!num.contains(tmp)) {
                num = num.concat(tmp);
            }
        }
        return num;
    }

    /**
     * 사용자 입력값에 대한 판단 후 힌트 제공
     */
    private boolean getHint(String userAnswer, String computerAnswer) {
        String result = "";
        int ball = countBall(userAnswer, computerAnswer);
        int strike = countStrike(userAnswer, computerAnswer);

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

        if (strike == ANSWER_LEN) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    /**
     * '볼'에 대한 카운팅
     */
    private int countBall(String userAnswer, String comAnswer) {
        int cnt = 0;
        for (int i = 0; i < ANSWER_LEN; i++) {
            String cur = String.valueOf(userAnswer.charAt(i));
            if (comAnswer.contains(cur)) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * '스트라이크' 에 대한 카운팅
     */
    private int countStrike(String userAnswer, String comAnswer) {
        int cnt = 0;
        for (int i = 0; i < ANSWER_LEN; i++) {
            if (comAnswer.indexOf(userAnswer.charAt(i)) == i) {
                cnt++;
            }
        }
        return cnt;
    }
}