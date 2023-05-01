import parcs.*;

public class Fib implements AM{
    public void run(AMInfo info){
        long n,m,i0,k,r;
        n = info.parent.readLong();
        m = info.parent.readLong();
        i0= info.parent.readLong();
        k = info.parent.readLong();
        r = 1;
        printl(n);
        printl(m);
        printl(k);
        printl(i0);
        for (long i=i0; i<n; i+=k)
        {
            r = r*(i+1)%m;
        }
        info.parent.write(r);
    }
}
