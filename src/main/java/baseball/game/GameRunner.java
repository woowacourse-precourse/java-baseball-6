package baseball.game;

import baseball.game.validator.GameLogic;
import baseball.game.validator.ValueValidator;

import java.util.List;

public class GameRunner {
    // 검증기와 랜덤 생성기는 게임이 바뀌어도 계속 사용하기에 싱글톤으로 사용
    private final ValueValidator validator = new ValueValidator();
    private final InitRandomNum initRandomNum = new InitRandomNum();
    private final GameLogic gameLogic = new GameLogic();
    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game();
        // 일단 한판 하고 recheck 통해 다시 수행
        do {
            List<Integer> pick = initRandomNum.pick();
            System.out.println(pick);
            game.gameSet(validator,gameLogic,initRandomNum);
            game.play();
            game.reset();
        } while (game.recheck());
    }
}
