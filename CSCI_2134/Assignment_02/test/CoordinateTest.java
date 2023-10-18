import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {
    @org.junit.jupiter.api.Test
    void add() {
        Coordinate c1 = new Coordinate(3, 5);
        Coordinate c2 = new Coordinate(2, -1);
        Coordinate res = c1.add(c2);
        assertEquals(5, res.x, "X coordinate after addition isn't correct.");
        assertEquals(4, res.y, "Y coordinate after addition isn't correct.");
    }

    @org.junit.jupiter.api.Test
    void sub() {
        Coordinate c1 = new Coordinate(7, 5);
        Coordinate c2 = new Coordinate(2, -1);
        Coordinate res = c1.sub(c2);
        assertEquals(5, res.x, "X coordinate after subtraction isn't correct.");
        assertEquals(6, res.y, "Y coordinate after subtraction isn't correct.");
    }

    @org.junit.jupiter.api.Test
    void scale() {
        Coordinate coordinate = new Coordinate(3, -2);
        Coordinate res = coordinate.scale(2);
        assertEquals(6, res.x, "X coordinate after scaling isn't correct.");
        assertEquals(-4, res.y, "Y coordinate after scaling isn't correct.");
    }
}
