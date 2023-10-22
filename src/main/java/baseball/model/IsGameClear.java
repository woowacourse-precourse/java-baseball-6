package baseball.model;

public class IsGameClear {

    // userNumberGrader에서 계산된 ball과 strike를 갖고 오기
    private UserNumberGrader userNumberGrader;

    public IsGameClear(UserNumberGrader userNumberGrader) {
        this.userNumberGrader = userNumberGrader;
    }

    // 게임 통과 여부 boolean 메소드
    public boolean getResultGrade(String userNumber, String answer) {
        int[] ballStrike = userNumberGrader.grader(userNumber, answer);
        if (ballStrike[1] == 3) {
            return true;
        }
        return false;
    }
}
