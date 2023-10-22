package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class ViewResult {
    private final String nothing = "낫싱";
    private final String strike = "스트라이크";
    private final String ball = "볼";
    public void printResult(int strikeScore, int ballScore) throws IOException {
        if(strikeScore >= 1 && ballScore >= 1){
            System.out.println(strikeScore + strike + " " + ballScore+ball);
        }
        else if(strikeScore == 0 && ballScore == 0){
            System.out.println(nothing);
        }
        else if(strikeScore == 0 && ballScore >= 1){
            System.out.println(ballScore + ball);
        }
        else if(strikeScore >= 1 && ballScore == 0){
            System.out.println(strikeScore + strike);
        }
    }
}
