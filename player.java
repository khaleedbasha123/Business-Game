// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.ArrayList;

class player {
    String name;
    int balance;
    ArrayList<String> redCards = new ArrayList<>();
    ArrayList<String> yellowCards = new ArrayList<>();
    ArrayList<String> blueCards = new ArrayList<>();
    ArrayList<String> greenCards = new ArrayList<>();
        
    player(String name, int balance){
        this.name = name;
        this.balance = balance;
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
        p.addCard("jaipur");
        p.addCard("delhi");
        p.addCard("goa");
        p.addCard("pune");
        p.addCard("ladakh");
        p.addCard("shimla");
        System.out.println("redCards: " + p.redCards);
        System.out.println("yellowCards: " + p.yellowCards);
        System.out.println("blueCards: " + p.blueCards);
        System.out.println("greenCards: " + p.greenCards);
        p.deleteCard("pune");
        p.deleteCard("shimla");
        System.out.println();
        System.out.println("redCards: " + p.redCards);
        System.out.println("yellowCards: " + p.yellowCards);
        System.out.println("blueCards: " + p.blueCards);
        System.out.println("greenCards: " + p.greenCards);
    }
}
