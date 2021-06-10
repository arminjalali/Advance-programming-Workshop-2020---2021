import java.util.ArrayList;

public class Paint {
    ArrayList <Circle> circles = new ArrayList<>();
    ArrayList <Triangle> triangles = new ArrayList<>();
    ArrayList <Rectangle> rectangles = new ArrayList<>();

    /**
     * add a circle to list
     * @param circle
     */
    public void addCircle(Circle circle){
        circles.add(circle);
    }
    /**
     * add a triangle to list
     * @param triangle
     */
    public void addTriangle(Triangle triangle){
        triangles.add(triangle);
    }
    /**
     * add a rectangle to list
     * @param rect
     */
    public void addRectangle(Rectangle rect){
        rectangles.add(rect);
    }

    /**
     * draw all shapes
     */
    public void drawAll(){
        for (int i =0;i<circles.size();i++){
            circles.get(i).draw();
        }
        for (int i =0;i<triangles.size();i++){
            triangles.get(i).draw();
        }
        for (int i =0;i<rectangles.size();i++){
            rectangles.get(i).draw();
        }
    }

    /**
     * print all shapes
     */
    public void printAll(){
        for (int i =0;i<circles.size();i++){
            System.out.println(circles.get(i));
        }
        for (int i =0;i<triangles.size();i++){
            System.out.println(triangles.get(i));
        }
        for (int i =0;i<rectangles.size();i++){
            System.out.println(rectangles.get(i));
        }
    }
}
