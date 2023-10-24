package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    // 1부터 9까지 서로 다른 수로 이루어진 3자리의 숫자를 맞추기
    // 같은 수 같은 자리 -> 스트라이크, 다른 자리 -> 볼
    // 같은 수 전혀 없으면 낫싱이란 힌트 얻음, 힌트로 상대방의 수 맞추면 승리
    // 사용자가 잘못된 값을 입력 하면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
    // 게임이 끝난 후 재시작/종료를 구분하는 1과 2중 하나의 수
    public static void main(String[] args) {
        //게임 시작 알리고 랜덤 숫자 생성(no.1)
        System.out.print("숫자 야구 게임을 시작합니다.");
        Baseball game = new Baseball();
        Baseball.init(game);
    }
}

class Baseball {
    static final int LIMIT_DIGIT = 3;

    static final String NEW_GAME = "1";
    static final String END_GAME = "2";

    private static final String NUM_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_CHECK_MESSAGE= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    Baseball() {
        String randomNum;

        while (num.length() < LIMIT_DIGIT) {
            randomNum = Integer.toString(pickNumberInRange(1, 9));
            if (!num.contains(randomNum)) {
                num += randomNum;
            }
        }
    }

    Baseball(String str) {
        num = str;
    }

    public static void init(Baseball answer) {
        //사용자 값 입력 받기(no.2)
        String input = Baseball.getUserInput();

        //사용자 값의 유효성 판단(no.3, no.4)
        Baseball userAns = Baseball.checkAnsValid(input);

        //사용자 입력 값과 정답 비교(no.5)
        Score score = new Score();
        score.compareAnswer(answer, userAns);

        //사용자의 점수(결과) 출력(no.6)
        score.getScore();

        //사용자가 정답을 맞추지 못했으면 no.2로 돌아가 다시 값 입력을 받기(no.7)
        if (score.strike != LIMIT_DIGIT) {
            Baseball.init(answer);
            return;
        }

        //사용자가 정답을 맞춘 경우, 정답을 맞췄음을 알리고, 새로운 게임 시작 여부에 대해 입력 받기(no.8)
        String restartNum = Baseball.checkRestart();
        if (restartNum.equals(Baseball.NEW_GAME)) {
            answer = new Baseball();
            Baseball.init(answer);
        }
    }

    private static String getUserInput() {
        System.out.print(NUM_INPUT_MESSAGE);
        String userVal = readLine();

        return userVal;
    }

    private static Baseball checkAnsValid(final String input) {
        if (input.length() != LIMIT_DIGIT) {
            throw new IllegalArgumentException();
        }
        if (!isValidNumber(input)) {
            throw new IllegalArgumentException();
        }
        if (!isEachNumDiff(input)) {
            throw new IllegalArgumentException();
        }

        return new Baseball(input);
    }

    static boolean isValidNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return !str.contains("0");
    }

    static boolean isEachNumDiff(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String checkRestart() {
        System.out.print(SUCCESS_MESSAGE);
        System.out.print(RESTART_CHECK_MESSAGE);

        String checkRestart = readLine();
        return checkValidRestartNum(checkRestart);
    }

    private static String checkValidRestartNum(String str) {
        if (!str.equals(NEW_GAME) && !str.equals(END_GAME)) {
            throw new IllegalArgumentException();
        }

        return str;
    }
}

class Score {
    int ball, strike;

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    void compareAnswer(Baseball answer, Baseball userInput) {
        char currentNum;

        for (int i = 0; i < Baseball.LIMIT_DIGIT; i++) {
            currentNum = answer.num.charAt(i);

            if (!userInput.num.contains(currentNum + "")) {
                continue;
            }
            if (i == userInput.num.indexOf(currentNum)) {
                this.strike++;
                continue;
            }
            this.ball++;
        }
    }

    void getScore() {
        String score = "";
        if (this.ball != 0) {
            score += this.ball + BALL;
        }
        if (this.strike != 0) {
            if (this.ball != 0) {
                score += " ";
            }
            score += this.strike + STRIKE;
        }

        if (score.equals("")) {
            score = NOTHING;
        }

        System.out.println(score);
    }
}