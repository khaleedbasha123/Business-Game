import java.util.HashMap;

class Board{
    static void showCardDetails(String card){
        String type = cardType(card);
        switch(type){
            case "prop":
                propertyCard x = propertyCard.propertyCards.get(card);
                System.out.println(card + ": " + x.color);
                break;
            case "transport":
                transportationCard y = transportationCard.transportationCards.get(card);
                System.out.println(card + ": " + y.cost);
                break;
            default:
                System.out.println(card + ": " + "Not Found");
                break;
        }
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
        String square[] = {"start", "cochin", "internet", "railways", "chandigarh", "income tax", "indore", "chance", "jaipur", "jail", "delhi", "ahmedabad", "electricity", "roadways", "amritsar", "goa", "community chest", "hyderabad", "club", "agra", "chance", "kanpur", "patna", "darjeeling", "ladakh", "shimla", "rest house", "chennai", "community chest", "bangalore", "wealth tax", "pune", "kolkata", "waterways", "mumbai"
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
