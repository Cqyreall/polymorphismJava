package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {
    Playground playground;
    Visitor cyril, peter;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        cyril = new Visitor(20, 158, 40);
        peter = new Visitor(9, 130, 15);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void rejectsVisitor(){
        assertEquals(false, playground.isAllowedTo(cyril));
    }

    @Test
    public void acceptsVisitor(){
        assertEquals(true, playground.isAllowedTo(peter));
    }
}
