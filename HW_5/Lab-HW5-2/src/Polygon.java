import java.util.ArrayList;

public abstract class Polygon extends Shape {
    ArrayList<Double> sides = new ArrayList<>();

    /**
     * constructor and initial sides
     * @param sides
     */
    public Polygon(double...sides){
        for (double a:sides){
            this.sides.add(a);
        }
    }
    /**
     * get sides of triangle
     * @return
     */
    public ArrayList<Double> getSides() {
        return sides;
    }

    /**
     * return sides as a string
     * @return sides
     */
    @Override
    public String toString() {
        return "Polygon{" +
                "sides=" + sides +
                '}';
    }

}
