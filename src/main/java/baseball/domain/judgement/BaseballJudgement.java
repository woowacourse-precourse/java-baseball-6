package baseball.domain.judgement;

/**
 * 야구 게임에서 심판의 핵심 로직을 정의한 인터페이스입니다.
 */
public interface BaseballJudgement {
        /**
         * @implSpec 두 명의 플레이어에게 숫자로 구성된 문자열을 입력 받아, 게임의 진행 상태 정도를 반환합니다..
         *
         * @param num1 플레이어 1번의 숫자로 구성된 문자열
         * @param num2 플레이어 2번의 숫자로 구성된 문자열
         * @return 게임의 결과가 3 STRIKE 라면 FINISH, 이외의 경우에는 PROGRESS 반환
         */
        GameState judgementGameState(String num1, String num2);
}
