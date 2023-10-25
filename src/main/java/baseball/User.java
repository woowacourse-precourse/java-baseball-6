package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    public String answer() {
        String answer = Console.readLine();

        String answerRegex = "[1-9]{3}";
        Pattern pattern = Pattern.compile(answerRegex);
        Matcher matcher = pattern.matcher(answer);

        if (matcher.matches() && difEach(answer)) {
            return answer;
        } else {
            throw new IllegalArgumentException("잘못된 값 : " + answer);
        }
    }

    private boolean difEach(String answer) {
        char[] answerArray = answer.toCharArray();
        return answerArray[0] != answerArray[1]
                && answerArray[1] != answerArray[2]
                && answerArray[0] != answerArray[2];
    }

    public boolean restartGame() {
        String answer = Console.readLine();

        String answerRegex = "^(1|2)$";
        Pattern pattern = Pattern.compile(answerRegex);
        Matcher matcher = pattern.matcher(answer);

        if (matcher.matches()) {
            return answer.equals("1");
        } else {
            throw new IllegalArgumentException("잘못된 값 : " + answer);
        }
    }
}
