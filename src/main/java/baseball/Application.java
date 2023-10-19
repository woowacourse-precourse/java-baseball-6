package baseball;

import baseball.Randomgenerator.Randomgenerator;
import baseball.Randomgenerator.Ranomgenerator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean game = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        //랜덤 값 생성
        Randomgenerator ran = new Ranomgenerator();
        String answer = ran.getRandom();

        do{
            System.out.print("숫자를 입력해주세요 : ");
            String q = Console.readLine();
        }while(game);

    }
}
