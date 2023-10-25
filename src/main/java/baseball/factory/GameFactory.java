package baseball.factory;

import baseball.config.GameConfig;
import baseball.controller.GameController;
import baseball.model.Game;

/**
 * 게임 및 게임 컨트롤러를 생성하는 팩토리 클래스입니다.
 *
 * <p>이 클래스는 주로 게임의 설정({@link GameConfig})을 바탕으로
 * 게임({@link Game}) 및 게임의 흐름을 제어하는 컨트롤러({@link GameController})를 생성합니다.</p>
 */
public class GameFactory {

    /**
     * {@link GameConfig} 설정을 바탕으로 게임({@link Game}) 객체를 생성합니다.
     *
     * @param config 게임 생성에 필요한 설정 정보
     * @return 생성된 게임 객체
     */
    public static Game createGame(GameConfig config) {
        return new Game.Builder()
                .computer(config.computer())
                .ballCounter(config.ballCounter())
                .build();
    }

    /**
     * {@link Game} 및 {@link GameConfig} 설정을 바탕으로 게임 컨트롤러({@link GameController}) 객체를 생성합니다.
     *
     * @param game 게임 로직 처리를 위한 객체
     * @param config 게임 컨트롤러 생성에 필요한 설정 정보
     * @return 생성된 게임 컨트롤러 객체
     */
    public static GameController createGameController(Game game, GameConfig config) {
        return new GameController(game, config.gameView(), config.numberInput(), config.gameControlInput());
    }
}
