package baseball.model;

import java.util.List;

public class Model {
    public Count getResult(String stringOfNum, List<Integer> randomList) {
        int strike=0, ball=0;

        for (int i=0 ; i<stringOfNum.length() ; i++){
            int currentInt = stringOfNum.charAt(i)-'0';

            if(randomList.contains(currentInt)){
                if(randomList.get(i)==currentInt)
                    strike++;
                else
                    ball++;
            }
        }

        Count count = new Count(strike, ball);

        return count;
    }

    public boolean isCorrect(Count count) {
        int strike = count.getStrike();

        if(strike == 3) {
            return true;
        }

        return false;
    }

    public boolean isFinish(String finishInput) {
        if(finishInput.equals("1")) {
            return false;
        }
        return true;
    }
}
