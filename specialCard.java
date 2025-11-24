import java.util.*;

// class specialCard{

//     ArrayList<String> specialCards = new ArrayList<>(Arrays.asList("chance", "jail", "start", "community chest", "rent house"));

// }

class specialCard extends card{

    static Random r = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void chance(player x) {
        String b = "" + x.index%5;
        switch(b){
            case "0":
                System.out.println("You are now moving location");
                Game.players.get(Game.names.get(0)).index = r.nextInt(36);
                System.out.println("Now you are at: " + Game.players.get(Game.names.get(0)).index);
                break;
            case "1":
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
                break;
            case "2":
                System.out.println("Hey, congrats you are receiving money");
                x.bankBalance += 2500;
                break;
            case "3":
                jail(x);
                break;
            case "4":
                moveBack(x);
                break;
        }

    }
    public static void restHouse(player x){
        System.out.println("You are in Rest House, take Some Rest");
        // skipp logic
    }

    static void moveBack(player x){
        System.out.println("You have to move back few steps");
        x.index = Math.abs(x.index - r.nextInt(12) + 1)%36;
                
        System.out.println("you have moved to " + x.index);
    }

    static void jail(player x){
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
        else{
            Game.eliminate(x);
        }
    }

    static void communityChest(player x){
        String b = ""+x.index%4;
        switch(b){
            case "0":
                System.out.println("Hey, you won a lottery!!");
                x.bankBalance += 2000;
                System.out.println("2000 rupees have been tranferred into your account");
                break;
            case "1":
                System.out.println("Pay for the community services, Donate 1000");
                if(x.bankBalance>=1000){
                    x.bankBalance -= 1000;
                    System.out.println("Paid for the community services");
                }
                else{
                    x.sellCard(1000);
                } 
                System.out.println("Your current Balance: " + x.bankBalance);
                break;
            case "2":
                jail(x);
                break;
            case "3":
                moveBack(x);
                break;
        }
    }

    static void start(player x){
        if(x.time==0){
            System.out.println("You didnt even crosses the start a single time");
        }
        else{
            System.out.println("You are receiving money 1500");
            x.bankBalance += 1500;
        }
    }
}
