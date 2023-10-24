package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {

  private static BaseballController bs = new BaseballController();
  private static MsgService ms = new MsgService();
  private static UserChatService ucs = new UserChatService();

  private static  ComPuTaService com = new ComPuTaService();
  public static void main(String[] args) {
    System.out.println(ms.starMSG());
    while(true) {
      try {
        // 채팅받고 예외 터트림
        String input = ucs.inputChat();
        if(input.equals("No")) {throw new IllegalArgumentException();}

        // 포비븨 생성
        ComPuTaVO poBV = com.cOm();
        System.out.println(poBV.getOneValue());
        List<String> list = new ArrayList<>();
        list.add(poBV.getOneValue());
        list.add(poBV.getTwoValue());
        list.add(poBV.getThreeValue());
        System.out.println(list);

        List<String> userList = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
          userList.add(String.valueOf(input.charAt(i)));
        }
        System.out.println(userList);


        switch ("1"){
          case "1" :
          case "2" :
          default: break;
        }


        System.out.println(ms.strike(2));
        System.out.println(ms.strike(3));
        System.out.println(ms.ball(1));
        System.out.println(ms.nothing());



      } catch (IllegalArgumentException e) {
        return;



      } // try/catch 종료
    }//while 종료
}//main 종료
}// 클래스 종료