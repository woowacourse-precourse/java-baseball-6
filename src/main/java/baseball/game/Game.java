package baseball.game;

import baseball.Input;
import baseball.Output;
import baseball.Utils;
import baseball.game.validator.GameLogic;
import baseball.game.validator.GameResult;
import baseball.game.validator.ValueValidator;

import java.util.List;

public class Game {
    private ValueValidator validator;
    private List<Integer> answer;
    private GameLogic gameLogic;
    private InitRandomNum initRandomNum;
    private final Input input;
    private final Output output;
    private final Utils utils;

    public Game() {
        this.input = new Input();
        this.output = new Output();
        this.utils = new Utils();
    }

    public void gameSet(ValueValidator validator, GameLogic gameLogic, InitRandomNum initRandomNum) {
        this.validator = validator;
        this.gameLogic = gameLogic;
        this.initRandomNum = initRandomNum;
        this.answer = initRandomNum.pick();
    }
    public void play() {
        while (true){
            // 입력받고
            String userInput = input.input();

            // 유효값 검증
            if (validator.valid(userInput)) {
                List<Integer> playerList = utils.toList(userInput);
                GameResult gameResult = gameLogic.logic(playerList, answer);
                output.result(gameResult);
                if (winCheck(gameResult)) {
                    output.success();
                    return;
                }
            }
        }
    }

    public boolean recheck() {
        String replayInput = input.replayInput();
        if (validator.reValid(replayInput)) {
            // 숫자로 변환 후에 리플레이 할건지 확인
            int number = Integer.parseInt(replayInput);

            if (number == 1) {
                return true;
            } else return number != 2;
        } else{
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public boolean winCheck(GameResult gameResult){
        return gameResult.getStrike() == 3 && gameResult.getBall() == 0;
    }

    public void reset() {
        initRandomNum.reset();
    }
}
