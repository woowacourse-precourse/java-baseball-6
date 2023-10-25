package baseball.Judge;

import java.util.ArrayList;

public class Judge {
    private ArrayList<Integer> answer;
    private String input;


    public int judgeStrike() {
        char[] charArray = input.toCharArray();
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (answer.get(i).equals(Integer.valueOf(String.valueOf(charArray[i])))) {
                cnt++;
                input = input.replaceFirst(String.valueOf(charArray[i]), "0");
            }
        }
        return cnt;
    }

    public int judgeBall() {
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
