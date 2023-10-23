package io;

public class SoutBaesdPrompt implements Prompt {
    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }
}