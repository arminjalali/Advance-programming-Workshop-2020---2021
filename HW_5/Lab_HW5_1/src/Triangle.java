import java.util.ArrayList;

public class Triangle{
    ArrayList<Double> sides = new ArrayList();

    public Triangle(double num1,double num2,double num3){
        sides.add(num1);
        sides.add(num2);
        sides.add(num3);
    }

    /**
     * check equality of sides
     * @return
     */
    public boolean isEquilateral(){
        if (sides.get(0).equals(sides.get(1))&&sides.get(0).equals(sides.get(2))){
            return true;
        }
        return false;
    }

    /**
     * calculate perimeter
     * @return
     */
    public double calculatePerimeter(){
        double p = calculateArea()/2;
        return (Math.sqrt((p)*(p-sides.get(0))*(p-sides.get(1))*(p-sides.get(2))));
    }

    /**
     * calculate area
     * @return
     */

    public double calculateArea(){
        return  sides.get(0) +sides.get(1)+sides.get(2);
    }

    /**
     * draw info
     */

    public void draw(){
        if (isEquilateral()){
            System.out.print("Equilateral ");
        }
        System.out.println("Triangle: Perimeter --> " + calculatePerimeter()+" Area --> " + calculateArea());
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sides=" + sides +
                '}';
    }
}
