package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

    private List<Integer> computerNumbers = new ArrayList<Integer>();
    private List<Integer> userNumbers = new ArrayList<Integer>();
    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }

    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        createBaseballNumbers();
    }

    public void createBaseballNumbers(){
        computerNumbers.clear();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) computerNumbers.add(randomNumber);
        }
        inputNumbers();
    }

    public void setUserNumbers(String numbers){
        userNumbers.clear();
        for(int i = 0; i < 3; i++){
            userNumbers.add(Integer.parseInt(String.valueOf(numbers.charAt(i))));
        }
    }

    public void inputNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        String numbers = Console.readLine();
        boolean isErrored = checkError(numbers);
        if(!isErrored) {
            setUserNumbers(numbers);
            checkInputNumbers();
        }
    }

    public void checkInputNumbers(){
        int strikeCount = 0;
        int ballCount = 0;

        for(int i = 0; i < 3; i++){
            if(Objects.equals(computerNumbers.get(i), userNumbers.get(i))) strikeCount++;
            if(!Objects.equals(computerNumbers.get(i), userNumbers.get(i))
                    && computerNumbers.contains(userNumbers.get(i))) ballCount++;
        }
        resultMessage(strikeCount, ballCount);
        checkHomerun(strikeCount);
    }
    public void resultMessage(int strikeCount, int ballCount){
        if(strikeCount > 0 && ballCount == 0) System.out.println(strikeCount+"스트라이크");
        if(ballCount > 0 && strikeCount == 0) System.out.println(ballCount+"볼");
        if(strikeCount > 0 && ballCount > 0) System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
        if(strikeCount == 0 && ballCount == 0) System.out.println("낫싱");
        if(strikeCount == 3) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void checkHomerun(int strikeCount){
        if(strikeCount != 3) inputNumbers();
        if(strikeCount == 3) reStart(Integer.parseInt(Console.readLine()));
    }

    public void reStart(int answer){
        if(answer == 1) createBaseballNumbers();
    }

    public boolean checkError(String numbers) {
        try{
            if(numbers.length() != 3) throw new IllegalArgumentException();
            if(numbers.charAt(0) == numbers.charAt(1)) throw new IllegalArgumentException();
            if(numbers.charAt(0) == numbers.charAt(2)) throw new IllegalArgumentException();
            if(numbers.charAt(1) == numbers.charAt(2)) throw new IllegalArgumentException();
            Integer.parseInt(numbers);
            return false;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return true;
        }
    }
}
