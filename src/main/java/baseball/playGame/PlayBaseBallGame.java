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


        }
    }

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
}
