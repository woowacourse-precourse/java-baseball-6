package baseball;

public class Result {
    public Boolean getResult(int[] score) {
        if (score[0] == 0) {
            if (score[1] == 0) {
                System.out.println("낫싱");
            } else {
                System.out.printf("%d스트라이크\n", score[1]);
            }
        } else if (score[1] == 0) {
            System.out.printf("%d볼\n", score[0]);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", score[0], score[1]);
        }
        if (score[1] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
