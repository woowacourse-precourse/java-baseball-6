package baseball;

import camp.nextstep.edu.missionutils.Console;
public class UserNum {
    int n1,n2,n3;

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN1() {
        return n1;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getN2() {
        return n2;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    public int getN3() {
        return n3;
    }

    public void getUserNum(){
        System.out.println("숫자를 입력해주세요 :");
        String userinput = Console.readLine();

        try {
            if (!checkInput(userinput)) {
                throw new IllegalArgumentException("input error");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("input error");
        }

        String[] array = userinput.split("");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        int c = Integer.parseInt(array[2]);
        setN1(a);
        setN2(b);
        setN3(c);
    }
    public boolean checkInput(String i_str){
        if(i_str.length() ==3){
            String[] array = i_str.split("");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);
            int c = Integer.parseInt(array[2]);

            if((a<1) ||(a>9)){return false;}
            if((b<1) ||(b>9)){return false;}
            if((c<1) ||(c>9)){return false;}

            if((a!=b) & (b!=c) & (c!=a)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }


}
