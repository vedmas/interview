package lesson3;


public class Main {
    public static void main(String[] args) {
        play(10);
        count(10);
    }

    public static void play(int count) {
        PingPong pingPong = new PingPong();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                try {
                    pingPong.ping();
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            pingPong.stop();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                try {
                    pingPong.pong();
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            pingPong.stop();
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void count(int count) {

        MyLock myLock = new MyLock();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                myLock.add(1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                myLock.add(1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myLock.getCounter());
    }
}
