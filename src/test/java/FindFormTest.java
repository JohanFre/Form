import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FindFormTest {

    private FindForm findForm;
    private ArrayList<Cords> cordsList;

    // Before each test a new ArrayList of coordinates is set up.
    @BeforeEach
    void setup(){
        cordsList = new ArrayList<>();
    }

    // Return true when list is empty.
    @Test
    void should_Return_True_When_List_Is_Empty(){
        findForm = new FindForm(cordsList);

        boolean expected = true;
        boolean actual = findForm.isEmpty();
        assertEquals(expected, actual);
    }

    // Returns true when list creates a dot.
    @Test
    void should_Return_True_When_List_Makes_Dot(){
        cordsList.add(new Cords(1,0,0));
        findForm = new FindForm(cordsList);

        boolean expected = true;
        boolean actual = findForm.isDot();
        assertEquals(expected, actual);
    }

    // Returns true when list creates a line.
    @Test
    void should_Return_True_When_List_Makes_Line(){
        cordsList.add(new Cords(1,0,0));
        cordsList.add(new Cords(2,0,0));
        findForm = new FindForm(cordsList);

        boolean expected = true;
        boolean actual = findForm.isLine();
        assertEquals(expected, actual);
    }

    // Returns true when list creates a triangle.
    @Test
    void should_Return_True_When_List_Makes_Triangle(){
        cordsList.add(new Cords(0,0,0));
        cordsList.add(new Cords(1,1,0));
        cordsList.add(new Cords(2,2,0));
        findForm = new FindForm(cordsList);

        boolean expected = true;
        boolean actual = findForm.isTriangle();
        assertEquals(expected, actual);
    }

    // Returns true when list creates a square.
    @Test
    void should_Return_True_When_List_Makes_Square(){
        cordsList.add(new Cords(1,2,0));
        cordsList.add(new Cords(5,2,0));
        cordsList.add(new Cords(5,6,0));
        cordsList.add(new Cords(1,6,0));
        findForm = new FindForm(cordsList);

        boolean expected = true;
        boolean actual = findForm.isSquare();
        assertEquals(expected, actual);

    }

    // Returns true when list creates a rectangle.
    @Test
    void should_Return_True_When_List_Makes_Rectangle(){
        cordsList.add(new Cords(1,2,3));
        cordsList.add(new Cords(10,2,3));
        cordsList.add(new Cords(10,6,3));
        cordsList.add(new Cords(1,6,3));
        findForm = new FindForm(cordsList);

        boolean expected = true;
        boolean actual = findForm.isRectangle();
        assertEquals(expected, actual);
    }

    // Returns true when list creates a parallelogram.
    @Test
    void should_Return_True_When_List_Makes_Parallelogram(){
        cordsList.add(new Cords(1,2,3));
        cordsList.add(new Cords(5,23,3));
        cordsList.add(new Cords(20,6,3));
        cordsList.add(new Cords(1,5,3));
        findForm = new FindForm(cordsList);

        boolean expected = true;
        boolean actual = findForm.isParallelogram();
        assertEquals(expected, actual);
    }

    // Returns true when list creates a 2D shape.
    @Test
    void should_Return_True_When_List_Makes_2D(){
        cordsList.add(new Cords(1,2,0));
        cordsList.add(new Cords(5,2,3));
        cordsList.add(new Cords(20,2,5));
        cordsList.add(new Cords(1,2,7));
        cordsList.add(new Cords(1,2,0));
        findForm = new FindForm(cordsList);

        boolean expected = true;
        boolean actual = findForm.is2D();
        assertEquals(expected, actual);
    }

    // Returns true when list creates a pyramid.
    @Test
    void should_Return_True_When_List_Makes_Pyramid(){
        cordsList.add(new Cords(1,2,0));
        cordsList.add(new Cords(10,2,0));
        cordsList.add(new Cords(10,6,0));
        cordsList.add(new Cords(1,6,0));
        cordsList.add(new Cords(0,0,3));
        findForm = new FindForm(cordsList);

        boolean expected = true;
        boolean actual = findForm.ifPyramid();
        assertEquals(expected, actual);
    }

    // Returns true when list creates a Cube.
    @Test
    void should_Return_True_When_List_Makes_Cube(){
        cordsList.add(new Cords(14,0,6));
        cordsList.add(new Cords(22,0,6));
        cordsList.add(new Cords(22,0,14));
        cordsList.add(new Cords(14,0,14));
        cordsList.add(new Cords(14,8,6));
        cordsList.add(new Cords(22,8,6));
        cordsList.add(new Cords(22,8,14));
        cordsList.add(new Cords(14,8,14));
        findForm = new FindForm(cordsList);

        boolean expected = true;
        boolean actual = findForm.isCube();
        assertEquals(expected, actual);
    }

    // Returns true when list creates a Rectangular Prism.
    @Test
    void should_Return_True_When_List_Makes_RectangularPrism(){
        cordsList.add(new Cords(7,0,6));
        cordsList.add(new Cords(11,0,6));
        cordsList.add(new Cords(11,0,14));
        cordsList.add(new Cords(7,0,14));
        cordsList.add(new Cords(7,8,6));
        cordsList.add(new Cords(11,8,6));
        cordsList.add(new Cords(11,8,14));
        cordsList.add(new Cords(7,8,14));
        findForm = new FindForm(cordsList);

        boolean expected = true;
        boolean actual = findForm.isRectangularPrism();
        assertEquals(expected, actual);
    }

    // Returns true when list creates a 3D shape.
    @Test
    void should_Return_True_When_List_Makes_3DShape(){
        cordsList.add(new Cords(2,0,1));
        cordsList.add(new Cords(2,0,2));
        cordsList.add(new Cords(4,2,3));
        cordsList.add(new Cords(4,2,4));
        cordsList.add(new Cords(7,4,5));
        cordsList.add(new Cords(7,4,6));
        cordsList.add(new Cords(3,6,7));
        cordsList.add(new Cords(3,6,8));
        findForm = new FindForm(cordsList);

        boolean expected = true;
        boolean actual = findForm.is3DShape();
        assertEquals(expected, actual);
    }

}