package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Baseball {
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    ComputerNumber computerNumber;
    
    public Baseball() {
        computerNumber = new ComputerNumber();
    }
    
    public void start() {
        computerNumber.pickThreeNumber();
    }
    
    public boolean play() throws IOException {
        String userInput;
        int score = 0;
    
        writer.write("\n숫자를 입력해주세요 : ");
        writer.flush();
        userInput = Console.readLine();
        if (computerNumber.validation(userInput)) {
            score = computerNumber.calculateScore(userInput);
        }
        return showResult(score);
    }
    
    private boolean showResult(int score) throws IOException {
        String strikes, balls;
        
        if (score == 0) {
            writer.write("낫싱");
            writer.flush();
        }
    
        if (score == 30) {
            writer.write("3스트라이크\n");
            writer.write("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            writer.write("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            writer.flush();
            if (Console.readLine().equals("2")) {
                return false;
            }
            computerNumber.deleteComputerNumber();
            start();
            
        }
    
        if (score > 0 && score < 30) {
            strikes = String.valueOf(score / 10);
            balls = String.valueOf(score % 10);
            
            if (!balls.equals("0")){
                writer.write(balls + "볼 ");
            }
            
            if (!strikes.equals("0")){
                writer.write(strikes + "스트라이크 ");
            }
            writer.flush();
        }
        return true;
    }
}
