import java.util.Scanner;  // needed for Scanner

public class Falling{
    private static final double g = -9.8;
    private double x_i;
    private double v_i;

    public Falling(double _x_i, double _v_i)
    {
        x_i = _x_i;
        v_i = _v_i;
    }

    public Falling(double _x_i)
    {
        this(_x_i, 0);
    }

    public Falling()
    {
        this(0);
    }

    public String toString()
    {
        return ("Initial p,v: " + x_i + ", " + v_i);
    }

    public double at(double t)
    {
        return (0.5*g*t*t + v_i*t + x_i);
    }

    public static void main(String[] Args)
    {
        double x_i = 1000;
        double v_i = 0;

        Scanner scanner = new Scanner(System.in);
        Falling p = new Falling(x_i, v_i);
        double t = 0;
        System.out.println(p);

        while(t>=0)
        {
            System.out.print("Enter new time (negative to exit): ");
            String input = scanner.nextLine();

            try
            {
                t = Double.parseDouble(input);
            }
            catch (NumberFormatException|NullPointerException e)
            {
                System.out.println("Please type a number");
                continue;
            }

            if(t<0)
                continue;

            System.out.println("Position at time " + t + ": " + p.at(t));
        }
    }
}
