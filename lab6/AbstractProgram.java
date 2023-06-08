package lab6;

import java.util.concurrent.ThreadLocalRandom;

public class AbstractProgram implements Runnable{
    private ProgramState state = ProgramState.UNKNOWN;

    @Override
    public void run() {
        Thread daemon = new Thread(() -> {
            while (true) {
                synchronized (this) {
                    this.notify();
                    try {
                        this.wait();
                        int randomState = ThreadLocalRandom.current().nextInt(1, 4);
                        state = ProgramState.values()[randomState];
                        System.out.println("Change state to: " + state);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        daemon.setDaemon(true);
        daemon.start();

        while (!Thread.currentThread().isInterrupted()) {
            doSmth();
        }
    }

    public ProgramState getState() {
        return state;
    }

    public void doSmth() {

    }

}
