package baseball.input;

import baseball.validation.GameControlValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 게임 컨트롤에 관한 사용자 입력을 처리하는 클래스입니다.
 *
 * <p>이 클래스는 게임의 컨트롤(예: 게임 재시작, 종료 등)과 관련된 사용자 입력을 받아옵니다.
 * 입력된 값은 {@link GameControlValidator}를 사용하여 유효성 검사를 진행합니다.</p>
 */
public class GameControlInput implements Input<String> {

    private final GameControlValidator validator;

    /**
     * {@link GameControlValidator} 인스턴스를 생성하여 초기화합니다.
     */
    public GameControlInput() {
        this.validator = new GameControlValidator();
    }

    /**
     * 사용자로부터 게임 컨트롤 관련 입력을 받아와 유효성 검사 후 반환합니다.
     *
     * <p>입력된 값이 유효하지 않은 경우, {@link GameControlValidator}에서 예외를 발생시킵니다.</p>
     *
     * @return 유효한 게임 컨트롤 입력값
     */
    @Override
    public String getInput() {
        String input = Console.readLine().trim();
        validator.validate(input);
        return input;
    }
}
