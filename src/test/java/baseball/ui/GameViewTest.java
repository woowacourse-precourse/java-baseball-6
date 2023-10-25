package baseball.ui;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.controller.AbstractGameController;
import baseball.controller.GameController;
import baseball.controller.GameControllerFactory;
import baseball.state.DefaultScoringFactory;
import baseball.state.Scoring;
import baseball.state.ScoringFactory;
import baseball.ui.input.component.InputComponent;
import baseball.ui.output.component.OutputComponentImpl;
import baseball.ui.output.format.ResultFormatStringCreatorImpl;
import baseball.util.RandomNumberCreator;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameViewTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void 게임시작_시작안내문구를_출력한다() {
        GameView gameView = getGameViewTerminateAfterGetRight((scoringFactory) -> getMockControllerTry(1));

        gameView.start();

        assertExpectedStringIsContainedInTargetString("숫자 야구 게임을 시작합니다.", outputStreamCaptor.toString().trim());

    }

    @Test
    public void 추측시작_입력안내문구를_출력한다() {
        GameView gameView = getGameViewTerminateAfterGetRight(scoringFactory -> getMockControllerTry(1));

        gameView.guessUntilCorrect();

        assertExpectedStringIsContainedInTargetString("숫자를 입력해주세요 : ", outputStreamCaptor.toString().trim());
    }

    @Test
    public void 추측_실패시_다시_추측한다() {
        GameView gameView = getGameViewTerminateAfterGetRight((scoringFactory) -> getMockControllerTry(2));

        gameView.guessUntilCorrect();

        assertExpectedStringIsContainedInTargetString("숫자를 입력해주세요 : 숫자를 입력해주세요 : ",
                outputStreamCaptor.toString().trim());
    }

    @Test
    public void 정답_후_재시작() {
        GameView gameView = getGameViewRestartAfterGetRight(scoringFactory -> getMockGameControllerThatUserGetRight());

        gameView.determineFlow("1");

        assertExpectedStringIsContainedInTargetString("숫자를 입력해주세요 : ", outputStreamCaptor.toString().trim());
    }

    @Test
    public void 정답_후_종료() {
        GameView gameView = getGameViewTerminateAfterGetRight(
                scoringFactory -> getMockGameControllerThatUserGetRight());

        gameView.determineFlow("2");

        assertExpectedStringIsContainedInTargetString("게임 종료", outputStreamCaptor.toString().trim());
    }

    @Test
    public void 추측_성공시_성공문구_출력한다() {
        GameView gameView = getGameViewTerminateAfterGetRight(
                scoringFactory -> getMockGameControllerThatUserGetRight());

        gameView.guessUntilCorrect();

        assertExpectedStringIsContainedInTargetString("3개의 숫자를 모두 맞히셨습니다! 게임 종료", outputStreamCaptor.toString().trim());
    }

    private void assertExpectedStringIsContainedInTargetString(String expectedString, String targetString) {
        assertThat(targetString.contains(expectedString));
    }

    private GameView getGameViewRestartAfterGetRight(GameControllerFactory gameControllerFactory) {
        return getGameViewAfterRight(gameControllerFactory, () -> "1");
    }

    private GameView getGameViewTerminateAfterGetRight(GameControllerFactory gameControllerFactory) {
        return getGameViewAfterRight(gameControllerFactory, () -> "2");
    }

    private GameView getGameViewAfterRight(GameControllerFactory gameControllerFactory,
                                           InputComponent mockResumeInput) {
        return new GameView(new DefaultScoringFactory(), gameControllerFactory,
                mockUserAnswerInput(), mockResumeInput,
                new OutputComponentImpl(), new ResultFormatStringCreatorImpl());
    }

    private GameController getMockControllerTry(int targetCount) {
        AtomicInteger count = new AtomicInteger(0);
        return getGameControllerMockingCorrectCondition(
                () -> count.getAndIncrement() < targetCount);
    }

    private GameController getMockGameControllerThatUserGetRight(ScoringFactory scoringFactory) {
        return getMockGameControllerThatUserGetRight();
    }

    private GameController getMockGameControllerThatUserGetRight() {
        return getGameControllerMockingCorrectCondition(() -> true);
    }

    private GameController getGameControllerMockingCorrectCondition(BooleanSupplier didUserGetRight) {
        return new AbstractGameController(
                getDefaultScoring()) {
            @Override
            public boolean isStillWrong() {
                return !didUserGetRight.getAsBoolean();
            }
        };
    }

    private static InputComponent mockUserAnswerInput() {
        return () -> "123";
    }

    private static Scoring getDefaultScoring() {
        return new Scoring(RandomNumberCreator.createByLength(3));
    }

}