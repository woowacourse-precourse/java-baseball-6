package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    static final int MAX_NUM =3;
    List<Integer> numList;
    Set<Integer> numSet;
    public Game(){
        System.out.println("숫자 야구 게임을 시작합니다");
    }
    int[] convert(String line) throws IllegalArgumentException{
        if(line.length()!= MAX_NUM) throw new IllegalArgumentException("3개의 숫자를 입력해 주세요");
        int[] arr = new int[MAX_NUM];
        int cnt=0;
        for(char c: line.toCharArray()){
            if(c<'1' || c>'9') throw new IllegalArgumentException();
            arr[cnt++]=c-'0';
        }
        if(arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[0])
            throw new IllegalArgumentException("입력은 서로 다른 숫자 3개입니다");
        return arr;
    }
    String getResultPrompt(int ballCount, int strikeCount){
        StringBuilder out = new StringBuilder();
        if(ballCount==0 && strikeCount==0){
            out.append("낫싱");
        }
        else{
            if(ballCount>0) out.append(ballCount).append("볼").append(' ');
            if(strikeCount>0) out.append(strikeCount).append("스트라이크");
        }
        return out.toString();
    }
    boolean userTry(String inputLine){
        int[] input = convert(inputLine);
        int ballCount = 0, strikeCount = 0;
        for (int i = 0; i < MAX_NUM; i++) {
            int num = input[i];
            if (numSet.contains(num)) {
                if (num == numList.get(i)) {
                    strikeCount++;
                } else {
                    ballCount++;
                }
            }
        }
        String resultPrompt = getResultPrompt(ballCount, strikeCount);
        System.out.println(resultPrompt);
        if(strikeCount== MAX_NUM){
            System.out.println(MAX_NUM +"개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else return false;
    }
    void start(){
        numList = Randoms.pickUniqueNumbersInRange(1,9,3);
        numSet = new HashSet<>(numList);
        boolean isSuccessful = false;
        while(!isSuccessful) {
            System.out.print("숫자를 입력해주세요 : ");
            isSuccessful = userTry(Console.readLine());
        }
    }
    boolean askFinish(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputLine = Console.readLine();
        try{
            int inputNum = Integer.parseInt(inputLine);
            if(inputNum == 1){
                return false;
            }
            else if(inputNum == 2){
                return true;
            }
            else{
                throw new IllegalArgumentException();
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
