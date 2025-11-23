import java.util.*;

class player {
    static Scanner sc = new Scanner(System.in);

    String name;
    int bankBalance;
    int index;
    ArrayList<String> has = new ArrayList<>();

    ArrayList<String> redCards = new ArrayList<>();
    ArrayList<String> yellowCards = new ArrayList<>();
    ArrayList<String> blueCards = new ArrayList<>();
    ArrayList<String> greenCards = new ArrayList<>();

    player(String name, int balance, int index){
        this.name = name;
        this.bankBalance = balance;
        this.index = index;
    }

    int dice(){
        Random r = new Random();
        int dice1 = r.nextInt(6) + 1;
        int dice2 = r.nextInt(6) + 1;
        index = (index + dice1 + dice2)%36;
        return index;
    }

    void buyCard(String card){
	    String type = Board.cardType(card);
	    int cost = 0;

	    if(type.equals("prop")){
		    cost = propertyCard.propertyCards.get(card).cost;
	    }
	    else if(type.equals("transport")){
		    cost = transportationCard.transportationCards.get(card).cost;
	    }
        else if(type.equals("util")){
            cost = utilityCard.utilityCards.get(card).cost;
        }
        else if(type.equals("tax")){
            this.bankBalance-= taxCard.taxCards.get(card).pay;
            System.out.println("Paid " + taxCard.taxCards.get(card).pay + " rupees to bank");
            return;
        }

        if(this.bankBalance>=cost){

            Bank.cards.remove(card);
            this.has.add(card);
            this.bankBalance-=cost;
	        this.addCard(card);
        }
        this.balance();
    }

    void sellCard(int target){

        System.out.println("You have these cards: " + this.has);
        for(int i = 0; i<this.has.size(); i++){
            Board.showCardDetails(this.has.get(i));
        }

        int t = 0;
        while(t<target){
            if(this.has.isEmpty()){
                System.out.println("Not Enough Money!! You're eliminated");
                Game.eliminate(this);
                break;
            }
            System.out.println("Select a card to buy: ");
            String select = sc.next();
            if(this.has.contains(select)){
                String type = Board.cardType(select);

                int cost = 0;
                if(type.equals("prop")){
                    cost = propertyCard.propertyCards.get(select).bankMortageValue;
                }
                else if(type.equals("transport")){
                    cost = transportationCard.transportationCards.get(select).bankMortageValue;
                }
                else if(type.equals("util")){
                    cost = utilityCard.utilityCards.get(select).bankMortageValue;
                }
                t += cost;
                this.has.remove(select);
	            this.deleteCard(select);
                System.out.println("Sold " + select + " successfully!");
            }
            else{
                System.out.println("Please Enter correct card");
            }
        }

        this.bankBalance += t;
        this.balance();
    }

    void deleteCard(String card){
        String colorCard = divideCards(card);
        switch(colorCard){
            case "redCards":
                redCards.remove(card);
                break;
            case "yellowCards":
                yellowCards.remove(card);
                break;
            case "blueCards":
                blueCards.remove(card);
                break;
            default:
                greenCards.remove(card);
                break;
        }
    }

    void addCard(String card){
        String colorCard = divideCards(card);

        switch(colorCard){
            case "redCards":
                redCards.add(card);
                break;
            case "yellowCards":
                yellowCards.add(card);
                break;
            case "blueCards":
                blueCards.add(card);
                break;
            case "greenCards":
                greenCards.add(card);
                break;
        }
    }

    String divideCards(String card){
        if(card.equals("shimla") || card.equals("ladakh") || card.equals("darjeeling") || card.equals("chandigarh") || card.equals("cochin")){
            return "redCards";
        }
        else if(card.equals("amritsar") || card.equals("bangalore") || card.equals("chennai") || card.equals("hyderabad") || card.equals("goa")){
            return "yellowCards";
        }
        else if(card.equals("patna") || card.equals("kanpur") || card.equals("agra") || card.equals("jaipur") || card.equals("indore")){
            return "blueCards";
        }
        else if(card.equals("mumbai") || card.equals("kolkata") || card.equals("pune") || card.equals("ahmedabad") || card.equals("delhi")){
            return "greenCards";
        }
        else{
            return "";
        }   
    }

    void balance(){
        System.out.println("Your Current Balance: " + this.bankBalance);
    }

    // public static void main(String[] args){
    //     player p = new player("Khaleed", 15000);
	
	//     p.buyCard("delhi");
    //     System.out.println("redCards: " + p.redCards);
    //     System.out.println("yellowCards: " + p.yellowCards);
    //     System.out.println("blueCards: " + p.blueCards);
    //     System.out.println("greenCards: " + p.greenCards);

    //     p.buyCard("shimla");

	//     System.out.println(Bank.cards);
    //     System.out.println(p.has);

	//     p.sellCard("delhi");

    //     System.out.println();
    //     System.out.println("redCards: " + p.redCards);
    //     System.out.println("yellowCards: " + p.yellowCards);
    //     System.out.println("blueCards: " + p.blueCards);
    //     System.out.println("greenCards: " + p.greenCards);

    //     System.out.println(Bank.cards);
    //     System.out.println(p.has);
    // }
}
