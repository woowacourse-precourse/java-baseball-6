package baseball.view;

public class OutputView {

    public void  printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printScoreMessage(int strikeCount, int ballCount){
        if(strikeCount == 0 && ballCount == 0){
            System.out.println("낫싱");
            return;
        }
        if(!(ballCount == 0) && !(strikeCount == 0)) {
            System.out.print(ballCount+"볼 " + strikeCount + "스트라이크");
            return;
        }
        if(!(ballCount == 0)) {
            System.out.println(ballCount + "볼");
            return;
        }
        System.out.println(strikeCount + "스트라이크");
    }

    public void printGameEndingMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
