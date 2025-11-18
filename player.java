	// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class player {

    String name;
    int bankBalance;
    int index = 0;
    ArrayList<String> has = new ArrayList<>();

    ArrayList<String> redCards = new ArrayList<>();
    ArrayList<String> yellowCards = new ArrayList<>();
    ArrayList<String> blueCards = new ArrayList<>();
    ArrayList<String> greenCards = new ArrayList<>();


    player(String name, int balance){
        this.name = name;
        this.bankBalance = balance;
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

        if(this.bankBalance>=cost){

            Bank.cards.remove(card);
            has.add(card);
            this.bankBalance-=cost;
	    addCard(card);
        }
	
    }

    void sellCard(String card){

	String type = Board.cardType(card);

        int cost = 0;

        if(type.equals("prop")){
                cost = propertyCard.propertyCards.get(card).cost;
        }
        else if(type.equals("transport")){
                cost = transportationCard.transportationCards.get(card).cost;
        }


        this.bankBalance+=cost;
        has.remove(card);
	deleteCard(card);
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
            default:
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
        else{
            return "greenCards";
        }
    }

    public static void main(String[] args){
        player p = new player("Khaleed", 15000);
	
	p.buyCard("delhi");
        System.out.println("redCards: " + p.redCards);
        System.out.println("yellowCards: " + p.yellowCards);
        System.out.println("blueCards: " + p.blueCards);
        System.out.println("greenCards: " + p.greenCards);

        p.buyCard("shimla");

	System.out.println(Bank.cards);
        System.out.println(p.has);

	p.sellCard("delhi");

        System.out.println();
        System.out.println("redCards: " + p.redCards);
        System.out.println("yellowCards: " + p.yellowCards);
        System.out.println("blueCards: " + p.blueCards);
        System.out.println("greenCards: " + p.greenCards);

        System.out.println(Bank.cards);
        System.out.println(p.has);
    }
}
