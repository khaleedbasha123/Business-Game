
import java.util.HashMap;

class utilityCard extends card{

    // int cost, rentSite, bankMortageValue;
    static HashMap<String, utilityCard> utilityCards = new HashMap<>();

    utilityCard(int cost, int rent, int bankMortageValue) {
        this.cost = cost;
        this.rentSite = rent;
        this.bankMortageValue = bankMortageValue;
    }

    static void setUtilityCards(){
        utilityCards.put("internet", new utilityCard(2000, 300, 700));
        utilityCards.put("electricity", new utilityCard(1100, 150, 400));
    }
}