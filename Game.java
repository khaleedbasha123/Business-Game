// first chance
// dice
// buy property or not
import java.util.*;

class Game{

    static ArrayList<String> players = new ArrayList<>();
    static ArrayList<Integer> playersCurrentIndex = new ArrayList<>();
    static int nPlayers;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of players? ");
        int n = sc.nextInt();
        Game g = new Game(n);

        for(int i = 1; i<=n; i++){
            System.out.println("Enter your name: ");
            players.add(sc.next());
            playersCurrentIndex.add(0);
        }

        firstChance();

        System.out.println(players);
        System.out.println(playersCurrentIndex);
        System.out.println(first);
    }
}