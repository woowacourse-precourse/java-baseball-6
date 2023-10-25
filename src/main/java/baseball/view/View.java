package baseball.view;

public class View {

    public void displayBothResult(int[] result) {
        System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
    }

    public void displayOnlyStrikeResult(int[] result) {
        System.out.println(result[0]+"스트라이크");
    }
    public void displayOnlyBallResult(int[] result) {
        System.out.println(result[1]+"볼");
    }
    public void displayNothingResult(){
        System.out.println("낫싱");
    }

}
