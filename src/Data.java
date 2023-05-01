import java.io.Serializable;

public class Data implements Serializable {
    long n;
    long m;
    long i0;
    long k;

    public Data(long n, long m, long i0, long k) {
        this.n = n;
        this.m = m;
        this.i0 = i0;
        this.k = k;
    }
}