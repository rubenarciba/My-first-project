import java.io.File;
import java.util.Scanner;

/* Ruben Arciba
   [CS1101] Comprehensive Lab 2
   This work is to be done individually. It is not permitted to. 
   share, reproduce, or alter any part of this assignment for any 
   purpose. Students are not permitted from sharing code, uploading 
   this assignment online in any form, or viewing/receiving/
   modifying code written from anyone else. This assignment is part. 
   of an academic course at The University of Texas at El Paso and 
   a grade will be assigned for the work produced individually by 
   the student.
   */


public class Arciba_CL3{
    public static void main(String[] args) throws Exception{
        
        // reading the file to convert it into an array
        File file = new File("/Users/rubenarciba/Desktop/pokemonList.txt");
            Scanner scan = new Scanner(file);

            
            int counter = 0;
            while(scan.hasNextLine()){
                 counter++;
                 scan.nextLine();
            }
            
            String pokemonBox[][] = new String[counter][13];

            scan = new Scanner(file);

            int index = 0;
            while(scan.hasNextLine()){

                String line = scan.nextLine();
                pokemonBox[index] = line.split(",");
                index++;
            }

        // nodes of pokemons
       LLNode head =  new LLNode(pokemonBox[1]);

       LL pkmnParty = new LL(head);

        boolean exit = false;
        while(exit == false){
            // manu of the game
            Scanner input2 = new Scanner(System.in);

            System.out.println("-------------------------------");
            System.out.println("Welcome to the Pokemon Center\n" + 
                                "Pleace select on of the forllowing options\n" + 
                                "1) View Box\n" + 
                                "2) View Party \n" +
                                "3) Deposit Pokemon (add to party)\n" +
                                "4) Withdraw Pokemon (remove from party)\n" +
                                "5) View Pokemon Stats\n" +
                                "6) Log Out");
            int option = input2.nextInt();
          
            //done
            // option 1 of the menu
            if(option == 1){

                Scanner input = new Scanner(System.in);

                System.out.println("Chose a filter criteria (only one), or type anything else to see everyone in the box \n"+
                                    "-Level\n" +
                                    "-Generation");
                 String filter = input.next();

                displayPokemon(pokemonBox, filter);
            }
            
            else if(option == 2){

                pkmnParty.displayParty(pkmnParty.head);
            }
    
            
            else if(option == 3){

                Scanner input = new Scanner(System.in);
                System.out.println("Enter name of the pokemon you whant to add: ");
                String pokemon = input.next();

                if(pkmnParty.inParty(pokemon)){
                    System.out.println("Pokemon in party.");
                }
                else {
                    LLNode pkmn = null;
                    for(int row = 1; row<pokemonBox.length; row++){
                        if(pokemonBox[row][1].equals(pokemon)){
                            pkmn = new LLNode(pokemonBox[row]);
                        }
                    }
                        pkmnParty.addToParty(pkmn);
                }
            }
        
            else if(option == 4){

                Scanner input = new Scanner(System.in);
                System.out.println("Enter name of the pokemon you whant to remove from party: ");
                String pokemon = input.next();

                pkmnParty.inParty(pokemon);
                pkmnParty.removeFromParty(pokemon);
            }
            
            else if(option ==5 ){

                Scanner input = new Scanner(System.in);
                System.out.println("Enter the pokemon you whant to view: ");
                String toView = input.next();

                
                for(int row = 1; row<pokemonBox.length; row++){
                    if(pokemonBox[row][1].equals(toView)){
                        for(int colum = 1; colum<pokemonBox[row].length; colum++){


                            System.out.print(pokemonBox[row][colum] + " ");
                        }
                        System.out.println();
                    }
                }

            }
            
            else if(option == 6){
                System.out.println("Ending program....");
                System.exit(0);
            }
        }
    }
    /**
     * This method displays all the Pokemon, given the type of filter, if no valid filter is given, display all Pokemon
     * 
     * @param pokemonBox
     * @param filter
     * @return void
     */
    public static void displayPokemon(String[][] pokemonBox, String filter){

       Scanner input = new Scanner(System.in);

      
        if(filter.equals("Level")){

            System.out.println("Enter lower bound  level you whant to filter by (min 1, max 100): ");
            int lower = input.nextInt();

            System.out.println("Enter upper bound level you whant to filter by (min 1, max 100): ");
            int upper = input.nextInt();

            for(int row = 1; row<pokemonBox.length; row++){
                if(Integer.parseInt(pokemonBox[row][4])>=lower && Integer.parseInt(pokemonBox[row][4])<=upper){
                    System.out.println(pokemonBox[row][0] + ") " + pokemonBox[row][1] + " Level: " + pokemonBox[row][4]);
                }
            }
        } 

        else if (filter.equals("Generation")){

            System.out.println("pleace enter the generation by which you what to filter by (Only gens 1, 2, and 3 are available): ");
            int gen = input.nextInt();

            for(int row = 1; row < pokemonBox.length; row++){
                if(Integer.parseInt(pokemonBox[row][12]) == gen){
                    System.out.println(pokemonBox[row][0] + ") " + pokemonBox[row][1] + " Gen: " + pokemonBox[row][12]);
                }

            }

        }

        else{
            for(int row = 1; row < pokemonBox.length; row++){
                for(int colum = 0; colum<pokemonBox[row].length; colum++){
                    System.out.print(pokemonBox[row][colum] + " ");
                }
                System.out.println();
            }
        }
    } 
}