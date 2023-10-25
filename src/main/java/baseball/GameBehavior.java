package baseball;

import java.util.List;

public interface GameBehavior {
    /*
    현재 3자리 수에 대한 규칙 적용 중,
    4자리 수 등의 다른 숫자 입력 or 새로운 볼, 스트라이크 규칙 생성시
    새 클래스에 GameBehavior 인터페이스 상속받아 새로운 규칙 코드 작성
    */
    void ballAndStrikeCount(List<Integer> computer, String str); // 컴퓨터 숫자와 사용자 숫자의 볼, 스트라이크 판단
    String getResult(); // 아래 메서드에서 각 조건에 맞게 저장된 내용 출력
    String generateResultMessage(); // 각 숫자 입력시 볼, 스트라이크, 낫싱 판단
}
