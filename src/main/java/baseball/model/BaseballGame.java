package baseball.model;

import baseball.dto.GameResultDto;

public class BaseballGame {
    private final InputNumberValidator validator;
    private final StrikeBallCounter strikeBallCounter;
    private final GameResult gameResult;
    private final GameResultDto gameDto;

    public BaseballGame(GameResultDto gameDto) {
        this.gameDto = gameDto;
        this.validator = new InputNumberValidator(gameDto);
        this.strikeBallCounter = new StrikeBallCounter(gameDto);
        this.gameResult = new GameResult(gameDto);
    }

    public void playGame(String playerInput) { //반복되는 게임 진행 역할
        validator.validateAllInput(playerInput); //gameDto에 검증받은 input값 전달
        //gameDto에서 사용자 입력값과 랜덤넘버 꺼내온 후 카운터 객체에 넣어 카운터해서 카운터 객체에서 strike, ball 각각 gameDto에 저장
        strikeBallCounter.createStrikeBall(gameDto.getValidateInput(), gameDto.getRandomNumber());
        // gameDto에서 strike, ball 꺼내와서 결과 계산. GameResult2 객체에서 gameDto에 게임 결과 메시지와 정답 여부 저장
        gameResult.result(gameDto.getStrike(), gameDto.getBall());
    }

    public void restartGame(String playerRestartInput) {
        gameDto.setValidateInput(validator.validateRestartInput(playerRestartInput));
        if (gameDto.getValidateInput().equals("1")) {
            gameDto.setIsRestart(true);
        }
    }

    public void initGame() {
        RandomNumberGenerator computerNumber = new RandomNumberGenerator();
        gameDto.setIsRestart(false);
        gameDto.setIsCorrectAnswer(false);
        gameDto.setRandomNumber(computerNumber.generateRandomNumber());
    }
}
