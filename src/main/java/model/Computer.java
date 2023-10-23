package model;

public class Computer {
    private char[] selectComputers;

    public Computer(char[] selectComputers) {
        this.selectComputers = selectComputers;
    }

    public char[] getterSelectComputerNum() {
        return selectComputers.clone();
    }
}
