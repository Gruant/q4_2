package ru.antongrutsin.hw_3;

import java.util.concurrent.Phaser;

public class PingPong {
    static final Phaser p = new Phaser(1);
    public static void main(String[] args) {
        t("ping");
        t("pong");
    }
    private static void t(final String msg) {
        new Thread(() -> {
            while (true) {
                System.out.println(msg);
                p.awaitAdvance(p.arrive()+1);
            }
        }).start();
    }
}
