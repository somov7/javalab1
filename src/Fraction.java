import java.lang.Math;

public class Fraction {
    private int num, denum;

    public Fraction(Fraction other){
        num = other.num;
        denum = other.denum;
    }

    public Fraction(int newNum, int newDenum){
        num = newNum;
        denum = newDenum;
        simplify();
    }

    public void setNum(int newNum){
        num = newNum;
        simplify();
    }
    public int getNum(){
        return num;
    }
    public void setDenum(int newDenum){
        denum = newDenum;
        simplify();
    }
    public int getDenum(){
        return denum;
    }

    public double evaluate() {
        return num / (double) denum;
    }

    public Fraction add (Fraction that){
        int newDenum = lcm(denum, that.getDenum());
        num = num * (newDenum / denum) + that.num * (newDenum / that.denum);
        denum = newDenum;
        simplify();
        return this;
    }

    public int cmp (Fraction that){
        return (int) Math.signum(evaluate() - that.evaluate());
    }

    public String toString(){
        return new String(num + " / " + denum);
    }

    private int gcd(int first, int second){
        first = Math.abs(first);
        second = Math.abs(second);
        while(first != 0 && second != 0){
            if(first > second)
                first %= second;
            else
                second %= first;
        }
        return first + second;
    }
    private int lcm(int first, int second){
        return Math.abs(first / gcd(first, second) * second);
    }
    private void simplify(){
        if(denum < 0) {
            num *= -1;
            denum *= -1;
        }
        int g = gcd(num, denum);
        num /= g;
        denum /= g;
    }


}
