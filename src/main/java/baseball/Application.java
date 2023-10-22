package baseball;
import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;



public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        gameController.StartGame();

        // 컴퓨터 랜덤 수 뽑기
        /*List<Integer> computerNumberList = new ArrayList<>();
        while(computerNumberList.size()<3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }

        int i;

        System.out.println(computerNumberList);

        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        List<Integer> splitUserInput = new ArrayList<>();


        if(userInput.length()!=3) {
            throw new IllegalStateException("3글자 아님");
        }

        int j=0;
        for(j=0; j<userInput.length(); j++) {
            try {
                int num = Integer.parseInt(userInput.substring(j, j+1));
                splitUserInput.add(num);
            } catch (IllegalStateException e) {
            }
            }


        System.out.println(splitUserInput);
        List<Integer> duplicateNumberCheckList = new ArrayList<>();
        for(i=0; i<splitUserInput.size(); i++) {
            if (duplicateNumberCheckList.contains(splitUserInput.get(i))) {
                throw new IllegalStateException("숫자 중복임");
            } else {
                duplicateNumberCheckList.add(splitUserInput.get(i));
            }
        }


        int ball=0;
        int strike=0;

        for(i=0; i<splitUserInput.size(); i++) {
            if (computerNumberList.contains(splitUserInput.get(i))) {
                if (computerNumberList.get(i).equals(splitUserInput.get(i))) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }


        // ball, strike 결과 출력
        if(ball==0 && strike==0) {
            System.out.println("낫싱");
        } else if (ball==0 && strike!=0) {
            System.out.println(strike+"스트라이크");
        } else if (ball!=0 && strike==0) {
            System.out.println(ball+"볼");
        } else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }


        if(strike==3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput2 = Console.readLine();
        }*/

    }
}
