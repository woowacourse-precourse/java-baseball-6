package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballService {

  private static  ComPuTaService com = new ComPuTaService();
  private static UserChatService ucs = new UserChatService();

  public BaseballService(){}

  public List<String> createComList(){
    ComPuTaVO poBV = com.cOm();
    List<String> list = new ArrayList<>();
    list.add(poBV.getOneValue());
    list.add(poBV.getTwoValue());
    list.add(poBV.getThreeValue());
    return list;
  }

  public List<String> createUserList(String input){
    List<String> list = new ArrayList<>();
    for(int i = 0; i < input.length(); i++){
      list.add(String.valueOf(input.charAt(i)));
    }
    return list;
  }

  public BallCountVO createBallCountAll(List<String> list,List<String>userList){
    int strike = 0;
    int ball = 0;
    int count = 0;
    for(int i = 0; i <= 2; i++){
      for(int j = 0; j <= 2; j++){
        if     (list.get(i).equals(userList.get(i))) {strike++; break;}
        else if(list.get(i).equals(userList.get(j))) {ball++; break;}
        else                                         {count++;}
      }
    }
    BallCountVO row = new BallCountVO();
    row.setStrike(strike);
    row.setBall(ball);
    row.setCount(count);
    return row;
  }







}
