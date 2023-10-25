package baseball;

import java.util.List;
import java.util.ArrayList

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    public List<Integer> inputPlayer(){
        List<Integer> playerNumber = new ArrayList<>();

        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        UserNumberValidator.isDuplicated(input);
        UserNumberValidator.isRightDigit(input);
        UserNumberValidator.isNaturalNumber(input);

        for (String i : input.split("")){
            playerNumber.add(Integer.parseInt(i));
        }
    return playerNumber;}

    public Integer  countStrike(List<Integer> playerNumber, List<Integer> answer){
        int count = 0;
        for (int i =0; i<playerNumber.size(); i++){
            if(answer.get(i).equals(playerNumber.get(i))){
                count++;
            }
        }
    return count;}

    public Integer countBall(List<Integer> playerNumber, List<Integer> answer){
        int total_count = 0;
        for (int i=0; i<playerNumber.size(); i++){
            if(answer.contains(playerNumber.get(i))){
                total_count++;
            }
        }

        int noCount = countStrike(playerNumber, answer);
        int count = total_count - noCount;

    return count;}

    public void playGame(){
        boolean flag = true;
        while (true){

        }
    }
}

