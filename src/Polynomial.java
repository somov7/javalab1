import java.util.List;
import java.util.ArrayList;

public class Polynomial {

    List<Fraction> data;

    public Polynomial(){
        data = new ArrayList<Fraction>();
    }

    public Polynomial(FractionSet fracSet){
        data = new ArrayList<Fraction>();
        data.addAll(fracSet.getData());
    }

    public void append (Fraction frac){
        data.add(frac);
    }

    public Polynomial add (Polynomial that){
        for(int i = 0; i < data.size() && i < that.data.size(); i++)
            data.get(i).add(that.data.get(i));
        for(int i = that.data.size(); i < data.size(); i++)
            data.add(that.data.get(i));
        return this;
    }

    public double evaluate(double point){
        double result = 0, pt = 1;
        for(Fraction fr: data) {
            result += fr.evaluate() * pt;
            pt *= point;
        }
        return result;
    }
}
