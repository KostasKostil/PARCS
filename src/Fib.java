import parcs.*;

public class Fib implements AM{
    public void run(AMInfo info){
        long n,m,i0,k,r;
        n = info.parent.readLong();
        m = info.parent.readLong();
        i0= info.parent.readLong();
        k = info.parent.readLong();
        r = 1;

        for (int i=i0; i<n; i+=k)
        {
            r = r*(i+1)%m;
        }
        info.parent.write(r);
    }
}
