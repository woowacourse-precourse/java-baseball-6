package baseball.service;

import java.util.List;

public class MessageService {
    public void intro(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void menu(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void result(List<Integer> count){
        String message = "";

        if (count.get(0) + count.get(1) == 0){
            message += "낫싱";
        } else if (count.get(0) > 0 && count.get(1) == 0) {
            message += count.get(0) + "볼";
        } else if (count.get(1) > 0 && count.get(0) == 0){
            message += count.get(1) + "스트라이크";
        }else{
            message += count.get(0) + "볼 " + count.get(1) + "스트라이크";
        }
        System.out.println(message);
    }

    public void gameOver(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void inputUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }
}
