package baseball.baseballV2.system;

import static baseball.baseballV2.system.util.Util.GAME_RESTART_CHOICE_KEY;
import static baseball.baseballV2.system.util.Util.GAME_RESULT_PATH;

import baseball.baseballV2.controller.Controller;
import baseball.baseballV2.controller.EnterTripleBallsController;
import baseball.baseballV2.controller.GameRestartController;
import baseball.baseballV2.controller.GameResultController;
import baseball.baseballV2.controller.GameStartController;
import baseball.baseballV2.model.RestartChoice;
import baseball.baseballV2.system.util.RandomTripleBallsGenerator;
import baseball.baseballV2.view.inputview.EnterTripleBallsInputView;
import baseball.baseballV2.view.inputview.GameRestartInputView;
import baseball.baseballV2.view.outputview.EnterTripleBallsOutputView;
import baseball.baseballV2.view.outputview.GameRestartOutputView;
import baseball.baseballV2.view.outputview.GameResultOutputView;
import baseball.baseballV2.view.outputview.GameStartOutputView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaseBallApplication {
    public static final String GAME_START_PATH = "gameStart";
    public static final String ENTER_TRIPLE_BALLS_PATH = "enterTripleBalls";
    public static final String GAME_RESTART_PATH = "gameRestart";

    public static final String GAME_RESTART_VALUE = "1";

    private final Map<String, Controller> controllerMap = new HashMap<>();

    public BaseBallApplication() {
        controllerMap.put(GAME_START_PATH, new GameStartController(new GameStartOutputView()));
        controllerMap.put(ENTER_TRIPLE_BALLS_PATH, new EnterTripleBallsController(
                new EnterTripleBallsOutputView(), new EnterTripleBallsInputView()
        ));
        controllerMap.put(GAME_RESTART_PATH, new GameRestartController(new GameRestartOutputView(),
                new GameRestartInputView()));
    }

    public void run() {
        Map<String, Object> model = new HashMap<>();
        initGame(model);

        startGame(model);
    }

    private void startGame(Map<String, Object> model) {
        RestartChoice restartChoice;
        do {
            controllerMap.put(GAME_RESULT_PATH, new GameResultController(new GameResultOutputView(),
                    RandomTripleBallsGenerator.generate()));
            playGame(model);
            restartChoice = (RestartChoice) model.get(GAME_RESTART_CHOICE_KEY);
        } while (isRestart(restartChoice));

    }

    private void playGame(Map<String, Object> model) {
        do {
            enterTripleBalls(model);
            getGameResult(model);
        } while (!hasThreeStrikes(model));

        getRestartChoice(model);
    }

    private boolean isRestart(RestartChoice restartChoice) {
        if (restartChoice == RestartChoice.ONE) {
            return true;
        }
        return false;
    }

    private void getRestartChoice(Map<String, Object> model) {
        controllerMap.get(GAME_RESTART_PATH).process(model);
    }

    private boolean hasThreeStrikes(Map<String, Object> model) {
        List<Integer> ballAndStrikeCounts = (List<Integer>) model.get(GAME_RESULT_PATH);
        return ballAndStrikeCounts.stream()
                .skip(1)
                .allMatch(strikeCount -> strikeCount == 3);
    }

    private void getGameResult(Map<String, Object> model) {
        controllerMap.get(GAME_RESULT_PATH).process(model);
    }

    private void enterTripleBalls(Map<String, Object> model) {
        try {
            controllerMap.get(ENTER_TRIPLE_BALLS_PATH).process(model);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void initGame(Map<String, Object> model) {
        controllerMap.get(GAME_START_PATH).process(model);
    }
}
