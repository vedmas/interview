package lesson3;


public class PingPong {

    synchronized void ping() throws InterruptedException {
        System.out.print("ping ");
        notify();
        wait();
    }

    synchronized void pong() throws InterruptedException {
        System.out.println("pong");
        notify();
        wait();
    }

    synchronized public void stop() {
        notify();
    }
}
