package baseball;

import java.util.List;

public class JudgeStrike {
    private final List<Integer> computerNumber;
    private final List<Integer> userNumber;

    public JudgeStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        this.computerNumber = computerNumber;
        this.userNumber = userNumber;
    }

    public boolean judge(){
        Judgement judgement;
        int ballCount = 0;
        int strikeCount = 0;

        for (Integer user : userNumber) {
            judgement = isBall(user);

            if(judgement == Judgement.BALL)
                ballCount++;
            else if(judgement == Judgement.STRIKE)
                strikeCount++;
        }

        printJudgeResult(ballCount, strikeCount);

        if (strikeCount == 3)
            return true;

        return false;
    }

    private static void printJudgeResult(int ballCount, int strikeCount) {
        if(ballCount + strikeCount ==0){
            System.out.println("낫싱");
            return;
        }
        String result = makeResult(ballCount, strikeCount);

        System.out.println(result);
    }

    private static String makeResult(int ballCount, int strikeCount) {
        String result = "";
        boolean isBallAndStrike = (ballCount > 0) && (strikeCount > 0);

        if(ballCount > 0)
            result += ballCount +"볼";

        if(isBallAndStrike)
            result += " ";

        if(strikeCount > 0){
            result += strikeCount + "스트라이크";
        }

        return result;
    }

    private Judgement isBall(Integer user) {
        if(computerNumber.contains(user)){
            if(isStrike(user))
                return Judgement.STRIKE;

            return Judgement.BALL;
        }
        return Judgement.NOTHING;
    }

    private boolean isStrike(Integer user) {
        return computerNumber.indexOf(user)== userNumber.indexOf(user);
    }
}
