package baseball.input;

/**
 * 사용자 입력에 관한 인터페이스입니다.
 *
 * <p>다양한 종류의 사용자 입력 처리를 위해 이 인터페이스를 구현합니다.
 * 이를 통해 특정 입력 형식에 따라 다양한 구현이 가능하도록 합니다.</p>
 *
 * @param <T> 사용자로부터 입력받을 데이터의 타입
 */
public interface Input<T> {

    /**
     * 사용자로부터 입력을 받아 해당 타입의 데이터로 반환합니다.
     *
     * @return 사용자로부터 입력받은 데이터
     */
    T getInput();
}
