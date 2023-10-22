package baseball;

import baseball.makerandomnumber.Randomgenerator;
import baseball.check.Checknum;
import baseball.distinguishnumber.Distinguish;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();

        Distinguish distinguish = appConfig.distinguish();
        Checknum checknum = appConfig.checknum();
        Randomgenerator randomgenerator = appConfig.randomgenerator();

        //랜덤 값 생성
        //인터페이스 활용 appconfig로 설정하는 걸로 마무리
        List<Integer> answer = randomgenerator.getRandom();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(!answer.isEmpty()){
            System.out.print("숫자를 입력해주세요 : ");
            String userNum = Console.readLine();

            //입력값에 대한 판단
            Checking(checknum, userNum);

            String resultSentence = distinguish.distinguish(answer, makeUserNumberList(userNum));
            System.out.println(resultSentence);

            if(resultSentence.equals("3스트라이크")){
                answer = printEnd(randomgenerator, answer);
            }
        }

    }

    static private boolean Checking(Checknum checknum, String num){
        return checknum.checkIsNum(num) && checknum.checkIsThreeDigit(num) && checknum.checkIsDuplicate(num);
    }

    static private List<Integer> makeUserNumberList(String user){
        List<Integer> userNumbers = new ArrayList<>();
        for(char num : user.toCharArray()){
            int userNum = num - '0';
            userNumbers.add(userNum);
        }
        return userNumbers;
    }

    static private boolean restart(String res){
        return Integer.parseInt(res) == 1;
    }

    static private List<Integer> printEnd(Randomgenerator randomgenerator,List<Integer> answer){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String res = Console.readLine();

        answer = restart(res) ? randomgenerator.getRandom() : new ArrayList<>();
        return answer;
    }
}
