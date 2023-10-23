package baseball;

import baseball.object.Computer;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        List<Integer> computerNum = computer.makeRandomNumbers();

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String userNum = readLine();

        List<Integer> userNumList;
        String resultContent = "";
        while (true) {
            userNumList = computer.checkUserNum(userNum); // 맞는 숫자인지 확인
            int [] result = computer.ismatch(computerNum, userNumList);
            if (result[1] == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                userNum = readLine();
                if (computer.checkTryAgain(userNum)) {
                    computerNum = computer.makeRandomNumbers();
                    System.out.print("숫자를 입력해주세요 : ");
                    userNum = readLine();
                }else {
                    return;
                }
            }
            else {
                if (result[0]!= 0) {
                    resultContent += result[0] +"볼 ";
                }
                if (result[1]!=0) {
                    resultContent += result[1] + "스트라이크";
                }
                if (result[2]!=0) {
                    resultContent = "낫싱";
                }
                System.out.println(resultContent);
                resultContent="";
                System.out.print("숫자를 입력해주세요 : ");
                userNum = readLine();
            }

        }

    }
}
