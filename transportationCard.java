import java.util.HashMap;

class transportationCard {
    int cost, bankMortageValue, rent;
    
    static HashMap<String, transportationCard> transportationCards = new HashMap<>();
    
    transportationCard(int cost, int rent, int bankMortageValue){
        this.cost = cost;
        this.rent = rent;
        this.bankMortageValue = bankMortageValue;
    }
    
    static void setTransportCard(){
        transportationCards.put("waterways", new transportationCard(3000, 300, 1500));
        transportationCards.put("airways", new transportationCard(11000, 1500, 5500));
        transportationCards.put("railways", new transportationCard(9500, 1200, 5500));
        transportationCards.put("roadways", new transportationCard(3500, 800, 5500));
    }
}
