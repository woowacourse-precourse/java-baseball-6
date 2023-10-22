package baseball.domain;

public class NumberBaseball {
    private final User user;

    public NumberBaseball(User user) {
        this.user = user;
    }

    public void play(int numberLimit) {
        // 랜덤한 서로다른 숫자 생성
        boolean isFinish = false;

        while (!isFinish) {
            Answer answer = Answer.createByRandom(numberLimit);
            user.guessUntilCorrect(answer);
            if(!user.isContinueGame(numberLimit)) isFinish = true;
        }
    }

}
