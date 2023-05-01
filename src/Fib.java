import parcs.*;

public class Fib implements AM{
    public void run(AMInfo info){
        long n,m,i0,k,r;

        n = 8;
        m = 1000;
        k = 4;

        System.out.println("entering run");
        i0 = info.parent.readLong();
        System.out.println(i0 + "th thread");

        r = 1;
        for (long i=i0; i<=n; i+=k)
        {
            r = r*i%m;
        }
        info.parent.write(r);
    }
}