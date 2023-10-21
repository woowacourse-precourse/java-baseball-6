package baseball.domain;

import java.util.List;

public class NumberBaseBall {
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";
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

    public void startGame(int numberLength) {
        // 랜덤한 서로다른 숫자 생성
        List<Integer> answer = randomNumberPicker.generateDistinctNumbers(numberLength);

        boolean isFinish = false;

        while (!isFinish) {
            // 정답 맞추기 시작
            gameIO.printStart();
            List<Integer> guessAnswer = user.guessAnswer(numberLength);

            //추측한 정답에 대한 결과
            Result guessResult = Result.of(answer, guessAnswer);
            gameIO.printGuessResult(guessResult);

            //결과가 정답인지 확인
            if(guessResult.isCorrect()) isFinish = true;
        }

        int userChoice = gameIO.printEndMessageAndInputChoice();

        if(userChoice != 1 && userChoice != 2)
            throw new IllegalArgumentException("1또는 2를 입력해야합니다.");

        if(userChoice == 1) startGame(numberLength);

    }
}
