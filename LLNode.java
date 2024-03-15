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
public class LLNode {
    String[] pokemon;
    LLNode next;

    public LLNode(){
        this.pokemon = new String[1];
        this.next = null;
    }

    public LLNode(String[] pkmn){
        this.pokemon = pkmn;
        this.next = null;
    }
}
