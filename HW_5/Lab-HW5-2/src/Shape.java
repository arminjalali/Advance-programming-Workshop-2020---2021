public abstract class Shape extends Paint {
    /**
     * calculate perimeter
     * @return
     */
    public abstract double calculatePerimeter();

    /**
     * calculate area
     * @return
     */
    public abstract double calculateArea();

    /**
     * draw info
     */
    public abstract void draw();

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
