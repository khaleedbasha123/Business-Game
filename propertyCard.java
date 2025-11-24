import java.util.HashMap;

class propertyCard extends card{
    String color;
    int index, oneHouse, twoHouses, threeHouses, hotel;
    int costOfHouse, costOfHotel;
    
    static HashMap<String, propertyCard> propertyCards = new HashMap<>();
    
    propertyCard(String color, int cost, int rentSite, int oneHouse, int twoHouses, int threeHouses, int hotel, int costOfHouse, int costOfHotel, int bankMortageValue){
        this.color = color;
        this.index = index;
        this.cost = cost;
        this.rentSite = rentSite;
        this.oneHouse = oneHouse;
        this.twoHouses = twoHouses;
        this.threeHouses = threeHouses;
        this.hotel = hotel;
        this.costOfHouse = costOfHouse;
        this.costOfHotel = costOfHotel;
        this.bankMortageValue = bankMortageValue;
    }
    
    static void setPropertyCards(){
        propertyCards.put("shimla", new propertyCard("red", 3500, 500, 1200, 2700, 4500, 6000, 3000, 3000, 1750));
        propertyCards.put("ladakh", new propertyCard("red", 6500, 800, 3200, 4500, 6500, 8000, 6000, 6000, 4000));
        propertyCards.put("darjeeling", new propertyCard("red", 2500, 1200, 4000, 5500, 7500, 9000, 7500, 7500, 1250));
        propertyCards.put("chandigarh", new propertyCard("red", 4000, 300, 1200, 3000, 4500, 6000, 5000, 5000, 2000));
        propertyCards.put("cochin", new propertyCard("red", 3000, 400, 2200, 3500, 5000, 6500, 4500, 4500, 1500));
        propertyCards.put("amritsar", new propertyCard("yellow", 4500, 300, 1400, 2800, 4000, 5000, 4500, 4500, 2250));
        propertyCards.put("bangalore", new propertyCard("yellow", 5000, 900, 3500, 5000, 7000, 8500, 6500, 6500, 3000));
        propertyCards.put("chennai", new propertyCard("yellow", 7000, 400, 1500, 3000, 4500, 5500, 4500, 4500, 3000));
        propertyCards.put("hyderabad", new propertyCard("yellow", 3500, 200, 1200, 2600, 3500, 5000, 3000, 3000, 1750));
        propertyCards.put("goa", new propertyCard("yellow", 4000, 700, 3000, 4300, 5500, 7500, 5000, 5000, 2500));
        propertyCards.put("patna", new propertyCard("blue", 2000, 200, 900, 1600, 2500, 3500, 3000, 3000, 1000));
        propertyCards.put("kanpur", new propertyCard("blue", 4000, 400, 1500, 3000, 4500, 5500, 4500, 4500, 2000));
        propertyCards.put("agra", new propertyCard("blue", 6500, 100, 600, 1500, 2500, 3500, 2000, 2000, 4000));
        propertyCards.put("jaipur", new propertyCard("blue", 3000, 200, 800, 1600, 2300, 4500, 2500, 2500, 1500));
        propertyCards.put("indore", new propertyCard("blue", 1500, 200, 1500, 2700, 4000, 5500, 4000, 4000, 750));
        propertyCards.put("mumbai", new propertyCard("green", 9000, 900, 3500, 5000, 7000, 8500, 5000, 5000, 5500));
        propertyCards.put("kolkata", new propertyCard("green", 4000, 400, 1500, 3000, 4200, 5000, 3500, 3500, 2200));
        propertyCards.put("pune", new propertyCard("green", 3000, 200, 900, 1600, 2500, 3500, 3000, 3000, 1250));
        propertyCards.put("ahmedabad", new propertyCard("green", 3500, 200, 1000, 2500, 3500, 4500, 3000, 3000, 1750));
        propertyCards.put("delhi", new propertyCard("green", 6000, 300, 1500, 2700, 4000, 5500, 4000, 4000, 3000));
    }
}
