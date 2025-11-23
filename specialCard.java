import java.util.*;

// class specialCard{

//     ArrayList<String> specialCards = new ArrayList<>(Arrays.asList("chance", "jail", "start", "community chest", "rent house"));

// }

class specialCard {

    static Random r = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void chance(player x) {

        switch(x.index%5){
            case 0:
                System.out.println("You are now moving location");
                Game.players.get(Game.names.get(0)).index = r.nextInt(36);
                System.out.println("Now you are at: " + Game.players.get(Game.names.get(0)).index);

            case 1:
                System.out.println("You have to pay penalty 5000");

                if(x.bankBalance<2000){
                    System.out.println("Insufficient balance, now you have two options:");

                    System.out.println("1. If you have Cards - sell to the bank and take money then pay");
                    System.out.println("2. Quit");
                    System.out.println("Enter one of your Options '1' or 'Quit'");

                    String option = new Scanner(System.in).next();
                    if(option.equals("1")){

                        x.sellCard(5000);
                    }
                    else{
                        Game.eliminate(x);
                    }
                }
                else{
                    x.bankBalance -= 5000;
                    System.out.println("Penalty paid successfully");
                    System.out.println("current Balance: " + x.bankBalance);
                }
            case 2:
                System.out.println("Hey, congrats you are receiving money");
                x.bankBalance += 2500;
            case 3:
                System.out.println("Bad Luck!! You have to move to jail");
                System.out.println("Pay 500 or quit. Click '1' to pay");

                String option = sc.next();
                if(option.equals("1")){
                    if(x.bankBalance>=500){
                        x.bankBalance -= 500;
                        System.out.println("Paid Successfully");
                    }
                    else{
                        System.out.println("Select a card to sell");
                        x.sellCard(500);
                    }
                }
            case 4:
                System.out.println("Bad Luck!! You have to move back few steps");
                System.out.println(r.nextInt(12) + 1);
        }
    }
}
