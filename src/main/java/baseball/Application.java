package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	
		Output.gameStart(); // 게임 시작 메세지 출력
    	
		do { 
			GameController game = new GameController();
			game.play(); // 게임 컨트롤러 실행
		} while (Input.newGameSelect());
    }
}
