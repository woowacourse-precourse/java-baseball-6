package baseball.hard.controller;

import baseball.common.controller.CommonController;

import baseball.hard.service.HardService;

import java.util.concurrent.TimeoutException;

public class HardController extends CommonController {

    //하드 모드 인게임 재귀 함수
    public void hardModeInGameRecursion(HardService hardService) throws TimeoutException {

        //카운트 오버 시 실패
        if(hardService.isCountOver(hardService.getCount())){
            System.out.println("남은 기회를 모두 소진하셨습니다! 게임 종료");
            return;
        }

        System.out.println("하드모드에는 2가지 규칙이 추가 적용됩니다!\n" +
                "1. " + hardService.getCountLimit() + "번 이내에 정답을 맞춰야 합니다! 현재 " +
                (hardService.getCountLimit()-hardService.getCount()+1) + "번의 기회가 남아있습니다!\n" +
                "2. 10초 이내에 정답을 맞춰야 합니다!");

        hardService.setInputStartTime(System.currentTimeMillis());
        beforeInGame(hardService);

        //시간제한이 지났으면 탈락
        if(!hardService.isTimeOver(System.currentTimeMillis())) throw new TimeoutException("제한시간이 초과되었습니다!");

        if(!afterInGame(hardService)) hardModeInGameRecursion(hardService);

        return;

    }
}