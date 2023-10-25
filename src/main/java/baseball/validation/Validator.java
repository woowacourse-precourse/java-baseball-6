package baseball.validation;

/**
 * 검증 로직을 나타내는 인터페이스입니다.
 *
 * <p>이 인터페이스는 주어진 입력에 대한 검증 로직을 제공합니다.
 * 구현 클래스는 {@code validate} 메서드를 통해 구체적인 검증 로직을 구현해야 합니다.</p>
 *
 * @param <T> 검증 대상이 되는 타입
 */
public interface Validator<T> {

    /**
     * 주어진 입력에 대한 검증을 수행합니다.
     *
     * <p>검증에 실패할 경우, 적절한 예외를 발생시켜야 합니다.</p>
     *
     * @param input 검증할 대상 입력
     * @throws IllegalArgumentException 검증에 실패했을 때 발생
     */
    void validate(T input);
}
