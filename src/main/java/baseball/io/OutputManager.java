package baseball.io;


import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class OutputManager {
//    private Properties commonMessage;
//
//    public OutputManager() throws IOException {
//        InputStream commonMessageProperties = this.getClass().getResourceAsStream("/commonMessage.properties");
//
//        this.commonMessage = new Properties();
//        this.commonMessage.load(commonMessageProperties);
//    }

    public void printMessage(CommonMessage commonMessage) {
        System.out.println(commonMessage.getText());
    }

    public void printHint(char[] hintArr) {
        StringBuilder sb = new StringBuilder();
        int strikeCount = countStrike(hintArr);
        int ballCount = countBall(hintArr);

        if(hintArr[0] == 'N') {
            sb.append("낫싱");
        }
        if(ballCount != 0) {
            sb.append(ballCount + "볼 ");
        }
        if(strikeCount != 0) {
            sb.append(strikeCount + "스트라이크 ");
        }

        System.out.println(sb);
    }

    public int countStrike(char[] hintArr) {
        int strikeCount = 0;

        for(char hint : hintArr) {
            if(hint == 'S') {
                strikeCount++;
            }
        }
        return  strikeCount;
    }

    public int countBall(char[] hintArr) {
        int ballCount = 0;

        for(char hint : hintArr) {
            if(hint == 'B') {
                ballCount++;
            }
        }
        return  ballCount;
    }
}
