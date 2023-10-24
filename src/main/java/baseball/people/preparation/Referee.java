package baseball.people.preparation;

public class Referee {
    private TargetNumber targetNumber;

    Referee() {
    }

    /** Referee 객체를 생성하는 정적 팩토리 메서드 */
    public static Referee enter() {
        return new Referee();
    }

    /**
     * 3개의 숫자를 순서대로 받아서 멤버 변수인 targetNumber 값을 정할 수 있다.
     * (0, 0, 0)이 입력되면 임의의 3자리 숫자가 선택되고,
     * 1 ~ 9 중 3개의 서로 다른 숫자를 입력하는 것으로 targetNumber를 지정할 수 있다.
     * (값을 지정하는 것은 테스트를 위해 사용되었다.)
     */
    public void playBall(int a, int b, int c) {
        targetNumber = TargetNumber.generate(a, b, c);
    }

    /**
     * 3 자리 정수 배열이 들어왔을 때,
     * 볼과 스트라이크의 개수를 계산해서
     * 스트라이크의 개수가 3개인지 여부를 반환한다.
     * 반환 전에 declare 메서드를 호출해서
     * 볼과 스트라이크의 개수를 출력한다.
     */
    public boolean strikeOut(int[] numbers) {
        int ball = 0, strike = 0;
        for (int i = 0; i < 3; i++) {
            if (targetNumber.isStrike(numbers[i], i)) {
                strike++;
                continue;
            }
            if (targetNumber.isBall(numbers[i])) {
                ball++;
            }
        }

        declare(ball, strike);

        return strike == 3;
    }

    private void declare(int ball, int strike) {
        if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder print = new StringBuilder();
        if (ball > 0) {
            print.append(String.format("%d볼 ", ball));
        }
        if (strike > 0) {
            print.append(String.format("%d스트라이크", strike));
        }
        System.out.println(print);
    }
}
