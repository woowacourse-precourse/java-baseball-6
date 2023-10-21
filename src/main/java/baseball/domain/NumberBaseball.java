package baseball.domain;

import baseball.domain.constants.NumberBaseballConstants;
import baseball.utils.RandomUtils;

import java.util.List;

public class NumberBaseball {
    private final int numberLimit;
    private final NumberBaseballIO numberBaseballIO;
    private final User user;

    public NumberBaseball(
            int numberLimit,
            NumberBaseballIO numberBaseballIO,
            User user) {
        this.numberLimit = numberLimit;
        this.numberBaseballIO = numberBaseballIO;
        this.user = user;
    }


    public void startGame() {
        // 랜덤한 서로다른 숫자 생성
        List<Integer> answer = RandomUtils.generateDistinctNumbers(numberLimit);

        boolean isFinish = false;

        while (!isFinish) {
            // 정답 맞추기 시작
            List<Integer> guessAnswer = startGuess();

            //추측한 정답이 정답인지 확인
            if(checkGuessAnswer(answer,guessAnswer)) isFinish = true;
        }

        if(shouldContinueGame()) startGame();

    }

    private boolean shouldContinueGame() {
        int userChoice = numberBaseballIO.printEndMessageAndInputChoice(numberLimit);

        if(
                userChoice != NumberBaseballConstants.CONTINUE_GAME &&
                userChoice != NumberBaseballConstants.GAME_OVER
        )
            throw new IllegalArgumentException(
                    NumberBaseballConstants.CONTINUE_GAME +
                    " 또는 " +
                    NumberBaseballConstants.GAME_OVER +
                    "만 입력 가능합니다.");

        return userChoice == NumberBaseballConstants.CONTINUE_GAME;
    }


    private List<Integer> startGuess() {
        numberBaseballIO.printStart();
        return user.guessAnswer(numberLimit);
    }

    private boolean checkGuessAnswer(List<Integer> answer, List<Integer> guessAnswer) {
        Result guessResult = Result.of(answer, guessAnswer);
        numberBaseballIO.printGuessResult(guessResult);

        return guessResult.isCorrect();
    }
}
