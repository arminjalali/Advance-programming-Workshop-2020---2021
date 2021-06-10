
public class Triangle extends Polygon{

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
        if (getSides().get(0).equals(getSides().get(1))&&getSides().get(0).equals(getSides().get(2))){
            return true;
        }
        return false;
    }

    /**
     * calculate perimeter
     * @return
     */
    @Override
    public double calculatePerimeter(){
        double p = calculateArea()/2;
        return (Math.sqrt((p)*(p-sides.get(0))*(p-sides.get(1))*(p-sides.get(2))));
    }

    /**
     * calculate area
     * @return
     */
    @Override
    public double calculateArea(){
        return  sides.get(0) +sides.get(1)+sides.get(2);
    }

    /**
     * draw info
     */
    @Override
    public void draw(){
        if (isEquilateral()){
            System.out.print("Equilateral ");
        }
        System.out.println("Triangle: Perimeter --> " + calculatePerimeter()+" Area --> " + calculateArea());
    }
}
