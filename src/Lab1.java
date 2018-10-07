import java.io.*;
import java.util.Scanner;


public class Lab1 {

    static FractionSet[] fracSet = new FractionSet[2];

    static void readFractions(String fileName){

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            Scanner scanner;
            for(int j = 0; j < 2; j++) {
                fracSet[j] = new FractionSet();
                line = reader.readLine();
                scanner = new Scanner(line);
                int cnt = scanner.nextInt();
                for(int i = 0; i < cnt; i++) {
                    line = reader.readLine();
                    scanner = new Scanner(line);
                    fracSet[j].add(new Fraction(scanner.nextInt(), scanner.nextInt()));
                }
            }
            reader.close();
        }
        catch (IOException e){
            return;
        }
    }

    public static void main(String[] args){
        String fileName = "lab1.in";
        readFractions(fileName);
        Polynomial[] polynomial = new Polynomial[2];

        System.out.println(fracSet[0].toString());
        System.out.println("fractions greater than 1: " + fracSet[0].countGreater(new Fraction(1, 1)));
        System.out.println("max = " + fracSet[0].max().evaluate() + " min = " + fracSet[0].min().evaluate() + "\n");

        System.out.println(fracSet[1].toString());
        System.out.println("fractions less than 1: " + fracSet[1].countLess(new Fraction(1, 1)));
        System.out.println("max = " + fracSet[1].max().evaluate() + " min = " + fracSet[1].min().evaluate() + "\n");

        for(int i = 0; i < 2; i++)
            polynomial[i] = new Polynomial(fracSet[i]);
        polynomial[1].append(new Fraction(34, 55));
        polynomial[0].add(polynomial[1]);
        System.out.println(polynomial[0].toString());
    }
}
