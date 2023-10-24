package baseball;


/**
 * 랜덤 숫자를 생성하는 기능을 정의한 인터페이스입니다.
 * 확장성 및 테스트를 고려하여 해당 기능을 인터페이스로 생성하였습니다.
 */
public interface RandomGenerator {

    int pickNumberInRange(int start, int end);
}
