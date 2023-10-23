package baseball.easy.controller;

import baseball.common.controller.CommonController;
import baseball.easy.service.EasyService;
import camp.nextstep.edu.missionutils.Console;

public class EasyController extends CommonController {

    //초보 모드 인게임 재귀 함수
    public void easyModeInGameInRecursion(EasyService easyService){

        if(yesNoInReqursion(easyService).equals("y")) {
            System.out.println((easyService.getHintCount() + 1) + "번째 숫자는" +
                    easyService.hintWithPossibleNumber() + "입니다!");
            easyService.plusHintCount();
        }

        beforeInGame(easyService);

        if(!afterInGame(easyService)) easyModeInGameInRecursion(easyService);

        //힌트 카운트 초기화
        easyService.resetHintCount();
        return;
    }


    //yes no 재귀함수
    private String yesNoInReqursion(EasyService easyService){

        //
        if(easyService.getHintCount()==easyService.getNumberLength()){
            System.out.println("더 이상의 힌트를 받으실 수 없습니다!");
            return "n";
        }
        System.out.println((easyService.getHintCount()+1) + "번째 힌트를 제공해드릴까요?" +
                "\ny:n으로 대답해주세요!");
        String input = Console.readLine();

        if(!input.equals("y")&&!input.equals("n")) return yesNoInReqursion(easyService);
        return input;
    }
}
