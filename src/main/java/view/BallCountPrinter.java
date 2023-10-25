package view;

public class BallCountPrinter {

    /**
     * 게임 결과에 대한 출력 기능
     * 게임 결과를 배열로 받아서 출력
     */
    public void printBallCount(int[] ballCount){
        int strike = ballCount[0];
        int ball = ballCount[1];

        if(strike == 0 && ball == 0) System.out.println("낫싱");

        if(ball > 0) System.out.println(ball + "볼 ");

        if(strike > 0) System.out.println(ballCount[0] + "스트라이크");

//        if(ballCount[0] == 3){
//            System.out.pri정ntln(ballCount[0] + "스트라이크");
//            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//
//        }

    }

}
