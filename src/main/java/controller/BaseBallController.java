package controller;

import baseball.메세지생성;
import baseball.숫자맞춤검사;
import camp.nextstep.edu.missionutils.Console;
import view.InputView;
import view.OutputView;

import java.util.List;

public class BaseBallController {
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();
    private static final String RESTART = "1";
    private static final int THREESTRIKE = 3;
    public static void gameStart(){

        outputView.gameStartMessage();
        //플레이어가 선택한 세가지 번호
        String playerThreeNumber = inputView.pickThreeNumber();
        if()
      /*  상대방숫자생성 computerNum = new 상대방숫자생성(3,1,9);
        게임진행(computerNum.랜덤숫자생성());*/
    }
    public static void 게임진행(List<Integer> cpNumList){

        boolean flag = false;

        숫자맞춤검사 correctNum = new 숫자맞춤검사(cpNumList);

        while(!flag){

            int 스트라이크 = 0;
            int 볼 = 0;

            System.out.print("숫자를 입력해주세요 : ");
            String 내가입력한숫자 = Console.readLine();

            스트라이크 = correctNum.스트라이크개수(내가입력한숫자);
            볼 = correctNum.볼개수(내가입력한숫자);

            메세지생성 messagePrint = new 메세지생성(스트라이크,볼);

            System.out.print(messagePrint.메세지입력());

            if(스트라이크 == THREESTRIKE){

                flag = true;

                System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String 게임진행여부 = Console.readLine();

                if(게임진행여부.equals(RESTART)){

                    게임시작();
                }
            }
        }
    }
}
