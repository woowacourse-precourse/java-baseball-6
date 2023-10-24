package baseball;

public class View {
  public static void printGameStart(){
    System.out.println("숫자 야구 게임을 시작합니다.");
  }
  
  public static void printEnterNumber(){
    System.out.print("숫자를 입력해주세요 : ");
  }
  
  public static void printResult(int ballCnt, int strikeCnt){
    if(strikeCnt==0 && ballCnt==0){
      System.out.print("낫싱");
    }
    else{
      if (ballCnt>0)
        System.out.print(ballCnt + "볼 ");
      if(strikeCnt>0)
        System.out.print(strikeCnt + "스트라이크");
    }
    System.out.println();
  }
  
  public static void printGameEnd(){
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    
  }
  
}
