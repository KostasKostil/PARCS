import parcs.*;

public class Fib implements AM{
    public void run(AMInfo info){
        long n,m,i0,k,r;

        System.out.println("entering run");
        n = info.parent.readLong();
        m = info.parent.readLong();
        i0 = info.parent.readLong();
        k = info.parent.readLong();
        System.out.println(i0 + "th thread");

        r = 1;
        for (long i=i0; i<=n; i+=k)
        {
            r = r*i%m;
        }
        info.parent.write(r);
    }
}