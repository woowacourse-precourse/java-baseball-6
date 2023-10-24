package baseball;

import java.util.ArrayList;
import java.util.List;

public final class BaseballController {

  private static BaseballService bs = new BaseballService();
  private static MsgService ms = new MsgService();
  private static UserChatService ucs = new UserChatService();


  public BaseballController() {
  }

  public void GameStart() {

    System.out.println(ms.starMSG());
    List<String> computer = bs.createComList();
    outLoop:
    while (true) {
      try {
        // 채팅 받고 예외 터트림
        String input = ucs.inputChat();
        if (input.equals("No")) {
          throw new IllegalArgumentException();
        }

        // 디버깅 코드 남겨둠 - Test용
        // 포비븨 리스트 생성
        System.out.println(computer);
        // 유저 리스트
        List<String> user = bs.createUserList(input);
        System.out.println(user);
        // 두가지 리스트를 믹스하면 경기 결과를 알려줌
        BallCountVO ballCountAll
            = bs.createBallCountAll(computer, user);

        // 경기 결과를 출력해줌
        ucs.resultGameCount(ballCountAll);

        if(ballCountAll.getStrike() == 3) {
          // 선택해서 결과값으로 재선택
          String newGameCheck = ucs.stringCaseNumber();
          switch (newGameCheck) {
            case "1":
              computer.clear();
              computer = bs.createComList();
              continue outLoop;
            case "2":
              return;
            default:
              return;
          }
        }
      } catch (IllegalArgumentException e) {
        return;
      }
    }}}