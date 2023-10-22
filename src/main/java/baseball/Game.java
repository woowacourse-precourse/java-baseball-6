package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> computer = new ArrayList<>();
    List<Integer> user = new ArrayList<>();
    String isContinue = "1";
    String input;
    String output;
    int ball, strike;
    int i, j;
    int n;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        //4. 게임 시작, 종료를 위한 숫자 입력 받기
        while (isContinue.equals("1")) {
            setComputerNumber();
            inputUserNumbers();
        }
    }

    //1. 랜덤한 3개의 수 생성 하기
    public void setComputerNumber() {
        computer.clear();
        while (computer.size() < 3) {
            n = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(n))
                computer.add(n);
        }
        System.out.println("컴퓨터 숫자 확인용: " + computer);
    }

    //2. 사용자 값 입력 받기(같을 때까지)
    public void inputUserNumbers() {
        while (!computer.equals(user)) {
            inputLine();
            printBallNStrike();
        }
        checkEnd();
    }

    public void inputLine() {
        user.clear();

        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();

        //+) 입력값 예외처리
        if (checkExeption(input, 3))
            throw new IllegalArgumentException();

        for (i = 0; i < 3; i++) {
            user.add((Integer) (input.charAt(i) - '0'));
        }
    }

    void printBallNStrike() {
        //3. 볼의 개수, 스트라이크 개수 출력 하기
        output = "";
        ball = 0;
        strike = 0;
        for (i = 0; i < 3; i++) {
            if (computer.contains(user.get(i))) {
                if (computer.get(i).equals(user.get(i)))
                    strike++;
                else
                    ball++;
            }
        }
        if (ball == 0 && strike == 0)
            output += "낫싱";
        else {
            if (ball >= 1)
                output += ball + "볼";
            if (ball >= 1 && strike >= 1)
                output += " ";
            if (strike >= 1)
                output += strike + "스트라이크";

            if (strike == 3)
                output += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        System.out.println(output);
    }

    public void checkEnd(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        isContinue = Console.readLine();

        //+) 입력값 예외처리
        if (checkExeption(isContinue, 1))
            throw new IllegalArgumentException();
    }
    public boolean checkExeption(String s, int n) {
        //길이 체크(공통)
        if(s.length() != n)
            return true;
        //문자 유무 체크(공통)
        for(int i = 0; i < n; i++)
            if(!Character.isDigit(s.charAt(i)))
                return true;

        //1 또는 2의 수(n이 1일 경우)
        if(n == 1)
            if(!(s.equals("1") || s.equals("2")))
                return true;

        //서로 다른 3자리의 수(n이 3일 경우)
        for(int i = 0; i < n; i++)
            for(int j = i + 1; j < n; j++)
                if(s.charAt(i) == s.charAt(j))
                    return true;

        return false;
    }
}
