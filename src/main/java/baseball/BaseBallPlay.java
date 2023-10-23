package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseBallPlay {
  private final String ENTER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
  private Strike strike;
  private Ball ball;
  private UserNums userNums ;
  public int play(ComNums comNums){
    System.out.println(ENTER_INPUT_MESSAGE);
    this.userNums = new UserNums(createUserNums());
    this.strike = new Strike(0);
    this.ball = new Ball(0);
    for(int i = 0; i < comNums.size(); i++) {
      if(userNums.contains(comNums.get(i)) && userNums.get(i) == comNums.get(i)){
        strike.increase();
      } else if (userNums.contains(comNums.get(i)) && userNums.get(i) != comNums.get(i)) {
        ball.increase();
      }
    }
    if(ball.getCount() == 0 && strike.getCount() == 0){
      System.out.println("낫싱");
    } else if (ball.getCount() == 0) {
      System.out.println(String.format("%d스트라이크", strike.getCount()));
    } else if (strike.getCount() == 0) {
      System.out.println(String.format("%d볼", ball.getCount()));
    } else if (ball.getCount() != 0 && strike.getCount() != 0) {
      System.out.println(String.format("%d볼 %d스트라이크", ball.getCount(), strike.getCount()));
    }
    return strike.getCount();
  }
  List<Integer> createUserNums(){
    List<String> user_str_list = List.of(Console.readLine().split(""));
    int num = 0;
    if(user_str_list.size() != 3){
      throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
    }
    List<Integer> user_int_list = new ArrayList<>();
    for(String str : user_str_list){
      if(str.equals("0")){
        throw new IllegalArgumentException("1 ~ 9 값을 입력해주세요");
      }
      try{
        num = Integer.parseInt(str);
      }catch (NumberFormatException e){
        throw new IllegalArgumentException("숫자만 입력해주세요.");
      }
      if(user_int_list.contains(num)){
        throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력해주세요.");
      }else{
        user_int_list.add(num);
      }
    }
    return user_int_list;
  }
}
