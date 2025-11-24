import java.util.HashMap;

class taxCard extends card{

    static HashMap<String, taxCard> taxCards = new HashMap<>();

    int pay;
    taxCard(int pay){
        this.pay = pay;
    }

    static void setTaxCards(){
        taxCards.put("wealth tax", new taxCard(1000));
        taxCards.put("income tax", new taxCard(2000));
        taxCards.put("club", new taxCard(500));
    }
}