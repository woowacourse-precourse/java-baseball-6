package controller;

import service.BaseService;
import service.BaseServiceImpl;

public class BaseController {

    private static final BaseService baseService = new BaseServiceImpl();

    /**
     * 전체 게임 기능
     */
    public static void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean start = true;
        while (start){
            // 게임 시작
            baseService.game();

            // 재시작 여부
            start = baseService.isRestart();
        }
    }
}
