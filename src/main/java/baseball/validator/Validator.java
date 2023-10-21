package baseball.validator;

/**
 * TODO 인터페이스가 꼭 필요한지 다시 생각해보기
 *
 * 다른 클래스에서 Validator 객체를 생성하지 않고 바로 쓰도록 하는 것이 목적
 * 그러기 위해선
 * 1. static 메서드를 사용하거나
 * 2. 싱글톤 패턴을 사용해야 함
 *
 * 그러나 인터페이스를 쓰면 static 메서드 불가.
 * 그래서 싱글톤으로 객체를 생성해야 하는데, 이려면 구현 클래스 코드가 너무 길고 더 복잡해지는 감이 있음.
 * 더구나 Validator 인터페이스에 메서드가 validate() 하나밖에 없어서
 * 실제로 인터페이스를 쓸 때의 효용성이 충분한지도 의문
 *
 * 즉 이 상황에서는, 굳이 인터페이스를 고집했을 때 득보다 실이 더 많을수도 있다고 생각
 */
public interface Validator {

    void validate(String input);
}
