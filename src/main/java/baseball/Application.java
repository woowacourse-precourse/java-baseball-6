package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

    private ComputerNumbers computerNumbers;
    private UserNumbers userNumbers;

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }

    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        createBaseballNumbers();
    }

    public void createBaseballNumbers(){
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) list.add(randomNumber);
        }
        computerNumbers = new ComputerNumbers(list);
        inputNumbers();
    }

    public void inputNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        String numbers = Console.readLine();
        userNumbers = new UserNumbers(numbers);
        checkInputNumbers();
    }

    public void checkInputNumbers(){
        int strikeCount = 0;
        int ballCount = 0;

        List<Integer> computerList = computerNumbers.getList();
        List<Integer> userList = userNumbers.getList();

        for(int i = 0; i < 3; i++){
            if(Objects.equals(computerList.get(i), userList.get(i))) strikeCount++;
            if(!Objects.equals(computerList.get(i), userList.get(i)) && computerList.contains(userList.get(i))) ballCount++;
        }
        resultMessage(strikeCount, ballCount);
        checkHomerun(strikeCount);
    }
    public void resultMessage(int strikeCount, int ballCount){
        if(strikeCount > 0 && ballCount == 0) System.out.println(strikeCount+"스트라이크");
        if(ballCount > 0 && strikeCount == 0) System.out.println(ballCount+"볼");
        if(strikeCount > 0 && ballCount > 0) System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
        if(strikeCount == 0 && ballCount == 0) System.out.println("낫싱");
        if(strikeCount == 3) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void checkHomerun(int strikeCount){
        if(strikeCount != 3) inputNumbers();
        if(strikeCount == 3) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            reStart(Console.readLine());
        }
    }

    public void reStart(String answer){
        try {
            if(!reStartValidate(answer)) throw new IllegalArgumentException();
            int result = Integer.parseInt(answer);
            if(result == 1) createBaseballNumbers();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    public boolean reStartValidate(String answer){
        if(answer == null || answer.isEmpty()) return false;
        return answer.length() == 1;
    }
}

