package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class NumbersBaseball {
    private static int[] answer = new int[3];
    private static int[] visited;
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private String startMessage = START_MESSAGE;
    private String finishMessage = FINISH_MESSAGE;

    public String getStartMessage() {
        return startMessage;
    }

    public String getFinishMessage() {
        return finishMessage;
    }

    public void setMessages(String startMessage, String finishMessage) {
        this.startMessage = startMessage;
        this.finishMessage = finishMessage;
    }

    public NumbersBaseball() {
    }

    public void generateAnswer() {
        visited = new int[10];
        int randomNum;
        for (int i = 0; i < 3; i++) {
            randomNum = Randoms.pickNumberInRange(1, 9);
            while (visited[randomNum] == 1) {
                randomNum = Randoms.pickNumberInRange(1, 9);
            }
            visited[randomNum] = 1;
            answer[i] = randomNum;
        }
    }

    public static BaseballInfo getCompareResultWith(int[] input) {
        BaseballInfo baseballInfo = new BaseballInfo(0, 0);
        for (int i = 0; i < 3; i++) {
            if (answer[i] == input[i]) {
                baseballInfo.addStrike();
            }
            if (!(answer[i] == input[i]) && visited[input[i]] == 1) {
                baseballInfo.addBall();
            }
        }
        return baseballInfo;
    }

    public static void validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }
}
