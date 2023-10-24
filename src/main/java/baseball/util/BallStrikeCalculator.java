package baseball.util;

import java.util.ArrayList;

public class BallStrikeCalculator {
    public String calculateAnswer(String inputNumber, String answerNumber){
        String answer = "";

        int ball = 0;
        int strike = 0;

        ArrayList<Character> answerNumberList = new ArrayList<>();
        for (char c : answerNumber.toCharArray()){
                answerNumberList.add(c);
        }

        for (int i = 0 ; i < 3 ; i++){
            char c = inputNumber.charAt(i);

            if(answerNumberList.contains(c)){
                    ball++;
            }
        }

        for (int i = 0 ; i < 3 ; i++){
            char c = inputNumber.charAt(i);

            if(answerNumberList.get(i) == c){
                    ball--;
                    strike++;
            }
        }

        answer = makeAnswerMassage(ball,strike);
        return answer;

    }

    private String makeAnswerMassage(int ball, int strike) {
        String answer = "";

        // 볼, 스트라이크가 하나도 없는 경우
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        // 볼, 스트라이크 개수로 메시지 문자열 생성
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball + "볼");
        }
        if (strike != 0) {
            sb.append(" " + strike + "스트라이크");
        }

        answer = sb.toString().trim();
        return answer;
    }
}
