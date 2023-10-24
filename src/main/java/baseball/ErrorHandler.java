package baseball;

import java.util.List;

public class ErrorHandler {
    public void checkPlayerNumber(List<Integer> userNumber){
        if(userNumber.size() != 3){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        else{
            for(int i = 0; i<3; i++){
                if(userNumber.get(i) < 1 || userNumber.get(i) > 9){
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            }
        }
    }

    public void checkReGame(String reGame){
        if(!reGame.equals("1") && !reGame.equals("2")){
            throw new IllegalArgumentException("잘못된 입력입니다.\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
