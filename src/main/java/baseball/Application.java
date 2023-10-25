package baseball;


public class Application {

	private static int game_status = 0; // 1 종료, 2 재시작

    public static void main(String[] args) {
	    System.out.println("숫자 야구 게임을 시작합니다.");
	    Game game = new Game();
	    game.start();
	    game_status = game.getstatus();
	    if (game_status == 1) {
	    	main(args);
	    }
	    	
	    
	}

}

