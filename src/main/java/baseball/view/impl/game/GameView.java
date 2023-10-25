package baseball.view.impl.game;

import baseball.model.ComparisonResult;
import baseball.model.UserBallNumbers;
import baseball.utils.RandNumGenerator;
import java.util.List;

public class GameView {
    private final UserNumberInputView inputView = new UserNumberInputView();
    private final GameOutputView outputView = new GameOutputView();

    public void game() {
        List<Integer> answerNumbers = RandNumGenerator.generateAnswerNumbers();

        while (!playRound(answerNumbers))
            ;
        outputView.showAfterSuccess();
    }

    private boolean playRound(List<Integer> answerNumbers) {
        UserBallNumbers userBallNumbers = inputView.getInput();
        ComparisonResult comparisonResult = ComparisonResult.of(userBallNumbers.getUserBallNumbers(), answerNumbers);

        outputView.show(comparisonResult.getResult());
        return comparisonResult.isCorrect();
    }
}