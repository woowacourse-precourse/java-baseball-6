package baseball.domain;

public class NumberBaseball {
    private final User user;

    public NumberBaseball(User user) {
        this.user = user;
    }

    public void play(int numberLimit) {
        do {
            Answer answer = Answer.createByRandom(numberLimit);
            System.out.println(answer.getAnswer());
            user.guessUntilCorrect(answer);
        }while (user.isContinueGame(numberLimit));
    }

}
