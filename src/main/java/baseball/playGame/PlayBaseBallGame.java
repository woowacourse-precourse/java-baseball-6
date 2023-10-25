package baseball.playGame;

import baseball.player.Attacker;
import baseball.player.Defender;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayBaseBallGame {

    private static boolean treeStrike;
    public static PlayBaseBallGame create(){
        return new PlayBaseBallGame();
    }

    public void runGame(Defender defender, Attacker attacker)  {
        treeStrike =false;
        while (!treeStrike){
            DefenderNumbersInput(attacker);
            printResult(defender,attacker);

        }
    }

    // 숫자 입력
    private void DefenderNumbersInput(Attacker attacker) {
        System.out.print("숫자를 입력해 주세요: ");

        List<Integer> defendNums = new ArrayList<>();

        String balls = readLine();

        System.out.println(balls);
        for(int i=0; i<balls.length(); i++){
            defendNums.add(Integer.parseInt(String.valueOf(balls.charAt(i))));
        }

        attacker.inputDefendNums(defendNums);

    }

    // 입력 따른 결과 출력
    private void printResult(Defender defender, Attacker attacker){

        int strikeCount =0;
        int ballCount = 0;
        for(int i=0; i<defender.getDefendNums().size(); i++){
            if(defender.getDefendNums().get(i) == attacker.getAttackerNums().get(i)){
                strikeCount++;
            }else{
                if(defender.getDefendNums().contains(attacker.getAttackerNums().get(i))){
                    ballCount++;
                }
            }
        }

        if(strikeCount == 3){
            treeStrike = true;
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }else if(strikeCount == 0 && ballCount == 0){
            System.out.println("낫싱");
        }else{
            System.out.println(ballCount + "볼 " + strikeCount +"스트라이크");
        }

    }


}
