import java.util.*;

class Game{
    static ArrayList<String> names = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, player> players = new HashMap<>();
    static ArrayList<Integer> playersCurrentIndex = new ArrayList<>();
    static int nPlayers;

    static ArrayList<String> eliminated = new ArrayList<>();

    static int first = 0;

    Game(int a){
        this.nPlayers = a;
    }

    static void firstChance(){
        for(int i = 0; ;i++){
            Random r = new Random();
            int dice1 = r.nextInt(6) + 1;
            int dice2 = r.nextInt(6) + 1;
            if((playersCurrentIndex.get(i%nPlayers)+dice1+dice2) >= 36){
                first = i%nPlayers;
                for(int j = 0; j<nPlayers; j++){
                    playersCurrentIndex.set(j%nPlayers, 0);
                }
                break;
            }
            else{
                playersCurrentIndex.set(i%nPlayers, playersCurrentIndex.get(i%nPlayers) + dice1 + dice2);
            }
        }
    }

    static int dice(int index){
        Random r = new Random();
        int dice1 = r.nextInt(6) + 1;
        int dice2 = r.nextInt(6) + 1;
        int i = (playersCurrentIndex.get(index) + dice1 + dice2)%36;
        playersCurrentIndex.set(index, i);
        return i;
    }

    static void buyOrSell(player x, String c){
        if(taxCard.taxCards.containsKey(c)){
            x.buyCard(c);
            return;
        }
        if(Bank.cards.contains(c)){
            System.out.println("Buy Card? Type 'Yes' or 'No'");
            String s = sc.nextLine();

            if(s.equalsIgnoreCase("yes")){
                x.buyCard(c);
                Bank.cards.remove(c);
                System.out.println("Card Bought Successfully!!");
            }
            else{
                System.out.println("well, you chose not to buy!!");
            }
        }
        else{
            player y = whoHasCard(c); 
            System.out.println("Card is already bought by " + y.name);
        }
        System.out.println("your current balance: " + x.bankBalance + " rupees");
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
        playersCurrentIndex.remove(x.index);
        nPlayers--;
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
            players.put(playerName, new player(playerName, 10000, i-1));
            playersCurrentIndex.add(0);
        }

        firstChance();

        for(int i = first; i<12 ;i++){
            System.out.println("Throw the dice");
            int Dice = dice(i%nPlayers);
            String k = sc.nextLine();
            player x = players.get(names.get(i%nPlayers));
            System.out.println("Hey! " + names.get(i%nPlayers) +" You got: " + Dice + " Now You're on " + Board.square[Dice]);
            Board.showCardDetails(Board.square[Dice]);
            
            buyOrSell(x, Board.square[Dice]);

            // x.buyCard(Board.square[Dice]);
            // players.get(names.get(i%nPlayers)).sellCard(Board.square[Dice]);
            // rent();
            // outOfMoney();
            // eliminate();
        }

        System.out.println(players);
        System.out.println(playersCurrentIndex);
        System.out.println(first);
        System.out.println(Bank.cards);
        for(int i = 0; i<nPlayers; i++){
            player x = players.get(names.get(i%nPlayers));
            System.out.println(players.get(names.get(i)).has);
            System.out.println(players.get(names.get(i)).bankBalance);
        }
    }
}