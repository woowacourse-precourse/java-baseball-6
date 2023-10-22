package baseball.common.controller;

import baseball.common.service.CommonNumberService;
import camp.nextstep.edu.missionutils.Console;

public class CommonController {

    public CommonNumberService commonNumberService;

    public CommonController(CommonNumberService commonNumberService){
        this.commonNumberService = commonNumberService;
    }

    //야구 시작 -> 정답 생성
    private void baseballStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    //야구 종료 -> 재시작 or 종료
    private int baseballEnd(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        //1,2번이 입력될 때까지 재귀
        if(!input.equals("1")&&!input.equals("2")) return baseballEnd();

        return Integer.parseInt(input);
    }

    public void baseball(){

        while(true){

            System.out.println("숫자 야구 게임을 시작합니다.");

            while(true){

                System.out.print(commonNumberService.getCount() + "번째 시도입니다! 숫자를 입력해주세요 : ");
                String answer = commonNumberService.isCorrect(Console.readLine());
                System.out.println(answer);
                //3 스트라이크일 경우 break
                if(answer.equals("3스트라이크 ")){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

            while(true){
                String input = Console.readLine();
                //1 입력 시 재시작
                if(input.equals("1")) break;
                else if(input.equals("2")) return;
                else System.out.println("1과 2 중에서 입력하세요");
            }

        }
    }
}
