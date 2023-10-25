package baseball;

import java.util.List;
import java.util.ArrayList;

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

    return total_count - noCount;}

    public void playGame(){
        boolean flag = true;
        List<Integer> computer_number = RandomNumberGenerator.getRandomNumber();
        while (flag){
            List<Integer> player_number = inputPlayer();

            int numStrike = countStrike(player_number, computer_number);
            int numBall = countBall(player_number, computer_number);

            if (numStrike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다!");
                System.out.println("게임 종료");
                flag = false;}
            else if (numStrike + numBall == 0) {
                System.out.println("낫싱");
            }
            else if (numStrike== 0){
                System.out.println(numBall+"볼");
        }
            else if (numBall == 0) {
                System.out.println(numStrike+"스트라이크");
            }
            else if (numStrike != 0 & numBall != 0) {
                System.out.println(numBall+"볼 "+numStrike+"스트라이크");
            }
        }
    }
    public boolean retry(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        char label = Console.readLine().charAt(0);
        if(label == '1') return true;
        return false;
    }
}
