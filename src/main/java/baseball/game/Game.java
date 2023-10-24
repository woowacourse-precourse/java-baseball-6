package baseball.game;

import baseball.core.GameLogic;
import baseball.core.InitRandomNum;
import baseball.game.io.Input;
import baseball.game.io.Output;
import baseball.utils.NumberParser;
import baseball.core.validator.ValueValidator;

import java.util.List;

public class Game {
    private ValueValidator validator;
    private List<Integer> answer;
    private GameLogic gameLogic;
    private InitRandomNum initRandomNum;
    private final Input input;
    private final Output output;
    private final NumberParser numberParser;

    public Game(final Input input, final Output output, final NumberParser numberParser) {
        this.input = input;
        this.output = output;
        this.numberParser = numberParser;
    }

    public void gameSet(ValueValidator validator, GameLogic gameLogic, InitRandomNum initRandomNum) {
        this.validator = validator;
        this.gameLogic = gameLogic;
        this.initRandomNum = initRandomNum;
    }
    public void play() {
        answer = initRandomNum.createRandomValue();
        while (true){
            // 입력받고
            String userInput = input.input();
            // 유효값 검증
            if (validator.valid(userInput)) {
                // 리스트로 바꾸고
                List<Integer> playerList = numberParser.toList(userInput);
                // 스트라이크 볼 비교
                GameResult gameResult = gameLogic.logic(playerList, answer);
                // 비교 값 출력
                output.result(gameResult);
                // 만약에 이겼으면 승리 출력하고 끝
                if (winCheck(gameResult)) {
                    output.success();
                    return;
                }
            }
        }
    }
    // 해당 게임에서 다시 할건지 물어보는게 맞는 것 같다.
    public boolean recheck() {
        String replayInput = input.replayInput();
        if (validator.reValid(replayInput)) {
            // 숫자로 변환 후에 리플레이 할건지 확인
            int number = Integer.parseInt(replayInput);
            return number == 1;
        } else{
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
    public boolean winCheck(GameResult gameResult){
        return gameResult.getStrike() == 3 && gameResult.getBall() == 0;
    }
}
