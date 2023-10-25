package baseball.Game;

import baseball.Player.Batter;
import baseball.Player.Pitcher;

import java.util.List;

public class Game {

    private static final String START_GAME_GUIDE = "숫자 야구 게임을 시작합니다.";
    private static final String PROCEED_UNIT_GUIDE = "숫자를 입력해주세요 : ";
    private static final String END_UNIT_GUIDE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private Boolean GAME_STATUS = true;

    private Boolean UNIT_STATUS = true;
    private Pitcher pitcher;
    private Batter batter;

    public void doGame(){
        startGame();
        while(GAME_STATUS){
            startUnit();
            proceedUnit();
            endUnit();
        }
    }

    public void startGame(){
        System.out.println(START_GAME_GUIDE);
    }
    public void startUnit(){
        pitcher = new Pitcher();
        batter = new Batter();

        pitcher.makeChoice();
    }

    public void proceedUnit(){
        UNIT_STATUS = true;
        while(UNIT_STATUS){
            System.out.print(PROCEED_UNIT_GUIDE);
            batter.makeChoice();
            List<Integer> unitResult = compareChoices(batter.getChoice(),pitcher.getChoice());
            giveHint(unitResult);
        }
    }

    public void endUnit(){
        System.out.print(END_UNIT_GUIDE);
        if(!batter.decideToPlayMore()) {
            GAME_STATUS = false;
        }
    }

    public List<Integer> compareChoices(List<Integer> batterChoice, List<Integer> pitcherChoice){
        Integer balls = 0;
        Integer strikes = 0;

        for(int i = 0; i < 3; i++){
            Integer batting = batterChoice.get(i);
            if (pitcherChoice.contains(batting)){
                if (batting.equals(pitcherChoice.get(i))){
                    strikes++;
                    continue;
                }
                balls++;
            }
        }

        List<Integer> result = List.of(balls,strikes);
        return result;
    }

    public void giveHint(List<Integer> result){
        Integer balls = result.get(0);
        Integer strikes = result.get(1);
        //unit 종료조건
        if (strikes==3) UNIT_STATUS = false;

        String statement = "";
        if (balls != 0) statement += balls+"볼 ";
        if (strikes != 0) statement += strikes+"스트라이크 ";
        if (strikes == 0 && balls == 0) statement = "낫싱";

        System.out.println(statement);
    }

}
