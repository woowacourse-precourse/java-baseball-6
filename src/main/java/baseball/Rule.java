package baseball;

import java.util.ArrayList;

public class Rule {
    private int strikes;
    private int balls;

    private boolean victory;
    public Rule(){
        strikes=0;
        balls=0;
        victory=false;
    }

    public void printGuess(){
        //print result
        StringBuilder sb = new StringBuilder();
        if(balls>0){
            sb.append(balls).append("볼");
            if(strikes>0){
                sb.append(" ").append(strikes).append("스트라이크");
            }
        }
        else if (strikes > 0) {
            sb.append(strikes);
            sb.append("스트라이크");
            if(strikes==3){
                sb.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
        else{
            sb.append("낫싱");
        }
        sb.append("\n");
        System.out.println(sb);
    }

    public boolean judgeGuess(ArrayList<Integer> playerInputNumbers, ArrayList<Integer> correctNumbers){
        strikes=0;
        balls=0;
        victory=false;
        for (int i = 0; i < correctNumbers.size(); i++) {
            int correctNumber = correctNumbers.get(i);
            int playerNumber = playerInputNumbers.get(i);

            if (correctNumber == playerNumber) {
                strikes++;
            } else if (correctNumbers.contains(playerNumber)) {
                balls++;
            }
        }

        if(strikes==3){
            victory=true;
        }
        return victory;
    }
}
