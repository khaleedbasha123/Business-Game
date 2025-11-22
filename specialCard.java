import java.util.*;

class specialCard{

    ArrayList<String> specialCards = new ArrayList<>(Arrays.asList("chance", "jail", "start", "community chest", "rent house"));

}

class chance {

    static Random r = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void chance(player x) {

        switch(x.index%5){
            case 0:
                System.out.println("You are now moving location");
                Game.players.get(Game.names.get(0)).index = r.nextInt(36);
                System.out.println("Now you are at: " + Game.players.get(Game.names.get(0)).index);

            case 1:
                System.out.println("You have to pay penalty 2000");

                if(x.bankBalance<2000){
                    System.out.println("Insufficient balance, now you have two options:");

                    System.out.println("1. If you have Cards - sell to the bank and take money then pay");
                    System.out.println("2. Quit");
                    System.out.println("Enter one of your Options '1' or 'Quit'");

                    String option = new Scanner(System.in).next();
                    if(option.equals("1")){

                        System.out.println("you have: " + x.has + "select a card to sell");
                        System.out.println("Type the card name: ");
                        String select = sc.nextLine();

                        if(x.has.contains(select)){

                            x.sellCard(select);
                            x.bankBalance -= 2000;
                            System.out.println("current Balance: " + x.bankBalance);

                            // String type = Board.cardType(select);
                            // switch(type){
                            //     case "prop":
                            //         propertyCard y = propertyCard.propertyCards.get(select);
                            //         x.bankBalance += y.cost - 2000;
                            //         System.out.println("sold the card of " + y.cost + " rupees successfully");
                            //         System.out.println("current Balance: " + x.bankBalance);
                            //         break;
                            //     case "transport":
                            //         transportationCard z = transportationCard.transportationCards.get(select);
                            //         x.bankBalance += z.cost - 2000;
                            //         System.out.println("sold the card of " + z.cost + " rupees successfully");
                            //         System.out.println("current Balance: " + x.bankBalance);
                            //         break;
                            //     default:
                            //         utilityCard k = utilityCard.utilityCards.get(select);
                            //         x.bankBalance += k.cost - 2000;
                            //         System.out.println("sold the card of " + k.cost + " rupees successfully");
                            //         System.out.println("current Balance: " + x.bankBalance);
                            //         break;
                            // }

                        }
                        else{
                            System.out.println("you do not have cards, you will be eliminated");
                            String name = x.name;
                            Game.eliminate(x);
                            System.out.println(name + " have been eliminated successfully");
                        }
                    }
                    else{
                        Game.eliminate(x);
                    }
                }
                else{

                    x.bankBalance -= 2000;
                    System.out.println("Penalty paid successfully");
                    System.out.println("current Balance: " + x.bankBalance);
                }
            case 2:
                System.out.println("Hey, congrats you are receiving money");
            case 3:
                System.out.println("Bad Luck!! You have to move to jail");
            case 4:
                System.out.println("Bad Luck!! You have to move back few steps");
                System.out.println(r.nextInt(12) + 1);
        }
    }
}
