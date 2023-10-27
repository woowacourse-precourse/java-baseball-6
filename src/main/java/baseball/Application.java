package baseball;

public class Application {

	public static void main(String[] args) {
		
    	Exception RestartInput = new Exception();
    	PlayerInput Input = new PlayerInput();
		GameCollect Game = new GameCollect();
    	
    	int start = 0;
    	
    	while(start == 0) {
    	
    	  int restart;
          
    	  Game.game();
    	  
    		
    	  System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");	
		  String InputNum = Input.PlayerInputNum();		  
		  restart = RestartInput.RestartException(InputNum);;
		  
		  if(restart == 2) {
			  start = 1;
			  return;
		  }		
        }
    	
     }

}
    	


