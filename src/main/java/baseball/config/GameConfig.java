package baseball.config;

import baseball.input.GameControlInput;
import baseball.input.NumberInput;
import baseball.model.BallCounter;
import baseball.model.Computer;
import baseball.view.GameView;

import java.util.List;

/**
 * 게임 설정을 관리하는 클래스입니다.
 * 이 클래스는 게임을 구성하는 여러 객체(컴퓨터, 볼 카운터, 게임 뷰, 숫자 입력, 게임 컨트롤 입력)를 제공합니다.
 *
 * <p>주요 기능:
 * <ul>
 *   <li>게임에 필요한 컴퓨터 객체를 제공</li>
 *   <li>게임에 필요한 볼 카운터 객체를 제공</li>
 *   <li>게임에 필요한 뷰 객체를 제공</li>
 *   <li>게임에 필요한 숫자 입력 객체를 제공</li>
 *   <li>게임 컨트롤 입력을 처리하는 객체를 제공</li>
 * </ul>
 * </p>
 */
public class GameConfig {

    private final List<Integer> initialNumbers;

    /**
     * 초기 숫자를 받아 GameConfig 객체를 생성합니다.
     *
     * @param initialNumbers 게임 시작 시 사용될 초기 숫자 리스트
     */
    public GameConfig(List<Integer> initialNumbers) {
        this.initialNumbers = initialNumbers;
    }

    /**
     * 게임에서 사용될 컴퓨터 객체를 반환합니다.
     *
     * @return 컴퓨터 객체
     */
    public Computer computer() {
        return new Computer(initialNumbers);
    }

    /**
     * 게임에서 사용될 볼 카운터 객체를 반환합니다.
     *
     * @return 볼 카운터 객체
     */
    public BallCounter ballCounter() {
        return new BallCounter();
    }

    /**
     * 게임에서 사용될 뷰 객체를 반환합니다.
     *
     * @return 게임 뷰 객체
     */
    public GameView gameView() {
        return new GameView();
    }

    /**
     * 게임에서 사용자로부터 숫자 입력을 받는 객체를 반환합니다.
     *
     * @return 숫자 입력 객체
     */
    public NumberInput numberInput() {
        return new NumberInput();
    }

    /**
     * 게임에서 사용자로부터 게임 컨트롤(재시작, 종료 등) 입력을 받는 객체를 반환합니다.
     *
     * @return 게임 컨트롤 입력 객체
     */
    public GameControlInput gameControlInput() {
        return new GameControlInput();
    }
}
