package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	
    	Computer computer = new Computer();
    	InputGame input = new InputGame();
    	BaseballGame game = new BaseballGame();
    	GameManager manager = new GameManager();
    	
    	boolean again = true;
    	
    	while(again) {
    		List<Integer> computerNumber = computer.ComputerNumber();
    		
    		String result = "";
    		
    		while(!result.equals("3스트라이크")) {
    			result = game.GameResult(computerNumber, input.playerNumber());
    			System.out.println(result);
    		}
    		
    		again = manager.gameManager();
    	}
    }
}
