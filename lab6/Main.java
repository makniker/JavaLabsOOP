package lab6;

public class Main {
        public static void main(String[] args) {
            AbstractProgram abstractProgram = new AbstractProgram();
            Supervisor supervisor = new Supervisor(abstractProgram);
            new Thread(supervisor).start();
        }
    }