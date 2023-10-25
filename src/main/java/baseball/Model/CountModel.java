package baseball.Model;

public class CountModel {
    public static Integer ZERO = 0;
    private static Integer strikeCount=0;
    private static Integer ballCount=0;

    public CountModel(Integer strikeCount, Integer ballCount){
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static String countOutput(){
        String output = "";
        if (strikeCount == ZERO && ballCount == ZERO)
            output += "낫싱";
        else {
            if (ballCount > 0)
                output += ballCount + "볼 ";
            if (strikeCount > 0)
                output += strikeCount + "스트라이크";
        }
        return output;
    }

    public static boolean isStrike3(){
        if(strikeCount==3)
            return true;
        return false;
    }
}
