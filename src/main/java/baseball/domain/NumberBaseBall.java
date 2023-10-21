package baseball.domain;

import java.util.List;

public class NumberBaseBall {

    private final RandomNumberPicker randomNumberPicker;
    private final GameIO gameIO;
    private final User user;

    public NumberBaseBall(
            RandomNumberPicker randomNumberPicker,
            GameIO gameIO,
            User user) {
        this.randomNumberPicker = randomNumberPicker;
        this.gameIO = gameIO;
        this.user = user;
    }
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";
    public static final int CONTINUE_GAME = 1;
    public static final int GAME_OVER = 2;


    public void startGame(int numberLength) {
        // 랜덤한 서로다른 숫자 생성
        List<Integer> answer = randomNumberPicker.generateDistinctNumbers(numberLength);

        boolean isFinish = false;

        while (!isFinish) {
            // 정답 맞추기 시작
            List<Integer> guessAnswer = startGuess(numberLength);

            //추측한 정답이 정답인지 확인
            if(checkGuessAnswer(answer,guessAnswer)) isFinish = true;
        }

        if(shouldContinueGame()) startGame(numberLength);

    }

    private boolean shouldContinueGame() {
        int userChoice = gameIO.printEndMessageAndInputChoice();

        if(userChoice != CONTINUE_GAME && userChoice != GAME_OVER)
            throw new IllegalArgumentException(
                    CONTINUE_GAME +
                    " 또는 " +
                    GAME_OVER +
                    "만 입력 가능합니다.");

        return userChoice == CONTINUE_GAME;
    }


    private List<Integer> startGuess(int numberLength) {
        gameIO.printStart();
        return user.guessAnswer(numberLength);
    }

    private boolean checkGuessAnswer(List<Integer> answer, List<Integer> guessAnswer) {
        Result guessResult = Result.of(answer, guessAnswer);
        gameIO.printGuessResult(guessResult);

        return guessResult.isCorrect();
    }
}
