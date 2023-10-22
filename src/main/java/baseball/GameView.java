package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameView {
    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String getUserInput() throws IOException {
        System.out.print("숫자를 입력해주세요 : ");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        return bf.readLine();
    }

    public boolean showResult(Game model){
        if(model.getStrikes() == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else {
            if(model.getBalls() != 0){
                System.out.print(model.getBalls() + "볼 ");
            }
            if(model.getStrikes() != 0){
                System.out.print(model.getStrikes() + "스트라이크 ");
            }
        }
        return false;
    }

    public boolean playAgain() throws IOException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String result = bf.readLine();
        if(result.equals("1")) return true;
        return false;
    }
}
