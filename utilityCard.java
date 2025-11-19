
import java.util.HashMap;

class utilityCard{

    int cost, rent;
    static HashMap<String, utilityCard> utilityCards = new HashMap<>();

    utilityCard(int cost, int rent) {
        this.cost = cost;
        this.rent = rent;
    }

    static void setUtilityCards(){
        utilityCards.put("internet", new utilityCard(2000, 300));
        utilityCards.put("electricity", new utilityCard(1100, 150));
    }
}