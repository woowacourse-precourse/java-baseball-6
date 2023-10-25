package baseball.game;

class GamePhrases {
    protected static void startPhrase() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    protected static void inputPhrase() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    protected static void answerPhrase() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    protected static void endPhrase() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    protected static void strikePhrase(int strike) {
        System.out.println(strike + "스트라이크");
    }

    protected static void ballPhrase(int ball) {
        System.out.println(ball + "볼");
    }

    protected static void ballAndStrikePhrase(int strike, int ball) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    protected static void outPhrase() {
        System.out.println("낫싱");
    }
}
