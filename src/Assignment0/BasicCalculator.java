package Assignment0;

public class BasicCalculator {
    private int total = 0; // member var for all methods

    public int getTotal() { // return the total of the calculation
        return this.total;
    }

    public void add(int x) { // doing addition to the total
        this.total += x;
    }

    public void deduct(int x) {  // doing deduction to the total
        this.total -= x;
    }

    public void multiply(int x) {  // doing multiplication to the total
        this.total *= x;
    }

    public void divide(int x) {  // doing division to the total
        if (x == 0) return; // avoid dividing by 0
        this.total /= x;
    }

    public void modulo(int x) {  // doing modulus to the total
        if (x == 0) return;
        this.total %= x;
    }

    public void reset() { // reset the total back to 0
        this.total = 0;
    }

}
