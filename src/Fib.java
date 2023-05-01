import parcs.*;

public class Fib implements AM{
    public void run(AMInfo info){
        long n,m,i0,k,r;

        System.out.println("entering run1");
        Data data = (Data)info.parent.readObject();
        n = data.n;
        m = data.m;
        i0 = data.i0;
        k = data.k;
        System.out.println(i0 + "th thread");

        r = 1;
        for (long i=i0; i<n; i+=k)
        {
            r = r*(i+1)%m;
        }
        info.parent.write(r);
    }
}