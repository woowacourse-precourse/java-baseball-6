package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer{
    public String pickNumber(){
        String computer = "";
        while (computer.length() < 3) {
            String randomNumber = "" + Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer += randomNumber;
            }
        }
        return computer;
    }


    public static String check(String query, String answer){

        List<Character> answerList = convertStringToList(answer);
        List<Character> queryList =  convertStringToList(query);

        int strikes = 0;
        int balls = 0;

        for(int i = 0; i < answer.length(); i++){
            char answerValue = answerList.get(i);
            char queryValue = queryList.get(i);


            // Strike인 경우
            if(strikeCheck(answerValue, queryValue)) strikes += 1;

            // ball 인 경우
            else if (ballCheck(answer, queryValue)) balls += 1;
        }

        if(strikes == 0 && balls == 0){
            return "낫싱";
        }
        else if (strikes == 0){
            return Integer.toString(balls) + "볼";
        }

        else if (balls == 0){
            return Integer.toString(strikes) + "스트라이크";
        }

        else{
            return Integer.toString(balls) + "볼 " + Integer.toString(strikes)+"스트라이크";
        }
    }

    public static boolean strikeCheck(char answerValue, char queryValue){
        if(answerValue == queryValue) return true;
        else return false;
    }

    public static boolean ballCheck(String answer, char queryValue){
        String queryString = String.valueOf(queryValue);
        if(answer.contains(queryString)) return true;
        else return false;
    }
    public static List<Character> convertStringToList(String query){
        List<Character> resultList = new ArrayList<>();

        for (int i = 0; i < query.length(); i++){
            char digitChar = query.charAt(i);
            resultList.add(digitChar);
        }

        return resultList;
    }

}