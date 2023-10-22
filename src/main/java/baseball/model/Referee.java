package baseball.model;

public final class Referee {

    private static String answer = "";

    private Referee() {
    }

    public static void setAnswerToGround(Ground ground) {
        answer = ground.toString();
    }

    public static void setSuccessAnswer() {
        answer = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    }
    public static void setFailAnswer() {
        answer = "낫싱";
    }
    public static String getAnswer() {
        return answer;
    }

}
