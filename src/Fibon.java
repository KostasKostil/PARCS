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
      long n, m;
      try {
          /*byte[] buf = new byte[200];
          System.out.print("Enter n: ");
          System.in.read(buf);
          n=new Long(new String(buf).trim()).longValue();*/

          BufferedReader in = new BufferedReader(new FileReader(info.curtask.findFile("Fibon.data")));
          n = new Long(in.readLine()).longValue();
          m = new Long(in.readLine()).longValue();
      } catch (IOException e) {e.printStackTrace(); return;}

      point[] p = new point[10];
      channel[] c = new channel[10];
      for (int i=0; i<10; i++)
      {
          p[i] = info.createPoint();
          c[i] = p[i].createChannel();
          p[i].execute("Fib");
          c[i].write(n);
          c[i].write(i);
          System.out.println("x...");
      }

      point p1 = info.createPoint();
      channel c1 = p1.createChannel();
      p1.execute("Fib");
      c1.write(n);
      c1.write(m);

      System.out.println("Waiting for result...");
      long r = c1.readLong();
      System.out.println("Result found.");

      //System.out.println("F"+n+"="+r);
      try{
          PrintWriter out = new PrintWriter(new FileWriter(info.curtask.addPath("Fibon.res")));
          out.println(r);
          out.close();
      } catch (IOException e) {e.printStackTrace(); return;}
    }
}
