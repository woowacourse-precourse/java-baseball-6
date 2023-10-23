package baseball.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OutputManager {
    private Properties commonMessage;

    public OutputManager() throws IOException {
        InputStream commonMessageProperties = this.getClass().getResourceAsStream("/commonMessage.properties");

        this.commonMessage = new Properties();
        this.commonMessage.load(commonMessageProperties);
    }

    public void printMessage(String messageCommand) {
        if(messageCommand.equals("game.input")) {
            System.out.print(commonMessage.getProperty(messageCommand));
        } else {
            System.out.println(commonMessage.getProperty(messageCommand));
        }
    }

    public void printHint(char[] hintArr) {
        StringBuilder sb = new StringBuilder();
        int strikeCount = countStrike(hintArr);
        int ballCount = countBall(hintArr);
        boolean ballFlag = false;
        boolean strikeFlag = false;

        if(hintArr[0] == 'N') {
            sb.append("낫싱");
        }

        for(int idx = 1; idx < hintArr.length; idx++) {
            if(hintArr[idx] == 'S' && strikeFlag == false) {
                sb.append(strikeCount + "스트라이크 ");
                strikeFlag = true;
            }

            if(hintArr[idx] == 'B' && ballFlag == false) {
                sb.append(ballCount + "볼 ");
                ballFlag = true;
            }
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
