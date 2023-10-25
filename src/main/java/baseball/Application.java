package baseball;

import baseball.config.GameConfig;
import baseball.controller.GameController;
import baseball.factory.GameFactory;
import baseball.util.NumberGenerator;

/**
 * 야구 게임 어플리케이션의 진입점 클래스입니다.
 *
 * <p>이 클래스는 야구 게임의 설정, 게임 컨트롤러의 생성 및 게임의 시작을 관리합니다.</p>
 */
public class Application {
    /**
     * 야구 게임 어플리케이션의 시작 메서드입니다.
     *
     * <p>야구 게임의 설정을 초기화하고, 게임 컨트롤러를 생성하여 게임을 시작합니다.
     * 게임 중 발생하는 예외 상황은 적절한 메시지로 사용자에게 알립니다.</p>
     *
     * @param args 커맨드 라인 인자 (현재 사용되지 않음)
     */
    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig(NumberGenerator.generateUniqueNumbers());
        GameController gameController = GameFactory.createGameController(GameFactory.createGame(gameConfig), gameConfig);

        try {
            gameController.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
