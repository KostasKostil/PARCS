import parcs.*;

public class Fib implements AM{
    public void run(AMInfo info){
        long n,m,i0,k,r;

        System.out.println("here1");
        n = info.parent.readLong();
        System.out.println("here2" + n);
        m = info.parent.readLong();
        System.out.println("here3" + m);
        i0= info.parent.readLong();
        System.out.println("here4" + i0);
        k = info.parent.readLong();
        System.out.println("here5");
        r = 1;
        for (long i=i0; i<n; i+=k)
        {
            r = r*(i+1)%m;
        }
        info.parent.write(r);
    }
}