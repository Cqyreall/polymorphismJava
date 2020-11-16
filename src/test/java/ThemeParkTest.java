import attractions.Attraction;
import attractions.Playground;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;
import stalls.Stall;
import stalls.TobaccoStall;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    RollerCoaster rollerCoaster;
    CandyflossStall candyfloss;
    ThemePark park;
    Visitor cyril;
    TobaccoStall tobaccoStall;
    Playground playground;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        candyfloss = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1);
        candyfloss.setRating(6);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1);
        cyril = new Visitor(20, 130, 40.0);
        park = new ThemePark();
    }

    @Test
    public void addsToCollections(){
        park.addToCollections(candyfloss);
        park.addToCollections(rollerCoaster);
        assertEquals(2, park.getCollections().size());
    }

    @Test
    public void visited(){
        park.visit(cyril, rollerCoaster);
        assertEquals(1, cyril.getVisitedAttractions().size());
        assertEquals(1, rollerCoaster.getVisitCount());
    }
    @Test
    public void reviews(){
        park.addToCollections(candyfloss);
        park.addToCollections(rollerCoaster);
        HashMap<String, Integer> finalReview = park.reviews();
        assertEquals(true, finalReview.containsKey("Candy Land"));
    }

    @Test
    public void allowed(){
        park.addToCollections(rollerCoaster);
        park.addToCollections(playground);
        park.addToCollections(tobaccoStall);
        assertEquals(1, park.getAllAllowedFor(cyril).size());
    }

}
