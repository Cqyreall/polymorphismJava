package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster extends Attraction implements ISecurity, ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    public boolean isAllowedTo(Visitor visitor){
        if((visitor.getHeight() >= 145) && (visitor.getAge() >=12)){
            return true;
        }
        else {
            return false;
        }
    }

    public double defaultPrice(){
        return 8.40;
    }

    public double priceFor(Visitor visitor){
        double priceCharged = 0;

        if(this.isAllowedTo(visitor) && visitor.getMoney() >= (2 * this.defaultPrice())){
            if (visitor.getHeight() > 200){
                priceCharged = this.defaultPrice() * 2;
            }
            else {
                priceCharged = this.defaultPrice();
            }
        }
        else {
            priceCharged = 0;
        }

        double moneyVisitorHas = visitor.getMoney();
        moneyVisitorHas -= priceCharged;
        visitor.setMoney(moneyVisitorHas);

        return priceCharged;
    }
}
