package baseball.activity;

import baseball.object.Referee;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Objects;

public class RefereeActivity {
    public static void StrikeAndBallCount(Referee referee, List<Integer> computer, List<Integer> human) {
        for(int i = 0; i< referee.getCount(); i++){
            if(computer.contains(human.get(i))){
                if(Objects.equals(computer.get(i), human.get(i))){
                    referee.setStrike(referee.getStrike()+1);
                }else
                    referee.setBall(referee.getBall()+1);
            }
        }
    }
    public static void Decision(Referee referee) {
        if(referee.getBall() == 0 && referee.getStrike() == 0 )
            System.out.println("낫싱");
        else{
            if(referee.getStrike() !=0 && referee.getBall() !=0){
                System.out.println(referee.getBall() +"볼 " + referee.getStrike() + "스트라이크");
            }else{
                if(referee.getStrike() ==0)
                    System.out.println(referee.getBall() +"볼");
                else
                    System.out.println(referee.getStrike() + "스트라이크");
            }
        }
    }
    public static Integer ReStartAndExit(Referee referee){
        if(referee.getStrike()== referee.getCount()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String gameStartEndInput;
            gameStartEndInput = Console.readLine();
            if(gameStartEndInput.contentEquals("1")){
                return 1;
            }else if(gameStartEndInput.contentEquals("2")){
                return 2;
            }
        }
        return 3;
    }
}
