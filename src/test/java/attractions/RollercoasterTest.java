package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor cyril, peter;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        cyril = new Visitor(20, 158, 40);
        peter = new Visitor(9, 110, 15);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void isAllowedTo(){
        assertEquals(true, rollerCoaster.isAllowedTo(cyril));
    }

    @Test
    public void moneyReduces(){
        rollerCoaster.priceFor(cyril);
        assertEquals(31.60, cyril.getMoney(), 0.01);
    }

    @Test
    public void isnotAllowed(){
        assertEquals(false, rollerCoaster.isAllowedTo(peter));
    }
}
