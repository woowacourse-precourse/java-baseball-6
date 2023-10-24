package baseball.model;

public class IsGameClear {

    private UserNumberGrader userNumberGrader;

    public IsGameClear(UserNumberGrader userNumberGrader) {
        this.userNumberGrader = userNumberGrader;
    }

    public boolean getResultGrade(String userNumber, String answer) {
        int[] ballStrike = userNumberGrader.grader(userNumber, answer);
        if (ballStrike[1] == 3) {
            return true;
        }
        return false;
    }
}
