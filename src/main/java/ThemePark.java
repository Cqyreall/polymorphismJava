import attractions.Attraction;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import people.Visitor;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<IReviewed> collections;

    public ThemePark() {
        this.collections = new ArrayList<IReviewed>();
    }

    public ArrayList<IReviewed> getCollections() {
        return collections;
    }

    public void setCollections(ArrayList<IReviewed> collections) {
        this.collections = collections;
    }

    public void addToCollections(IReviewed collection){
        this.collections.add(collection);
    }

    public void visit(Visitor visitor, Attraction attraction){
        int visitCount = attraction.getVisitCount() + 1;
        attraction.setVisitCount(visitCount);
        visitor.addAttraction(attraction);
    }

    public HashMap<String, Integer> reviews (){
        HashMap<String, Integer> review = new HashMap<>();
        for(int i = 0; i < this.collections.size(); i++){
            IReviewed currentCllection = this.collections.get(i);
            review.put(currentCllection.getName(), currentCllection.getRating());
        }
        return review;
    }


    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allPlaces = new ArrayList<>();
        for(int i = 0; i < this.collections.size(); i++){
            IReviewed currentAttraction = this.collections.get(i);
            if(currentAttraction instanceof Playground){
                if (((Playground) currentAttraction).isAllowedTo(visitor)){
                    IReviewed attraction = (IReviewed) currentAttraction;
                    allPlaces.add(attraction);
                }
            }
            if(currentAttraction instanceof RollerCoaster){
                if(((RollerCoaster) currentAttraction).isAllowedTo(visitor)){
                    IReviewed attraction = (IReviewed) currentAttraction;
                    allPlaces.add(attraction);
                }
            }
            if(currentAttraction instanceof TobaccoStall){
                if(((TobaccoStall) currentAttraction).isAllowedTo(visitor)){
                    IReviewed attraction = (IReviewed) currentAttraction;
                    allPlaces.add(attraction);
                }
            }
        }
        return allPlaces;
    }
}
