package baseball.people.preparation;

public class Referee {
    private TargetNumber targetNumber;

    Referee() {
        targetNumber = TargetNumber.generate(0, 0, 0);
    }

    /**
     * Referee 객체를 생성하는 정적 팩토리 메서드
     * @return Referee 객체
     */
    public static Referee enter() {
        return new Referee();
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
