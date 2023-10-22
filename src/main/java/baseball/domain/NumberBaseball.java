package baseball.domain;

public class NumberBaseball {
    private final User user;

    public NumberBaseball(User user) {
        this.user = user;
    }

    public void startGame(int numberLimit) {
        // 랜덤한 서로다른 숫자 생성
        Answer answer = Answer.createByRandom(numberLimit);

        user.guessUntilCorrect(answer);

        if(user.isContinueGame(numberLimit)) startGame(numberLimit);
    }

}
