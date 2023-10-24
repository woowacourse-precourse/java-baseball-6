package baseball.domain;

import java.util.List;

public class Grade {
    public int[] getScore(List<Integer> computerNumbers, List<Integer> playerNumbers){
        int strike = 0;
        int ball = 0;
        for(int i=0; i<computerNumbers.size(); i++){
            int computerNumber = computerNumbers.get(i);
            int playerNumber = playerNumbers.get(i);
            if(computerNumber==playerNumber) {
                strike++;
                continue;
            }
            if(playerNumbers.contains(computerNumber)){
                ball++;
            }
        }
        int[] score = new int[]{ball, strike};
        return score;
    }

    public String getResult(int[] result){
        StringBuilder stringBuilder = new StringBuilder();
        if(result[0]>0) stringBuilder.append(result[0]+"볼 ");
        if(result[1]>0) stringBuilder.append(result[1]+"스트라이크");
        if(result[0]==0 && result[1]==0) stringBuilder.append("낫싱");
        return stringBuilder.toString();
    }
}
