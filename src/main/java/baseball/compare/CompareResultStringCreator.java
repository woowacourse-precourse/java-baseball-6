package baseball.compare;
public class CompareResultStringCreator {
    public String compareResultStringCreate(int strikeCount, int ballCount) {
        if (strikeCount != 0 && ballCount == 0) {
            return strikeCount + "스트라이크";
        }
        if (strikeCount == 0 && ballCount != 0){
            return ballCount + "볼";
        }
        if (strikeCount == 0 && ballCount == 0){
            return "낫싱";
        }
        return  ballCount + "볼 " + strikeCount + "스트라이크";
    }
}
