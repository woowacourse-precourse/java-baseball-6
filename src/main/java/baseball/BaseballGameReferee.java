package baseball;

import java.util.List;

public class BaseballGameReferee {

    private BaseballGameNumber answer = new BaseballGameNumber();

    public void refreshAnswer() {
        answer = new BaseballGameNumber();
    }

    public BaseballGameJudgement judgement(BaseballGameNumber input) {
        BaseballGameJudgement judgement = new BaseballGameJudgement();
        List<Integer> answerNumbers = answer.getNumbers();
        List<Integer> inputNumbers = input.getNumbers();

        for (int i = 0; i < 3; i++) {
            int now = answerNumbers.get(i);
            matchNumbers(judgement,inputNumbers,now,i);
        }

        return judgement;
    }

    private void matchNumbers (BaseballGameJudgement judgement, List<Integer> inputNumbers, int now, int nowIndex) {
        for (int i = 0; i < 3; i++) {
            if(now == inputNumbers.get(i)) {
               if(nowIndex == i) {
                   judgement.addStrike();
                   continue;
               }
               judgement.addBall();
            }
        }
    }

}
