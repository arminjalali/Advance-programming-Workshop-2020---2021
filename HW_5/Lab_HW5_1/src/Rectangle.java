import java.util.ArrayList;

public class Rectangle {
    ArrayList <Double> sides = new ArrayList<>();
    public Rectangle(double num1,double num2,double num3,double num4){
        sides.add(num1);
        sides.add(num2);
        sides.add(num3);
        sides.add(num4);
    }

    /**
     * check is square
     * @return
     */
    public boolean isSquare(){
        if (sides.get(0).equals(sides.get(1))&&sides.get(1).equals(sides.get(2))&&sides.get(2).equals(sides.get(3))){
            return true;
        }
        return false;
    }

    /**
     * calculaye perimeter
     * @return
     */
    public double calculatePerimeter() {
        if (isSquare()==true){
            return sides.get(0)*sides.get(0);
        }
        for (int i = 1; i < sides.size(); i++) {
            if (sides.get(0) - sides.get(i) != 0) {
                return sides.get(0) * sides.get(i);
            }
        }
        return 0;
    }

    /**
     * calculate area
     * @return
     */
    public double calculateArea(){
        return  sides.get(0) +sides.get(1)+sides.get(2)+sides.get(3);
    }

    /**
     *draw info
     */
    public void draw(){
        if (isSquare()){
            System.out.println("Square: Perimeter --> " + calculatePerimeter()+" Area --> " + calculateArea());
            return;
        }
        System.out.println("Rectangle: Perimeter --> " + calculatePerimeter()+" Area --> " + calculateArea());
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sides=" + sides +
                '}';
    }
}
