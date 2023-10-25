package baseball;

public class Application {
    public static void main(String[] args) {
      
      Computer computer = new Computer();
      User user = new User();
      
      View.printGameStart();
      GameManager.initGameManager();
      while(GameManager.isGameRestart){
      
        GameManager.initGameManager();
        
        //컴퓨터 숫자 초기화
        computer.init();
        
        while(!GameManager.isGameEnd()){
          // 유저가 숫자 입력
          View.printEnterNumber();
          user.inputUserNumbers();
          
          //strike, ball 결과 계산
          GameManager.calculateResult(computer.getComNumbers(), user.getUserNumbers());
          View.printResult(GameManager.resultArr);
          
        }
        View.printGameEnd();
        GameManager.setIsGameRestart(user.inputUserRegame());
        
        }
    }
    
  
}
