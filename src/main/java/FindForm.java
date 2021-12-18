import java.util.ArrayList;

public class FindForm {

    // Variables for saving X,Y,Z coordinates.
    private Cords P1;
    private Cords P2;
    private Cords P3;
    private Cords P4;
    private Cords P5;
    private Cords P6;
    private Cords P7;
    private Cords P8;

    // Arraylist for cords used.
    private final ArrayList<Cords> cordsList;

    // Integers used when distance is measured.
    private int P1_P2;
    private int P2_P3;
    private int P3_P4;
    private int P4_P1;
    private int P5_P6;
    private int P6_P7;
    private int P7_P8;
    private int P8_P5;
    private int P1_P5;
    private int P2_P6;
    private int P3_P7;
    private int P4_P8;

    // Constructor for arraylist.
    public FindForm(ArrayList<Cords> cordsList) {
        this.cordsList = cordsList;
    }

    // Method to check if list is empty.
    public boolean isEmpty() {

        if (cordsList.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    // Method checking for 1 set of coordinates to create a dot.
    public boolean isDot() {

        if (cordsList.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    // Method for checking for 2 sets of coordinates that creates a line.
    public boolean isLine() {
        if (cordsList.size() == 2 && !(cordsList.get(0).getX() == cordsList.get(1).getX())
                || !(cordsList.get(0).getY() == cordsList.get(1).getY())) {
            return true;
        } else {
            return false;
        }
    }

    // Method for checking for 3 sets of coordinates that creates triangle.
    public boolean isTriangle() {

        P1 = cordsList.get(0);
        P2 = cordsList.get(1);
        P3 = cordsList.get(2);

        if (cordsList.size() == 3 && !(P1 == P2) && !(P1 == P3) && !(P2 == P3)) {
            return true;
        } else {
            return false;
        }
    }

    // Method for checking if coordinates creates square.
    public boolean isSquare() {

        P1 = cordsList.get(0);
        P2 = cordsList.get(1);
        P3 = cordsList.get(2);
        P4 = cordsList.get(3);

        P1_P2 = getSquaredDistance(P1, P2);
        P2_P3 = getSquaredDistance(P2, P3);
        P3_P4 = getSquaredDistance(P3, P4);
        P4_P1 = getSquaredDistance(P4, P1);

        if (cordsList.size() == 4 && equalDistance(P1_P2, P2_P3, P3_P4, P4_P1) == true) {
            return true;
        } else {
            return false;
        }
    }

    // Method for checking if coordinates creates rectangle.
    public boolean isRectangle() {
        P1 = cordsList.get(0);
        P2 = cordsList.get(1);
        P3 = cordsList.get(2);
        P4 = cordsList.get(3);

        P1_P2 = getSquaredDistance(P1, P2);
        P2_P3 = getSquaredDistance(P2, P3);
        P3_P4 = getSquaredDistance(P3, P4);
        P4_P1 = getSquaredDistance(P4, P1);


        if (cordsList.size() == 4 && twoSidesEqual(P1_P2, P2_P3, P3_P4, P4_P1) == true) {
            return true;
        } else {
            return false;
        }

    }

    // Method for checking if coordinates creates parallelogram.
    public boolean isParallelogram() {
        P1 = cordsList.get(0);
        P2 = cordsList.get(1);
        P3 = cordsList.get(2);
        P4 = cordsList.get(3);

        P1_P2 = getSquaredDistance(P1, P2);
        P2_P3 = getSquaredDistance(P2, P3);
        P3_P4 = getSquaredDistance(P3, P4);
        P4_P1 = getSquaredDistance(P4, P1);

        if (cordsList.size() == 4 && !equalDistance(P1_P2, P2_P3, P3_P4, P4_P1) == true && !twoSidesEqual(P1_P2, P2_P3, P3_P4, P4_P1) == true) {
            return true;
        } else {
            return false;
        }
    }

    // Method for checking if coordinates creates 2D.
    public boolean is2D() {
        P1 = cordsList.get(0);
        P2 = cordsList.get(1);
        P3 = cordsList.get(2);
        P4 = cordsList.get(3);
        P5 = cordsList.get(4);

        if (check2D(P1, P2, P3, P4, P5) == true) {
            return true;
        } else {
            return false;
        }
    }

    // Method for checking if coordinates creates pyramid.
    public boolean ifPyramid() {
        P1 = cordsList.get(0);
        P2 = cordsList.get(1);
        P3 = cordsList.get(2);
        P4 = cordsList.get(3);
        P5 = cordsList.get(4);

        P1_P2 = getSquaredDistance(P1, P2);
        P2_P3 = getSquaredDistance(P2, P3);
        P3_P4 = getSquaredDistance(P3, P4);
        P4_P1 = getSquaredDistance(P4, P1);

        if (twoSidesEqual(P1_P2, P2_P3, P3_P4, P4_P1) == true && !(P1.getZ() == 0) || !(P2.getZ() == 0) || !(P3.getZ() == 0) || !(P4.getZ() == 0) || !(P5.getZ() == 0)) {
            return true;
        } else {
            return false;
        }
    }

    // Method for checking if coordinates creates cube.
    public boolean isCube() {

        P1 = cordsList.get(0);
        P2 = cordsList.get(1);
        P3 = cordsList.get(2);
        P4 = cordsList.get(3);
        P5 = cordsList.get(4);
        P6 = cordsList.get(5);
        P7 = cordsList.get(6);
        P8 = cordsList.get(7);

        P5_P6 = getSquaredDistance(P5, P6);
        P6_P7 = getSquaredDistance(P6, P7);
        P7_P8 = getSquaredDistance(P7, P8);
        P8_P5 = getSquaredDistance(P8, P5);
        P1_P5 = getSquaredDistance(P1, P5);
        P2_P6 = getSquaredDistance(P2, P6);
        P3_P7 = getSquaredDistance(P3, P7);
        P4_P8 = getSquaredDistance(P4, P8);

        if (cordsList.size() == 8 && equalDistance(P5_P6, P6_P7, P7_P8, P8_P5, P1_P5, P2_P6, P3_P7, P4_P8) == true) {
            return true;
        } else {
            return false;
        }

    }

    // Method for checking if coordinates creates rectangular prism.
    public boolean isRectangularPrism() {
        P1 = cordsList.get(0);
        P2 = cordsList.get(1);
        P3 = cordsList.get(2);
        P4 = cordsList.get(3);
        P5 = cordsList.get(4);
        P6 = cordsList.get(5);
        P7 = cordsList.get(6);
        P8 = cordsList.get(7);

        P5_P6 = getSquaredDistance(P5, P6);
        P6_P7 = getSquaredDistance(P6, P7);
        P7_P8 = getSquaredDistance(P7, P8);
        P8_P5 = getSquaredDistance(P8, P5);
        P1_P5 = getSquaredDistance(P1, P5);
        P2_P6 = getSquaredDistance(P2, P6);
        P3_P7 = getSquaredDistance(P3, P7);
        P4_P8 = getSquaredDistance(P4, P8);

        if((twoSidesEqual(P1_P2, P2_P3, P3_P4, P4_P1) == true)
                && (twoSidesEqual(P5_P6, P6_P7, P7_P8, P8_P5) == true)
                && equalDistance(P1_P5, P2_P6, P3_P7, P4_P8) == true){
            return true;
        }
        else {
            return false;
        }

    }

    // Calculates the distance between the points.
    private int getSquaredDistance(Cords i, Cords j) {
        return (i.x - j.x) * (i.x - j.x) + (i.y - j.y) * (i.y - j.y) + (i.z - j.z) * (i.z - j.z);
    }

    // Calculate if all points of coordinates has the same distance which forms a square.
    private boolean equalDistance(int... distances) {

        for (int i = 1; i < distances.length; i++) {
            int first = distances[i - 1];
            int second = distances[i];
            if (first != second) {
                return false;
            }
        }
        return true;
    }

    // Calculates if two of the opposite sides has the same distance.
    private boolean twoSidesEqual(int p1_p2, int p2_p3, int p3_p4, int p4_p1) {

        if (p1_p2 == p3_p4 || p2_p3 == p4_p1) {
            return true;
        } else {
            return false;
        }
    }

    // If X or Y or Z has the same input it becomes 2D since they are on same plane.
    private boolean check2D(Cords p1, Cords p2, Cords p3, Cords p4, Cords p5) {
        if (p1.getX() == p2.getX()
                && p1.getX() == p3.getX()
                && p1.getX() == p4.getX()
                && p1.getX() == p5.getX()
                && p2.getX() == p3.getX()
                && p2.getX() == p4.getX()
                && p2.getX() == p5.getX()
                && p3.getX() == p4.getX()
                && p3.getX() == p5.getX()
                && p4.getX() == p5.getX() ||
                p1.getY() == p2.getY()
                        && p1.getY() == p3.getY()
                        && p1.getY() == p4.getY()
                        && p1.getY() == p5.getY()
                        && p2.getY() == p3.getY()
                        && p2.getY() == p4.getY()
                        && p2.getY() == p5.getY()
                        && p3.getY() == p4.getY()
                        && p3.getY() == p5.getY()
                        && p4.getY() == p5.getY() ||
                p1.getZ() == p2.getZ()
                        && p1.getZ() == p3.getZ()
                        && p1.getZ() == p4.getZ()
                        && p1.getZ() == p5.getZ()
                        && p2.getZ() == p3.getZ()
                        && p2.getZ() == p4.getZ()
                        && p2.getZ() == p5.getZ()
                        && p3.getZ() == p4.getZ()
                        && p3.getZ() == p5.getZ()
                        && p4.getZ() == p5.getZ()) {
            return true;
        } else {
            return false;
        }

    }

    // Method for checking if coordinates creates a 3D shape with different Z points.
    public boolean is3DShape() {
        P1 = cordsList.get(0);
        P2 = cordsList.get(1);
        P3 = cordsList.get(2);
        P4 = cordsList.get(3);
        P5 = cordsList.get(4);
        P6 = cordsList.get(5);
        P7 = cordsList.get(6);
        P8 = cordsList.get(7);

        if(check3DShape(P1, P2, P3, P4, P5, P6, P7, P8)){
            return true;
        }
        else {
            return false;
        }
    }

    // Checks so that all Z points have different inputs.
    private boolean check3DShape(Cords p1, Cords p2, Cords p3, Cords p4, Cords p5, Cords p6, Cords p7, Cords p8) {

        if(!(p1.getZ() == p2.getZ())
                && !(p1.getZ() == p3.getZ())
                && !(p1.getZ() == p4.getZ())
                && !(p1.getZ() == p5.getZ())
                && !(p1.getZ() == p6.getZ())
                && !(p1.getZ() == p7.getZ())
                && !(p1.getZ() == p8.getZ())
                && !(p2.getZ() == p3.getZ())
                && !(p2.getZ() == p4.getZ())
                && !(p2.getZ() == p5.getZ())
                && !(p2.getZ() == p6.getZ())
                && !(p2.getZ() == p7.getZ())
                && !(p2.getZ() == p8.getZ())
                && !(p3.getZ() == p4.getZ())
                && !(p3.getZ() == p5.getZ())
                && !(p3.getZ() == p6.getZ())
                && !(p3.getZ() == p7.getZ())
                && !(p3.getZ() == p8.getZ())
                && !(p4.getZ() == p5.getZ())
                && !(p4.getZ() == p6.getZ())
                && !(p4.getZ() == p7.getZ())
                && !(p4.getZ() == p8.getZ())
                && !(p5.getZ() == p6.getZ())
                && !(p5.getZ() == p7.getZ())
                && !(p5.getZ() == p8.getZ())
                && !(p6.getZ() == p7.getZ())
                && !(p6.getZ() == p8.getZ())
                && !(p7.getZ() == p8.getZ())){
            return true;
        }
        else{
            return false;
        }

    }
}
