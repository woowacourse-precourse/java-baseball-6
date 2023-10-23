package baseball;

public class BaseballGameView {

    public void print(int[] result){
        int strike = result[0];
        int ball = result[1];
        int size = result[2];

        if(strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }

        if(ball != 0) {
            System.out.print(ball + "볼 ");
        }

        if(strike != 0) {
            System.out.print(strike + "스트라이크");
        }

        if(strike == size) {
            System.out.println();
            System.out.print("정답입니다! 새 게임을 시작하려면 1, 게임을 종료하려면 2를 입력하세요.");
        }
        System.out.println();
    }
}
