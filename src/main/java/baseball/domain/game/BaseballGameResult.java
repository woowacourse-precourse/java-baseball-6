package baseball.domain.game;

/**
 * 야구 게임에서 발생할 수 있는 결과입니다.
 */
public enum BaseballGameResult {
        /**
         * 숫자를 맞추고 위치도 맞는 경우를 나태냅니다.
         */
        STRIKE("스트라이크"),

        /**
         * 숫자는 맞췄지만 위치가 틀린 경우를 나타냅니다.
         */
        BALL("볼"),

        /**
         * 숫자와 위치가 모두 틀린 경우를 나타냅니다.
         */
        NOTING("낫싱");

        private final String value;

        /**
         * BaseballGameResult enum 클래스의 생성자입니다.
         *
         * @param value 결과에 대응하는 한글 문자열
         */
        BaseballGameResult(String value) {
                this.value = value;
        }

        /**
         * 결과에 대응하는 한글 문자열을 반환합니다.
         *
         * @return 결과에 대응하는 한글 문자열
         */
        @Override
        public String toString() {
                return value;
        }
}
