package baseball;
public class MsgService {
  public MsgService(){}
  private String msg;
  public String starMSG(){return "숫자 야구 게임을 시작합니다.";}
  public String nothing(int count){ msg = count + "낫싱"; return msg;}
  public String ball(int ball){ msg = ball + "볼"; return msg;}
  public String strike(int strike){
    msg = strike + "스트라이크";
    if(strike == 3) msg = strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    return msg;
  }






}
