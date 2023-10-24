package baseball;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		
    	Exception RestartInput = new Exception();
    	PlayerInput Input = new PlayerInput();
		
    	int start = 0;
    	
    	while(start == 0) {
    	
    	  int restart;
          
    	  game();
    	  
    		
    	  System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");	
		  String InputNum = Input.PlayerInputNum();		  
		  restart = RestartInput.RestartException(InputNum);;
		  
		  if(restart == 2) {
			  start = 1;
			  return;
		  }		
        }
    	
    }


public static void game() {
	Computer computer = new Computer();
	PlayerInput Input = new PlayerInput();
	Exception vaild = new Exception();
	Compare pcCompare = new Compare();
	

	
	
	
	
	System.out.println("게임을 시작합니다.");
	int strike = 0;
	int GameStart = 1;

	
	List<Integer> RandomNum = computer.RandomComputerNum();

	
	while(GameStart == 1) {
      System.out.println("숫자를 입력하세요. : ");
      String InputNum = Input.PlayerInputNum();
   	  List<Integer> PlayerNum = vaild.InputException(InputNum);
    	 
   	  strike = pcCompare.CompareNum(PlayerNum, RandomNum);
    	 
   	  if(strike == 3) {
 		 strike = 0;
 		 System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    	 break;
   	  }
   }
  }
}
    	


