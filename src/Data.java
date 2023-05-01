import java.io.Serializable;

public class Data implements Serializable {
    int n;
    int m;
    int i0;
    int k;

    public Data(int n, int m, int i0, int k) {
        this.n = n;
        this.m = m;
        this.i0 = i0;
        this.k = k;
    }
}