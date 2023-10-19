package baseball.utils;

import baseball.Model.NumberList;

import java.util.List;

public class Transfer {
    public static NumberList stringToNumberList(String answerString) {
        NumberList answer = new NumberList();
        for(int i=0; i<answerString.length(); i++) {
            int number = answerString.charAt(i) - '0';
            answer.putNumber(number);
        }
        return answer;
    }
}
