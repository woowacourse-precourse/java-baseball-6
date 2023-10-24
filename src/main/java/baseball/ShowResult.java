package baseball;

class ShowResult {
    private final int numberOfDigits;
    public ShowResult(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }
    // 볼, 스트라이크 계산 후 결과 출력
    public void result(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            if (ball > 0) System.out.print(ball + "볼 ");
            if (strike > 0) System.out.print(strike + "스트라이크");
            System.out.println();
        }
    }

    public void win(int strike) {
        System.out.println(strike + "스트라이크");
        System.out.println(numberOfDigits + "개의 숫자를 모두 맞히셨습니다! 게임 종료"); // all strike인 경우 게임 종료 문구 출력
    }
}
