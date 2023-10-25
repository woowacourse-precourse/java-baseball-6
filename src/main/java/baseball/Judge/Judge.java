package baseball.Judge;

import java.util.ArrayList;

public class Judge {
    private ArrayList<Integer> answer;
    private String input;


    int judgeStrike() {
        char[] charArray = input.toCharArray();
        int cnt = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (answer.get(i).equals(Integer.valueOf(String.valueOf(charArray[i])))) {
                cnt++;
            }
        }
        return cnt;
    }

    int judgeBall() {
        char[] charArray = input.toCharArray();
        int cnt = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (answer.contains(Integer.valueOf(String.valueOf(charArray[i])))) {
                cnt++;
            }
        }
        return cnt;
    }

    public void setAnswer(ArrayList<Integer> answer) {
        this.answer = answer;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
