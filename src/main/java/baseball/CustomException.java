package baseball;

import java.util.List;

public class CustomException{
    private static final String REGEX  = "[0-9]+";
    public void checkInputValidation(String s){
        if(s.length() > 3 || !s.matches(REGEX) || checkInputDuplication(s)){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
    public boolean checkInputDuplication(String s){
        CustomView customView = new CustomView();
        List<Integer> list = customView.strToList(s);
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                if(i == j) continue;
                if(list.get(i).equals(list.get(j))) return true;
            }
        }
        return false;
    }
}
