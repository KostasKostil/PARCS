import parcs.*;

public class Fib implements AM{
    public void run(AMInfo info){
        long n,m,i0,k,r;
        r = 1;
        info.parent.write(r);
        n = info.parent.readLong();
        println(n);
        m = info.parent.readLong();
        i0= info.parent.readLong();
        k = info.parent.readLong();
        for (long i=i0; i<n; i+=k)
        {
            r = r*(i+1)%m;
        }
        info.parent.write(r);
    }
}
