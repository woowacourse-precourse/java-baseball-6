package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Check {
    private int strike;
    private int ball;

    public void resultCheck(List<Integer> comp_numbers, List<Integer> user_numbers) {
        strike = 0;
        ball = 0;
        for(int i=0;i<3;i++) {
            int idx = user_numbers.indexOf(comp_numbers.get(i));
            if(idx==i) {
                strike+=1;
            }
            else if(idx!=-1) {
                ball+=1;
            }
        }
        String result = "";
        if(ball!=0) {
            result+=ball+"볼 ";
        }
        if(strike!=0) {
            result+=strike+"스트라이크";
        }
        else if(ball==0) {
            result+="낫싱";
        }
        System.out.println(result);
    }
    
    public boolean endingCheck() {
        if(this.strike==3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public boolean replayCheck() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        if(choice.equals("1")) {
            return true;
        }
        else if(choice.equals("2")) {
            return false;
        }
        else {
            throw new IllegalArgumentException("잘못된 입력을 하였습니다. 프로그램을 종료합니다.");
        }
    }

    public void errorCheck(String[] numbers) {
        if(numbers.length!=3) {
            throw new IllegalArgumentException("잘못된 입력을 하였습니다. 프로그램을 종료합니다.");
        }

        for(int i=0;i<numbers.length;i++) {
            if(numbers[i].equals("0")) {
                throw new IllegalArgumentException("잘못된 입력을 하였습니다. 프로그램을 종료합니다.");
            }
            for(int j=0;j<i;j++)
            {
                if(numbers[i].equals(numbers[j]))
                {
                    throw new IllegalArgumentException("잘못된 입력을 하였습니다. 프로그램을 종료합니다.");
                }
            }
            try {
                Integer.parseInt(numbers[i]);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("잘못된 입력을 하였습니다. 프로그램을 종료합니다.");
            }
        }
    }
}
