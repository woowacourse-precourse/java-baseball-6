package model;

public class Computer {
    private char[] selectComputers;

    public Computer(char[] selectComputers) {
        try {
            this.selectComputers = selectComputers;
        }
        catch (NullPointerException e) {
            throw new NullPointerException("Exception occur Computer Class: NullPointerException");
        }
    }

    public char[] getterSelectComputerNum() {
        return selectComputers.clone();
    }
}
