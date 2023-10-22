package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        run();
//        try {
//            run();
//        } catch(IllegalArgumentException e){
//            System.out.println("잘못된 입력!!!");
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    public static void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer com = new Computer();
        while(true){
            com.init();
            com.play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int gameContinue = Integer.parseInt(Console.readLine());
            if(gameContinue==1) continue;
            else if(gameContinue==2) break;
            throw new IllegalArgumentException();
        }
    }
}
