package baseball.view;

public class OutputView {

    public void printResult(int strikeCount, int ballCount){
        if(strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }

        else if(strikeCount == 3){
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            printStrike();
        }
        else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public void printStrike(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
