package baseball.computer;

public class Score {
    public int StrikeNum = 0;
    public int BallNum = 0;

    public void resetScore() {
        this.StrikeNum = 0;
        this.BallNum = 0;
    }


    public void checkScore(String computerNum, String UserNum) {

        for (int i = 0; i < 3; i++) {
            if (computerNum.charAt(i) == UserNum.charAt(i)) {
                StrikeNum++;
            } else if (computerNum.contains(String.valueOf(UserNum.charAt(i)))) {
                BallNum++;
            }
        }
    }


    public void tellScore() {
        if (StrikeNum != 0 && BallNum != 0) {
            System.out.printf("%d볼 %d스트라이크", BallNum, StrikeNum);
            System.out.println();
        } else if (StrikeNum == 0 && BallNum != 0) {
            System.out.printf("%d볼", BallNum);
            System.out.println();
        } else if (BallNum == 0 && StrikeNum != 0) {
            System.out.printf("%d스트라이크", StrikeNum);
            System.out.println();
        } else if (StrikeNum == 0 && BallNum == 0) {
            System.out.print("낫싱");
            System.out.println();

        }
    }
}
