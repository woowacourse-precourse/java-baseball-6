package view;

public class OutputBallCount {
    public void printCount(int[] ballCount){
        if(ballCount[0] == 0 && ballCount[1] == 0) System.out.println("낫싱");
        if(ballCount[0] == 0 && ballCount[1] != 0) System.out.println(ballCount[1] + "볼");
        if(ballCount[0] != 0 && ballCount[1] == 0) System.out.println(ballCount[0] + "스트라이크");
        if(ballCount[0] != 0 && ballCount[1] != 0) System.out.println(ballCount[1] + "볼 " + ballCount[0] + "스트라이크");
    }
}
