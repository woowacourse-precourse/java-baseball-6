package baseball.view;

public class ViewOutput {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printScore(int[] scores) {

        if(scores[0] == 0 && scores[1] == 0)
            System.out.println("낫싱");
        else if(scores[0] == 0)
            System.out.println(scores[1] + "볼");
        else if(scores[1] == 0)
            System.out.println(scores[0] + "스트라이크");
        else
            System.out.println(scores[1] + "볼" + " " + scores[0] + "스트라이크");
    }
}
