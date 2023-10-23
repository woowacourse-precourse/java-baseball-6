package baseball;

import baseball.controller.Game;
import baseball.model.Retry;
import baseball.view.input_View;
import baseball.view.output_View;

public class Application {
    public static void main(String[] args) {
    	output_View.Start_Message();
    	
    	do {
    		Game game = new Game();
    		game.start();
    	}while(Retry_Message());
    	
    }
    
    public static boolean Retry_Message() {
    	Retry retry = new Retry(input_View.Retry());
    	
    	if(retry.getRetryNumber().equals("1")) {
    		return true; // 재시작
    	}
    	
    	return false; // 종료
    }
}
