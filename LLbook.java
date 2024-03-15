public class LLbook {
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