import java.io.*;
import parcs.*;

public class Fibon implements AM {

    public static void main(String[] args) {
        task curtask = new task();
        curtask.addJarFile("Fibon.jar");
        (new Fibon()).run(new AMInfo(curtask, (channel)null));
        curtask.end();
    }

    public void run(AMInfo info) {

        int k = 4;
        point[] p = new point[k];
        channel[] c = new channel[k];
        for (int i=0; i<k; i++)
        {
            p[i] = info.createPoint();
            c[i] = p[i].createChannel();
            p[i].execute("Fib");
            c[i].write(i+1);
        }
        
        System.out.println("Waiting for result...");
        long r = 1;
        for (int i=0; i<k; i++)
        {
            r = c[i].readLong();
            System.out.println(r);
        }

        //System.out.println("F"+n+"="+r);
        try{
            PrintWriter out = new PrintWriter(new FileWriter(info.curtask.addPath("Fibon.res")));
            out.println(r);
            out.close();
        } catch (IOException e) {e.printStackTrace(); return;}
    }
}