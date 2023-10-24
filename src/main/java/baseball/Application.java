package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            //랜덤으로 세 자리 숫자 생성
            String computerInput = new createNumber().getRandomNumber();
            System.out.println(computerInput);

            //사용자 입력 받기
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();
                if(userInput.length() != 3){
                    throw new IllegalArgumentException();
                }

                //컴퓨터가 생성한 숫자와 사용자의 숫자를 비교해 결과 출력
                Baseball baseball = new Baseball();
                if(baseball.play(computerInput, userInput)){
                    System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
                    System.out.println("게임 종료");
                    break;
                }
            }

            //게임 진행여부
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int select  = Integer.parseInt(Console.readLine());
            if(select == 2){
                break;
            }

        }
    }
}
