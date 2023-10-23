package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallService {
  private final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다";
  private final String ENTER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
  private int strike_cnt = 0;
  private int ball_cnt = 0;
  List<Integer> com = new ArrayList<>();
  public void exec() {
    com = createComNums();
    System.out.println(START_GAME_MESSAGE);
    com.stream().forEach(System.out::println);
    do{
      System.out.printf(ENTER_INPUT_MESSAGE);
      List<Integer> user = createUserNums();
      strike_cnt = 0;
      ball_cnt = 0;
      for(int i = 0; i < com.size(); i++) {
        if(user.contains(com.get(i)) && user.get(i) == com.get(i)){
          strike_cnt++;
        } else if (user.contains(com.get(i)) && user.get(i) != com.get(i)) {
          ball_cnt++;
        }
      }
      System.out.println(String.format("%d스트라이크 %d볼", strike_cnt, ball_cnt));
    }while(strike_cnt != 3);
  }
  List<Integer> createComNums(){
    return Randoms.pickUniqueNumbersInRange(1,9,3);
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
