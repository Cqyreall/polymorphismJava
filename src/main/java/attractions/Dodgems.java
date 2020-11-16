package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    public Dodgems(String name, int rating) {
        super(name, rating);
    }

    public double defaultPrice(){
        return 4.50;
    }

    public double priceFor(Visitor visitor){
        double priceCharged = 0;

        if(visitor.getAge() < 12){
            priceCharged = this.defaultPrice() / 2;
        }
        else {
            priceCharged = this.defaultPrice();
        }

        return priceCharged;
    }
}
