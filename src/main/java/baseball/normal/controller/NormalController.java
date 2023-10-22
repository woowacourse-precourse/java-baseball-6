package baseball.normal.controller;

import baseball.common.controller.CommonController;
import baseball.normal.service.NormalService;

public class NormalController extends CommonController {

    //노말 모드 인게임 재귀 함수
    public void normalModeInGameInRecursion(NormalService normalService){

        beforeInGame(normalService);
        if(!afterInGame(normalService)) normalModeInGameInRecursion(normalService);

        return;
    }
}