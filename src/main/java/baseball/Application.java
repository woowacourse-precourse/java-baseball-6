package baseball;

import camp.nextstep.edu.missionutils.Console;

//라이브러리를 다시 읽어보라 https://github.com/woowacourse-precourse/java-baseball-6#%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseBall BB = new BaseBall();

        while(BB.status==1){
            //입력검정 1
            String promp = Console.readLine();
            System.out.print("숫자를 입력해주세요 : ");
            if (promp.length()>3){throw new IllegalArgumentException("입력값이 올바르지 않습니다.");}

            //입력검정 2
            int check = Integer.parseInt(promp);
            System.out.println(check);
            if (check==1){
                BB.setgame();
                continue;
            } else if(check==2){
                BB.status=2;
                System.out.println("게임 종료");
                break;
            }

            
            //게임 카운트
            BB.playgame(promp);
            
            //결과 출력
            if (BB.strike == 0 && BB.ball == 0) {
                System.out.println("낫싱");
            } else if (BB.strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히였습니다! 게임종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            } else if (BB.strike == 0 && BB.ball != 0) {
                System.out.println(BB.ball + "볼");
            } else if (BB.strike != 0 && BB.ball == 0) {
                System.out.println(BB.strike + "스트라이크");
            } else if (BB.strike != 0 && BB.ball != 0) {
                System.out.println(BB.ball + "볼 " + BB.strike + "스트라이크");
            }

        }
    }

}