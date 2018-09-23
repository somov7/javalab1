import java.util.List;
import java.util.ArrayList;

public class FractionSet {
    List<Fraction> data;
    Fraction minFrac, maxFrac, lastChecked = null;
    int lastCount;

    public FractionSet(){
        data = new ArrayList<Fraction>();
    }

    public List<Fraction> getData(){
        return data;
    }

    public void add(Fraction frac){
        if(data.isEmpty())
            minFrac = maxFrac = frac;
        else {
            if(frac.cmp(minFrac) == -1)
                minFrac = frac;
            if(frac.cmp(maxFrac) == 1)
                maxFrac = frac;
        }
        data.add(frac);
        lastChecked = null;
    }

    public Fraction max(){
        if(!data.isEmpty())
            return maxFrac;
        return null;
    }

    public Fraction min(){
        if(!data.isEmpty())
            return minFrac;
        return null;
    }

    public int countGreater(Fraction frac){
        int cnt = 0;
        for(Fraction fr: data){
            if(fr.cmp(frac) == 1)
                cnt++;
        }
        return cnt;
    }

    public int countLess(Fraction frac){
        if(lastChecked != null && frac.cmp(lastChecked) == 0)
            return lastCount;
        int cnt = 0;
        for(Fraction fr: data){
            if(fr.cmp(frac) == -1)
                cnt++;
        }
        lastChecked = new Fraction(frac);
        return lastCount = cnt;
    }

    public void print(){
        for(Fraction fr: data)
            System.out.println(fr.getNum() + " / " + fr.getDenum() + " = " + fr.evaluate());
    }

}
