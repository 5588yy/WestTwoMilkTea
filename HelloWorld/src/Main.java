import java.util.Scanner;

class HelloWorld {
    private int n;
    public static int i,j;

    public HelloWorld( int n){
        this.n = n;
    }

    public void p()
    {
        System.out.println(n+" "+i+" "+j);
    }

    public synchronized void hello() throws InterruptedException{
        for (i = 0; i < n; i++) {
            while(i!=j)
            {
                //System.out.println('\n'+"first stop");
                //this.p();
               this.wait();
            }
            System.out.print("Hello");
            this.notify();
        }
    }

    public synchronized void world() throws InterruptedException{
        for (j = 0; j < n; j++) {
            while(i!=j+1)
            {
                //System.out.println('\n'+"first stop");
                //this.p();
                this.wait();
            }
            System.out.println("World!");
            this.notify();
        }
    }

}

class PrintWorld implements Runnable{
    HelloWorld helloWorld;
    public PrintWorld(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run(){
        try {
            helloWorld.world();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrintHello implements Runnable {
    HelloWorld helloWorld;
    public PrintHello(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run() {
        try {
            helloWorld.hello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HelloWorld helloWorld = new HelloWorld(n);
        PrintHello printHello = new PrintHello(helloWorld);
        PrintWorld printWorld = new PrintWorld(helloWorld);
        new Thread(printHello).start();
        new Thread(printWorld).start();
    }
}

