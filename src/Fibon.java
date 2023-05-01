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
        long n;
        try {
          /*byte[] buf = new byte[200];
          System.out.print("Enter n: ");
          System.in.read(buf);
          n=new Long(new String(buf).trim()).longValue();*/

            BufferedReader in = new BufferedReader(new FileReader(info.curtask.findFile("Fibon.data")));
            n = new Long(in.readLine()).longValue();
        } catch (IOException e) {e.printStackTrace(); return;}

        int k = 10;
        point[] p = new point[k];
        channel[] c = new channel[k];
        for (int i=0; i<k; i++)
        {
            p[i] = info.createPoint();
            c[i] = p[i].createChannel();
            p[i].execute("Fib");
            c[i].write(n);
            //c[i].write(m);
            //c[i].write(i);
            //c[i].write(k);
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