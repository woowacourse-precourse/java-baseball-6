package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static List<Integer> randomNum() {
		List<Integer> targetNum = new ArrayList<>();
		while (targetNum.size() < 3) {
		    int num = Randoms.pickNumberInRange(1, 9);
		    if (!targetNum.contains(num)) {
		        targetNum.add(num);
		    }
		}
		return targetNum;
	}
    public static Map<String, Integer> compare(List<Integer> targetNum, ArrayList<String> compareNum) {
		Map<String, Integer> result = new LinkedHashMap<String, Integer>();
		
		int strike= 0;
		int ball= 0;
		for(int i= 0; i<3; i++) {
			int temp= Integer.parseInt(compareNum.get(i));
			
			if(targetNum.get(i)== temp){
				strike+=1;
			}else if(targetNum.contains(temp)){
				ball+=1;
			} 
		}
		result.put("볼", ball);
        result.put("스트라이크", strike);
		return result;
	}
    public static void run() {
		List<Integer> targetNum= randomNum();		
		Map<String, Integer> result = new LinkedHashMap<String, Integer>();
		
		do {
			String printStr="";
            System.out.print("숫자를 입력해주세요 : ");
            
            String inputValue=Console.readLine();
            String RECEX="[0-9]+";

            if(inputValue.length()!= 3 || !inputValue.matches(RECEX)){
                throw new IllegalArgumentException();
            }
            ArrayList<String> compareNum= new ArrayList<String>(Arrays.asList(inputValue.split("")));
            result = compare(targetNum, compareNum);
            Set<String> keys= result.keySet();
            for(String key: keys) {
                if(result.get(key)>0) {
                    printStr+= result.get(key)+key+" ";
                }
            }
            if(printStr=="") {
                System.out.println("낫싱");
            }else {
                System.out.println(printStr);
            }
			
		}while(result.get("스트라이크")<3);
		System.out.println("숫자를 모두 맞히셨습니다. 게임 종료");
	}

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int reStart= 1;
		do {
			run();
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            reStart=Integer.parseInt(Console.readLine());
            if (reStart!=1 && reStart!=2 ){
                throw new IllegalArgumentException();
            }
			
		}while(reStart==1);
		System.out.print("프로그램 종료");

    }
}
