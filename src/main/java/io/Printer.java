package io;

public final class Printer {
    public void print(final Renderable renderable) {
        System.out.print(renderable.renderToString());
    }
}
