package baseball.Judge;

import java.util.ArrayList;

public class Judge {
    private ArrayList<Integer> answer;
    private String input;


    int judgeStrike() {
        char[] charArray = input.toCharArray();
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (answer.get(i).equals(Integer.valueOf(String.valueOf(charArray[i])))) {
                cnt++;

                System.out.println("String.valueOf(charArray[i]) = " + String.valueOf(charArray[i]));
                input = input.replaceFirst(String.valueOf(charArray[i]), "0");
                System.out.println("answer = " + answer);
                System.out.println("input = " + input);
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
