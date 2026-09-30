package inClass;

public class HighArray {
    private int nElem = 0;
    private long[] a;

    public HighArray(long[] a) { 
        this.a = a;
    }

    public void insert(long val) {
        a[nElem] = val;
        nElem++;
    }
    public static void main(String[] args) {

    }
}
