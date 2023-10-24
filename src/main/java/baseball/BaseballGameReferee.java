package baseball;

import java.util.List;
import java.util.regex.Pattern;

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

    public boolean validateBaseballGameNumber (String input) {
        if(!validateFormat(input) || !validateDuplication(input)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean validateFormat (String input) {
        return Pattern.matches("^[1-9]{3}",input);
    }

    private boolean validateDuplication (String input) {
        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            for (int j = 0; j < 3; j++) {
                if(i != j && c == input.charAt(j)) return false;
            }
        }
        return true;
    }

}
