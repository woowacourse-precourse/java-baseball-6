package baseball;

public class Referee {
    private TargetNumber targetNumber;

    private Referee() {
    }

    public static Referee enter() {
        return new Referee();
    }

    public void playBall(int a, int b, int c) {
        targetNumber = TargetNumber.generate(a, b, c);
    }

    public int[] judge(int[] numbers) {
        int[] judgment = new int[2];
        for (int i = 0; i < 3; i++) {
            boolean[] check = targetNumber.has(numbers[i], i);
            if (check[0]) judgment[0]++;
            if (check[1]) judgment[1]++;
        }

        declare(judgment);

        return judgment;
    }

    private void declare(int[] judgment) {
        if (judgment[1] == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if (judgment[0] == 0) {
            System.out.println("낫싱");
            return;
        }
        StringBuilder print = new StringBuilder();
        if (judgment[0] > 0) {
            print.append(String.format("%d볼 ", judgment[0] - judgment[1]));
        }
        if (judgment[1] > 0) {
            print.append(String.format("%d스트라이크", judgment[1]));
        }
        System.out.println(print);
    }
}
