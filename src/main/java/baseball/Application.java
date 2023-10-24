package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	
		Output.startGamet(); // 게임 시작 메세지 출력
    	
		do { 
			GameController baseballgame = new GameController();
			baseballgame.play(); // 게임 컨트롤러 실행
		} while (confirmRestart());
    }
    
    public static boolean confirmRestart() {
    	int playerInput = Integer.parseInt(Input.selectNewGame());
    	if (playerInput == 1) {
    		return true;
    	}
    	return false;
    }
}
