package baseball;

import java.io.*;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
        try {
            writer.write("숫자 야구 게임을 시작합니다.");
            writer.flush();
    
            Baseball baseball = new Baseball();
            baseball.start();
            while(true) {
                if (!baseball.play()) {
                    break;
                }
        
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
