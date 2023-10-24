package baseball;

import java.util.ArrayList;
import java.util.List;

public final class BaseballController {

  private static BaseballService bs = new BaseballService();
  private static MsgService ms = new MsgService();
  private static UserChatService ucs = new UserChatService();


  public BaseballController(){}

  public void GameStart(){

    System.out.println(ms.starMSG());
    outLoop:
    while(true) {
      try {
        // 채팅받고 예외 터트림
        String input = ucs.inputChat();
        if(input.equals("No")) {throw new IllegalArgumentException();}

        // 포비븨 리스트 생성
        List<String> computer = bs.createComList();
        // 유저 리스트
        List<String> user = bs.createUserList(input);

        // 두가지 리스트를 믹스하면 경기 결과를 알려줌
        BallCountVO ballCountAll
            = bs.createBallCountAll(computer,user);

        // 경기 결과 메시지 출력해줌
        ucs.resultGameCount(ballCountAll);

        //
        String newGameCheck = ucs.stringCaseNumber();
        switch (newGameCheck){
          case "1" : continue outLoop;
          case "2" : return;
          default: break;
        }


        System.out.println(ms.strike(2));
        System.out.println(ms.strike(3));
        System.out.println(ms.ball(1));
        System.out.println(ms.nothing());



      } catch (IllegalArgumentException e) {
        return;






  }



}
