package baseball.game;

import baseball.Exception.NumberDuplicateException;
import baseball.Exception.QueryMustPossibleIntegerException;
import baseball.Exception.SizeNotMatchException;
import baseball.game.vo.BallCount;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final NumberGengerator numberGengerator;
    private final GameView gameView;
    private List<Integer> answer;
    private int status;

    public Game(NumberGengerator numberGengerator, GameView gameView) {
        this.status = 0;
        this.gameView = gameView;
        this.numberGengerator = numberGengerator;
    }

    public void initGame() {
        this.answer = numberGengerator.numberGenerate();
    }

    public void run() {
        gameView.startBoot();
        initGame();

        while (isPlay()) {
            gameView.inputMessage();
            List<Integer> query = playerQuery();
            BallCount ballCount = determineQuery(answer, query);
        }
    }

    private BallCount determineQuery(List<Integer> answer, List<Integer> query) {
        BallCount ballCount = new BallCount();
        for (int i = 0; i < 3; i++) {
            throwBall(answer, query, i);
        }
        return null;
    }

    private void throwBall(List<Integer> answer, List<Integer> query, int i) {
        if (answer.get(i) == query.get(i)) {
            
        }
    }

    private List<Integer> playerQuery() {
        String qeury = Console.readLine();
        if (qeury.length() != 3) {
            throw new SizeNotMatchException();
        }
        if (!Validation.allPossibleDigit(qeury)) {
            throw new QueryMustPossibleIntegerException();
        }

        return queryToList();
    }

    public List<Integer> queryToList() {
        List<Integer> generateNumber = new ArrayList<>();
        while (generateNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            findDuplicatedNumber(generateNumber, randomNumber);
        }
        return generateNumber;
    }

    private void findDuplicatedNumber(List<Integer> generateNumber, int randomNumber) {
        if (generateNumber.contains(randomNumber)) {
            throw new NumberDuplicateException();
        }
        generateNumber.add(randomNumber);
    }

    private boolean isPlay() {
        return this.status != 2;
    }
}
