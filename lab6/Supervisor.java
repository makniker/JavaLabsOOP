package lab6;

public class Supervisor implements Runnable{
    private final AbstractProgram program;
    private final Thread executableThread;
    Supervisor(AbstractProgram program) {
        this.program = program;
        executableThread = new Thread(this.program);
    }

    @Override
    public void run() {
        executableThread.start();
        synchronized (program) {
            while (!Thread.interrupted() || executableThread.isInterrupted()) {
                try {
                    program.wait();
                    responseToStateChange(program.getState());
                    program.notify();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Supervisor: FATAL ERROR -> abstract program finished performance");
                    break;
                }
            }
        }
    }

    private void responseToStateChange(ProgramState state) throws InterruptedException {
        switch (state) {
            case FATAL_ERROR -> {
                executableThread.interrupt();
                throw new InterruptedException("Msg");
            }
            case STOPPING -> restartProgram();
            default -> System.out.println("Supervisor: state of abstract program is " + state);
        }
    }

    public void restartProgram() {
        System.out.println("Supervisor: STOPPING -> restart program.");
    }
}
