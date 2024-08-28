import java.util.Scanner;

public class Quad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //adds the elements to array A
        System.out.print("Enter the coefficients for the parabola ax^2+bx+c: ");
        String aElements = scan.nextLine();
        aElements = aElements.replaceAll("\\s", ""); //gets rid of all the spaces
        String[] placeholder = aElements.split(",");

        if(placeholder.length != 3){
            System.out.println("Invalid input.");
        }
        else{
            double a = Double.parseDouble(placeholder[0]);
            double b = Double.parseDouble(placeholder[1]);
            double c = Double.parseDouble(placeholder[2]);

            double[] ver = vertex(a, b, c);

            System.out.println("The vertex of the parabola is approximately:\n" + "(" + ver[0] + ", " + ver[1] + ")");
        }

        scan.close();
    }

    // a, b, c are quadratic function coefficients and the return is an array of length 2 with
    // first value the x coordinate of the vertex and the second value the y coordinate of the vertex
    public static double[] vertex(double a, double b, double c){
        double fPrime;
        double x = 0; //starting point
        double step_size = 1; //how much x changes on each iteration
        while(step_size > 0.01){
            fPrime = 2*a*x+b;
            if(2*a*x+b == 0){
                step_size = 0;
            }
            else if(2*a*x+b > 0 && a > 0){
                x -= step_size;
            }
            else if(2*a*x+b > 0 && a < 0){
                x += step_size;
            }
            else if(2*a*x+b < 0  && a > 0){
                x += step_size;
            }
            else if(2*a*x+b < 0  && a < 0){
                x -= step_size;
            }
            if(fPrime < 0 && 2*a*x+b > 0){
                step_size = step_size/2;
            }
            else if(fPrime > 0 && 2*a*x+b < 0){
                step_size = step_size/2;
            }
        }
        double[] ver = {x,a*(Math.pow(x,2))+b*x+c};
        return ver;
    }
}
