package baseball.view;

public class OutputView {

    public void printBallNStrike(int ball, int strike){
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
    
    public void printBall(int ball){
        System.out.println(ball + "볼");
    }

    public void printStrike(int strike){
        System.out.println(strike + "스트라이크");

        if(strike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public void printNothing(){
        System.out.println("낫싱");
    }



}
