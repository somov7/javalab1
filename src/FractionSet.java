import java.util.List;
import java.util.ArrayList;

public class FractionSet {
    List<Fraction> data = new ArrayList<Fraction>();
    Fraction minFrac, maxFrac, lastCheckedLess = null, lastCheckedGreater = null;
    int lastCountLess, LastCountGreater;

    public FractionSet(){}

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
        lastCheckedLess = null;
        lastCheckedGreater = null;
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
        if(lastCheckedLess != null && frac.cmp(lastCheckedLess) == 0)
            return lastCountLess;
        int cnt = 0;
        for(Fraction fr: data){
            if(fr.cmp(frac) == 1)
                cnt++;
        }
        lastCheckedLess = new Fraction(frac);
        return lastCountLess = cnt;
    }

    public int countLess(Fraction frac){
        if(lastCheckedLess != null && frac.cmp(lastCheckedLess) == 0)
            return lastCountLess;
        int cnt = 0;
        for(Fraction fr: data){
            if(fr.cmp(frac) == -1)
                cnt++;
        }
        lastCheckedLess = new Fraction(frac);
        return lastCountLess = cnt;
    }

    public String toString(){
        String ret = new String();
        for(Fraction fr: data)
            ret += fr.toString() + "\n";
        return ret;
    }

}
