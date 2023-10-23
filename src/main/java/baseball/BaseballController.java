package baseball;

import baseball.validator.GameRetryInputValidator;
import baseball.validator.UserAnswerInputValidator;
import camp.nextstep.edu.missionutils.Console;

import static baseball.ConstValue.*;

public class BaseballController {

    private Narrator narrator = new Narrator();
    private BallStrikeCalculator ballStrikeCalculator = new BallStrikeCalculator();
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private UserAnswerInputValidator userAnswerInputValidator = new UserAnswerInputValidator();
    private GameRetryInputValidator gameRetryInputValidator = new GameRetryInputValidator();

    private void playBaseBall(){
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
            if (narrator.isThreeStrike(score)) break;
        }
    }


}
