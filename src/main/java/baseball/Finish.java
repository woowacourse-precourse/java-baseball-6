package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Finish {

    public int finish(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료" +
                "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String finish = Console.readLine();
        int fin = Integer.parseInt(finish);
        if(!(fin == 1 || fin == 2)){
            throw new IllegalArgumentException("잘못된 형식의 값을 입력하셨습니다.");
        }
        return fin;
    }
}
