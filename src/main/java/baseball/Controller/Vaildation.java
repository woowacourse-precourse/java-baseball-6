package baseball.Controller;

public class Vaildation {
    public void exption(String userData){
        try{
            int number = Integer.parseInt(userData);
            if (userData.length() != 3){
                throw new IllegalAccessException();
            }
            if (check(number)){
                throw new IllegalAccessException();
            }
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    public boolean check(int number){
        int one = number % 10;
        int ten = (number/10) % 10;
        int hundred = (number/100) % 10;
        boolean chk = true;

        if (one != ten && one != hundred && ten != hundred 
                && one != 0 && ten != 0 && hundred != 0){
            chk = false;
        }
        return chk;
    }
}
