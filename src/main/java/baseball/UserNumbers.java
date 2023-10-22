package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserNumbers {

    private List<Integer> userNumbers = new ArrayList<Integer>();

    public UserNumbers(String userNumbers){
        if(checkError(userNumbers)) throw new IllegalArgumentException();
        if(!checkError(userNumbers)){
            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(String.valueOf(userNumbers.charAt(0))));
            list.add(Integer.parseInt(String.valueOf(userNumbers.charAt(1))));
            list.add(Integer.parseInt(String.valueOf(userNumbers.charAt(2))));
            this.userNumbers = list;
        }
    }

    public List<Integer> getList(){
        return this.userNumbers;
    }

    public boolean checkError(String userNumbers) {
        try{
            if(!validateNumbers(userNumbers)) throw new IllegalArgumentException();
            Integer.parseInt(userNumbers);
            return false;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return true;
        }
    }
    public boolean validateNumbers(String userNumbers){
        if(userNumbers == null || userNumbers.isEmpty()) return false;
        if(userNumbers.length() != 3) return false;
        if(userNumbers.charAt(0) == userNumbers.charAt(1)) return false;
        if(userNumbers.charAt(0) == userNumbers.charAt(2)) return false;
        return userNumbers.charAt(1) != userNumbers.charAt(2);
    }

}
