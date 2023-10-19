package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGameEnd {
    //TODO: 게임 종료 및 재시작

    public BaseBallGameEnd() {
        BaseBallGameEnd();
    }

    public boolean BaseBallGameEnd() {
        output();
        String playerOrder = input();
        System.out.println("input : " + playerOrder);
        return orderCheck(playerOrder);
    }

    private void output() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private String input(){
        return Console.readLine();
    }

    private boolean orderCheck(String playerOrder){
        if(playerOrder.equals("1")){
            return true;
        }
        else if(playerOrder.equals("2")){
            return false;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}

