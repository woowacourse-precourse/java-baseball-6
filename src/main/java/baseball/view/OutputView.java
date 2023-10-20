package baseball.view;

public class OutputView {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // TODO: 더 깔끔한 코드 고민해보기
    public void displayScoreboard(int[] score) {
        if(score[2] != 0) {
            System.out.println("낫싱");
        }
        else if(score[0] > 0 && score[1] > 0) {
            System.out.println(score[1] + "볼 " + score[0] + "스트라이크");
        }
        else if(score[0] > 0) {
            System.out.println(score[0] + "스트라이크");
        }
        else {
            System.out.println(score[1] + "볼");
        }
    }
}
