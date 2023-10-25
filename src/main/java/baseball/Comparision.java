package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Comparision {
    private List<Integer> result = null;
    Comparision(){
        result = new ArrayList<>();
    }
    public void compare(List<Integer> user,List<Integer> computer){

        int strikeCount = (int) IntStream.range(0, user.size())
                .filter(i -> user.get(i).equals(computer.get(i)))
                .count();

        int ballCount = (int) user.stream()
                .filter(num -> !computer.get(user.indexOf(num)).equals(num))
                .filter(computer::contains)
                .count();

        result.clear();
        result.add(ballCount);
        result.add(strikeCount);
    }
    public void printResult(){
        if(result.get(0)>0){
            System.out.printf("%d볼 ",result.get(0));
        }
        if(result.get(1)>0){
            System.out.printf("%d스트라이크",result.get(1));
        }
        if(result.get(0)==0&&result.get(1)==0){
            System.out.printf("낫싱");
        }
        if(result.get(1)==3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        System.out.println();
    }
    public List<Integer> getResult(){
        return result;
    }
}
