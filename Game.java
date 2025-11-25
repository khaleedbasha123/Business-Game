import java.util.*;

class Game{
    static ArrayList<String> names = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, player> players = new HashMap<>();

    static int nPlayers;

    static ArrayList<player> eliminated = new ArrayList<>();

    static int first = 0;

    Game(int a){
        this.nPlayers = a;
    }

    static void firstChance(){
        for(int i = 0; ;i++){
            player x = players.get(names.get(i%nPlayers));
            Random r = new Random();
            int dice1 = r.nextInt(6) + 1;
            int dice2 = r.nextInt(6) + 1;
            x.index += dice1 + dice2;
            if(x.index >= 36){
                first = i%nPlayers;
                for(int j = 0; j<nPlayers; j++){
                    player y = players.get(names.get(j%nPlayers));
                    y.index = 0;
                }
                break;
            }
        }
    }

    static int dice(){
        Random r = new Random();
        int dice1 = r.nextInt(6) + 1;
        int dice2 = r.nextInt(6) + 1;
        return dice1 + dice2;
    }
    static int dice(player x){
        Random r = new Random();
        int dice1 = r.nextInt(6) + 1;
        int dice2 = r.nextInt(6) + 1;
        if((x.index + dice1 + dice2)>=36) x.time++;

        int i = (x.index + dice1 + dice2)%36;
        x.index = i;
        return i;
    }

    static void buyOrSell(player x, String c){
        if(c.equalsIgnoreCase("jail")){
            specialCard.jail(x);
            return;
        }
        if(c.equalsIgnoreCase("chance")){
            specialCard.chance(x);
            return;
        }
        if(c.equalsIgnoreCase("community chest")){
            specialCard.communityChest(x);
            return;
        }
        if(c.equalsIgnoreCase("rest house")){
            specialCard.restHouse(x);
            return;
        }
        if(taxCard.taxCards.containsKey(c)){
            x.buyCard(c);
            return;
        }
        if(c.equalsIgnoreCase("start")){
            specialCard.start(x);
            return;
        }
        if(Bank.cards.contains(c)){
            System.out.println("your current Bank Balance: " + x.bankBalance);
            System.out.println("\nBuy Card? Type 'Yes' or 'No'");
            String s = sc.nextLine();

            if(s.equalsIgnoreCase("yes")){
                x.buyCard(c);
                // System.out.println("Card Bought Successfully!!");
            }
            else{
                System.out.println("well, you chose not to buy!!");
            }
        }
        else{
            player y = whoHasCard(c);
            System.out.println("Card is already bought by " + y.name);
            System.out.println("You have to pay rent to " + y.name);
            card type = Board.getCardType(c);
            System.out.println("Rent of " + c + " is " + type.rentSite);
        }
        // System.out.println("your current balance: " + x.bankBalance + " rupees");
    }

    static player whoHasCard(String c){
        for(int i = 0; i<nPlayers; i++){
            player x = players.get(names.get(i));
            if(x.has.contains(c)){
                return x;
            }
        }
        return null;
    }

    static void eliminate(player x){
        names.remove(x.name);
        players.remove(x.name);
        eliminated.add(x);
        nPlayers = players.size();
    }

    public static void main(String[] args) {
        propertyCard.setPropertyCards();
		transportationCard.setTransportCards();
        taxCard.setTaxCards();
        utilityCard.setUtilityCards();
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of players? ");
        int n = sc.nextInt();
        Game g = new Game(n);

        for(int i = 1; i<=n; i++){
            System.out.println("Enter your name: ");
            String playerName = sc.next();
            names.add(playerName);
            players.put(playerName, new player(playerName, 10000, 0));
        }

        firstChance();

        for(int i = first; i<12 ;i++){
            player x = players.get(names.get(i%nPlayers));
            System.out.println("Throw the dice");
            int Dice = dice(x);
            String k = sc.nextLine();
            
            System.out.println("Hey! " + names.get(i%nPlayers) +" You got: " + Dice + " Now You're on " + Board.square[Dice]);
            Board.showCardDetails(Board.square[Dice]);
            
            buyOrSell(x, Board.square[Dice]);

            // x.buyCard(Board.square[Dice]);
            // players.get(names.get(i%nPlayers)).sellCard(Board.square[Dice]);
            // rent();
            // outOfMoney();
            // eliminate();
        }

        System.out.println(names);
        System.out.println(first);
        System.out.println(Bank.cards);
        for(int i = 0; i<nPlayers; i++){
            player x = players.get(names.get(i%nPlayers));
            System.out.println(players.get(names.get(i)).has);
            System.out.println(players.get(names.get(i)).bankBalance);
            System.out.println(players.get(names.get(i)).index);
        }

    }
}