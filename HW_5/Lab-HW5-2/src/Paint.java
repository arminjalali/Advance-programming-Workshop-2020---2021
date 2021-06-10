import java.util.ArrayList;

public class Paint {
    private ArrayList <Shape> shapes = new ArrayList<>();

    /**
     * add a shape to list
     * @param shape
     */
    public void addShape(Shape shape){
        this.shapes.add(shape);
    }

    /**
     * draw all shapes
     */
    public void drawAll(){
        for (int i =0;i<shapes.size();i++){
            shapes.get(i).draw();

        }
    }

    /**
     * print all shapes
     */
    public void printAll(){
        for (int i =0;i<shapes.size();i++){
            System.out.println(shapes.get(i));
        }
    }
}
