import static java.lang.Math.*;

public class Circle{
    double radius;
    public Circle(double radius){
        this.radius=radius;
    }
    /**
     * get radius of circle
     * @return
     */
    public double getRadius() {
        return radius;
    }

    /**
     * calculate perimeter
     * @return
     */
    public double calculatePerimeter(){
        return getRadius()*getRadius()*PI;
    }

    /**
     * calculate area
     * @return
     */
    public double calculateArea(){
        return 2*PI*getRadius();
    }

    /**
     * draw info
     */
    public void draw(){
        System.out.println("Circle: Perimeter --> " + calculatePerimeter()+" Area --> " + calculateArea());
    }

    /**
     * to string
     * @return
     */
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}