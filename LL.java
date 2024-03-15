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
public class LL {
    LLNode head;
    LLNode tail;
    int size;

    public LL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public LL(LLNode pkmn){
        this.head = pkmn;
        this.tail = pkmn;
        this.size = 1;
    }

    /**
     * This method will recursively traverse the linked list and return the Pokémon we are searching for
     * if the Pokémon is not in the party, it will simply return an array with an empty string.
     * 
     * Must be done recursively
     *
     * @param currNode
     * @param getPokemon
     * @return the String array representing the pokemon we were looking for in the linked list
     *  or an empty String array if the Pokemon is not in the party
     */
    public String[] getFromParty(LLNode currNode, String getPokemon){

       if(currNode==null){
        return new String[1];
       }

       if(currNode.pokemon[1].equals(getPokemon)){
        return currNode.pokemon;
       } 

       return getFromParty(currNode.next, getPokemon);
        
    }

    /**
     * This method will add a Pokémon to the party at the end and increase the size count of the linked list
     * Don't forget to update the size of the linked list when adding a Pokemon to the party
     * @param pkmn
     * @return void
     */
    public void addToParty(LLNode pkmn){

        if(size==0){
            head=pkmn;
            tail=pkmn;
            size++;
            System.out.println("Pokemon added!");
        }
        else if (size<6){
            tail.next = pkmn;
            tail=pkmn;
            size++;
            System.out.println("Pokemon added!");
        }

        else if(size==6){
            System.out.println("Pokemon cannot be added. Party is full.");
        }
    } 

    /**
     * This method will remove a Pokémon from the party, regardless of its position in the list, and decrease the size count of the linked list
     * Don't forget to update the size of the linked list when removing a Pokemon
     * @param pkmnName
     * @return the String array representing the Pokemon being removed from the party (linked list)
     */
    public String[] removeFromParty(String pkmnName){

        String[] toRemove = new String[1];

        if(head.pokemon[1].equals(pkmnName)){
            toRemove = head.pokemon;
            head=head.next;
            size--;
            System.out.println("Pokemon removed!");
            return toRemove;
        }

        LLNode current = head;

        while(current.next != null){
            if (current.next.pokemon[1].equals(pkmnName)){
                toRemove = current.pokemon;
                current.next=current.next.next;
            }
            current=current.next;
            size--;
             System.out.println("Pokemon removed!");
        }
        return toRemove; 
        
    }

 
    /**
     * This method will traverse through the linked list recursively and display all of the Pokémon's name 
     * and their level in it in order from first to last
     * 
     * Must be done recursively
     * 
     * @param headNode
     * @return void, the method will only print the Pokemon names and levels in order
     */
    public void displayParty(LLNode headNode){

        if(headNode==null){
            return;
        }

        System.out.print(headNode.pokemon[1] + " " + "Level: " + headNode.pokemon[4] + "\n");

        displayParty(headNode.next);

    }

    // This method checks if a given Pokémon is in the party or not
    /**
     * This method checks if a given Pokémon is in the party or not
     * 
     * @param pokemonName
     * @return boolean representing whether the input Pokemon is in the party or not
     */
    public boolean inParty(String pokemonName){

        while(head.next!=null){
            if(head.pokemon[1].equals(pokemonName)){
                return true;
            }
            return false; // If we traverse the entire list without finding the Pokémon, return false
        }  
        return false;  
    }
}
