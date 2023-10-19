package baseball;

import camp.nextstep.edu.missionutils.Console;
import service.BaseService;
import service.BaseServiceImpl;

public class Application {

    private static final BaseService service = new BaseServiceImpl();

    /**
     * 전체 게임 기능
     */
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean start = true;
        while (start){
            service.game();
            start = service.isRestart(); // RESTART = true, EXIT = false;
        }

    }


}
