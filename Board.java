
class Board{
    static void showCardDetails(String card){
        String type = cardType(card);
        switch(type){
            case "prop":
                propertyCard x = propertyCard.propertyCards.get(card);
                printProperty(x, card);
                break;
            case "transport":
                transportationCard y = transportationCard.transportationCards.get(card);
                printTransport(y, card);
                break;
            default:
            //    System.out.println(card + ": " + "Not Found");
                break;
        }
    }
    
    static void printProperty(propertyCard x, String card){
        String a = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
        System.out.println(a);
        System.out.println("+++++++++++ card: " + card.toUpperCase() + " +++++++++++" );
        System.out.println(card + " color: " + x.color);
        System.out.println(card + " cost: " + x.cost);
        System.out.println(card + " rentSite: " + x.rentSite);
        System.out.println(card + " oneHouse: " + x.oneHouse);
        System.out.println(card + " twoHouses: " + x.twoHouses);
        System.out.println(card + " threeHouses: " + x.threeHouses);
        System.out.println(card + " hotel: " + x.hotel);
        System.out.println(card + " costOfHouse: " + x.costOfHouse);
        System.out.println(card + " costOfHotel: " + x.costOfHotel);
        System.out.println(card + " bankMortageValue: " + x.bankMortageValue);
        System.out.println(a);
        System.out.println();
    }
    
    static void printTransport(transportationCard x, String card){
        String a = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
        System.out.println(a);
        System.out.println("++++++++++++ card: "  + card.toUpperCase() + "++++++++++++");
        System.out.println(card + " cost: " + x.cost);
        System.out.println(card + " rent: " + x.rent);
        System.out.println(card + " bankMortageValue: " + x.bankMortageValue);
        System.out.println(a);
        System.out.println();
    }
    
    static String cardType(String card){
        if(propertyCard.propertyCards.containsKey(card)){
            return "prop";
        }
        else if(transportationCard.transportationCards.containsKey(card)){
            return "transport";
        }
        else{
            return "special";
        }
    }
    public static void main(String[] args){
        String square[] = {"start", "cochin", "internet", "railways", "chandigarh", "income tax", "indore", "chance", "jaipur", 
                           "jail", "delhi", "ahmedabad", "electricity", "roadways", "amritsar", "goa", "community chest", "hyderabad", 
                           "club", "agra", "chance", "kanpur", "patna", "darjeeling", "ladakh", "shimla", "rest house", "chennai", 
                           "community chest", "bangalore", "wealth tax", "pune", "kolkata", "waterways", "mumbai"
			            };
			  
		propertyCard.setPropertyCards();
		transportationCard.setTransportCard();
		int a = 0;
        while(a<square.length){
            String place = square[a];
            showCardDetails(place);
            a++;
        }
    }
}
