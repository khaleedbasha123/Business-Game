
class Board{

    static final String square[] = {"start", "cochin", "internet", "railways", "chandigarh", "income tax", "indore", "chance", "jaipur", 
                                "jail", "delhi", "ahmedabad", "electricity", "roadways", "amritsar", "goa", "community chest", "hyderabad", 
                                "club", "agra", "chance", "kanpur", "patna", "darjeeling", "airways", "ladakh", "shimla", "rest house", 
                                "chennai", "community chest", "bangalore", "wealth tax", "pune", "kolkata", "waterways", "mumbai"
			                };
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
            case "tax":
                taxCard z = taxCard.taxCards.get(card);
                printTax(z, card);
            case "util":
                utilityCard a = utilityCard.utilityCards.get(card);
                printUtility(a, card);
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
        System.out.println(card + " rent: " + x.rentSite);
        System.out.println(card + " bankMortageValue: " + x.bankMortageValue);
        System.out.println(a);
        System.out.println();
    }

    static void printUtility(utilityCard x, String card){
        String a = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
        System.out.println(a);
        System.out.println("++++++++++++ card: "  + card.toUpperCase() + "++++++++++++");
        System.out.println(card + " cost: " + x.cost);
        System.out.println(card + " rent: " + x.rentSite);
        System.out.println(card + " bankMortageValue: " + x.bankMortageValue);
        System.out.println(a);
        System.out.println();
    }

    static void printTax(taxCard x, String card){
        String a = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
        System.out.println("++++++++++++ card: "  + card.toUpperCase() + "++++++++++++");
        System.out.println("you have to pay " + x.pay + " rupees");
    }

    static card getCardType(String card){
        if(propertyCard.propertyCards.containsKey(card)){
            return propertyCard.propertyCards.get(card);
        }
        else if(transportationCard.transportationCards.containsKey(card)){
            return transportationCard.transportationCards.get(card);
        }
        else{
            return utilityCard.utilityCards.get(card);
        }
    }
    
    static String cardType(String card){
        if(propertyCard.propertyCards.containsKey(card)){
            return "prop";
        }
        else if(transportationCard.transportationCards.containsKey(card)){
            return "transport";
        }
        else if(taxCard.taxCards.containsKey(card)){
            return "tax";
        }
        else if(utilityCard.utilityCards.containsKey(card)){
            return "util";
        }
        else{
            return "special";
        }
    }
    // public static void main(String[] args){
    //     String square[] = {"start", "cochin", "internet", "railways", "chandigarh", "income tax", "indore", "chance", "jaipur", 
    //                        "jail", "delhi", "ahmedabad", "electricity", "roadways", "amritsar", "goa", "community chest", "hyderabad", 
    //                        "club", "agra", "chance", "kanpur", "patna", "darjeeling", "ladakh", "shimla", "rest house", "chennai", 
    //                        "community chest", "bangalore", "wealth tax", "pune", "kolkata", "waterways", "mumbai"
	// 		            };
			  
		// propertyCard.setPropertyCards();
		// transportationCard.setTransportCard();
	// 	int a = 0;
    //     while(a<square.length){
    //         String place = square[a];
    //         showCardDetails(place);
    //         a++;
    //     }
    // }
}