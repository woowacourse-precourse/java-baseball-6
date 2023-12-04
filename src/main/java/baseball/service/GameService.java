package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameService {
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    Map<String,Integer> results;
    public GameService(){
        results = new HashMap<>();
    }
    public List<Integer> numberConverter(String numbers){ // 사용자 숫자 생성
        List<Integer> intNumbers = new ArrayList<>();
        for(int i=0; i<numbers.length();i++){
            int num = Character.getNumericValue(numbers.charAt(i));
            if(intNumbers.contains(num)){ //중복된 값이 있으면, 에를들어 222 와 같은 형태
                throw new IllegalArgumentException("[ERROR] 숫자는 서로 중복되지 않아야 합니다.");
            }
            intNumbers.add(num);
        }
        return intNumbers;
    }
    public Map<String,Integer> compareNumbers(List<Integer> users, List<Integer> computers){
        for(int i=0; i<computers.size(); i++){
            for(int j=0; j<users.size(); j++){
                if(computers.get(i).equals(users.get(j)) && i==j){
                    putResult(results,STRIKE);
                }
                if(computers.get(i).equals(users.get(j)) && i!=j){
                    putResult(results,BALL);
                }
            }
        }
        putExtraValue(results);
        return this.results;
    }
    private void putExtraValue(Map<String, Integer> results) {
        if(results.containsKey(STRIKE) && !results.containsKey(BALL)){
            results.put(BALL,0);
        }
        if(!results.containsKey(STRIKE) && results.containsKey(BALL)){
            results.put(STRIKE,0);
        }
        if(!results.containsKey(STRIKE) && !results.containsKey(BALL)){
            results.put(STRIKE,0);
            results.put(BALL,0);
        }
    }
    private void putResult(Map<String, Integer> results, String value) {
        if(results.containsKey(value)) {
            int count = results.get(value);
            results.put(value,count+1);
        }
        if(!results.containsKey(value)){
            results.put(value,1);
        }
    }
    public List<Integer> putComputerNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) { //만약 컴퓨터 배열의 크기가 3이상이 아니면,
            int randomNum = Randoms.pickNumberInRange(1, 9); //랜덤 넘버를 뽑는다.
            if (!numbers.contains(randomNum)) { //만약 뽑힌 랜덤넘버가 컴퓨터 리스트 안에 없으면,
                numbers.add(randomNum); //랜덤 넘버를 집어넣는다.
            }
        }
        return numbers;
    }
}
