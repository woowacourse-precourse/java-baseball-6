package view;

public class OutputBallCount {

    /**
     * 게임 결과에 대한 출력 기능
     * 게임 결과를 배열로 받아서 출력
     */
    public void printCount(int[] ballCount){
        if(ballCount[0] == 0 && ballCount[1] == 0) System.out.println("낫싱");
        if(ballCount[0] == 0 && ballCount[1] != 0) System.out.println(ballCount[1] + "볼");
        if(ballCount[0] != 0 && ballCount[1] == 0 && ballCount[0] != 3){
            System.out.println(ballCount[0] + "스트라이크");
        }
        if(ballCount[0] == 3){
            System.out.println(ballCount[0] + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        }
        if(ballCount[0] != 0 && ballCount[1] != 0) System.out.println(ballCount[1] + "볼 " + ballCount[0] + "스트라이크");
    }
}
