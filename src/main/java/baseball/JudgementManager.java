package baseball;

public class JudgementManager {
    public void judge(Game game) {
        String answer = game.getAnswer();
        String input = game.getGameInput();
        int[] result = new int[]{0,0};

        for (int i=0; i<3; i++) {
            char c = input.charAt(i);
            if (c == answer.charAt(i)) {
                result[1] += 1;
                continue;
            }
            if (answer.contains(String.valueOf(c))) {
                result[0] += 1;
            }
        }

        game.setResult(result);
    }

    public void printResult(Game game) {
        int[] result = game.getResult();
        int ball = result[0];
        int strike = result[1];

        if (ball + strike == 0) {
            System.out.print("낫싱");
        }
        if (ball != 0) {
            System.out.printf("%d볼 ", ball);
        }
        if (strike != 0) {
            System.out.printf("%d스트라이크", strike);
        }
        System.out.println();

        if (strike == 3) {
            game.setGameOver(true);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

    }
}
