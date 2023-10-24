package baseball;

import static baseball.ConstValue.PLAY_CONTINUE;

import baseball.validator.GameRetryInputValidator;
import baseball.validator.UserAnswerInputValidator;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

    private Narrator narrator = new Narrator();
    private BallStrikeCalculator ballStrikeCalculator = new BallStrikeCalculator();
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private UserAnswerInputValidator userAnswerInputValidator = new UserAnswerInputValidator();
    private GameRetryInputValidator gameRetryInputValidator = new GameRetryInputValidator();

    // 게임 시작
    public void runGame() {
        // 시작 멘트
        narrator.startGame();
        // 게임시작 플래그
        String gamePlayFlag = PLAY_CONTINUE;
        while (gamePlayFlag.equals(PLAY_CONTINUE)) {
            // 숫자야구 플레이
            playBaseBall();

            // 재시작 멘트
            narrator.retryGame();
            gamePlayFlag = Console.readLine().trim();

            // 유저가 올바른 재시작 값을 넣었나 체크
            gameRetryInputValidator.validateInput(gamePlayFlag);
        }
    }

    private void playBaseBall() {
        //서로 다른 3자리의 수 생성(답)
        int[] computerAnswer = randomNumberGenerator.makeComputerAnswer();

        while (true) {
            // 숫자 입력 멘트
            narrator.inputUserValue();

            // 유저가 입력한 값
            String userInput = Console.readLine().trim();

            // 유저가 올바른 값을 넣었나 체크
            userAnswerInputValidator.validateInput(userInput);

            // int배열로 변경
            int[] userAnswer = userInput.chars().map(Character::getNumericValue).toArray();

            // 유저가 입력한 값과 컴퓨터의 값을 비교하여 strike와 ball 판정
            Score score = ballStrikeCalculator.countStrikeAndBallToScore(userAnswer, computerAnswer);

            // 정답을 맞출경우 stop
            if (narrator.isThreeStrike(score)) {
                break;
            }
        }
    }


}
