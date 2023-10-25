package io;

public final class StandardPrinter implements Printer {
    public void print(final Renderable renderable) {
        System.out.print(renderable.render());
    }
}
