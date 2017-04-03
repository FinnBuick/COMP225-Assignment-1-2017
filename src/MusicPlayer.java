
import java.util.*;

class musicNode {
    String track;  // The name of the track
    int played= 0; // The number of times played
    int shuffleTag= 0; // For shuffling
    musicNode next;
    
    public musicNode() {		// Here's how we construct an empty list.
        next = null;
    }
    public musicNode(String t) {
        track = t; next = null;
    }
    public musicNode(String t, musicNode ptr) {
        track = t; next = ptr;
    }
    
     public boolean LTTrack(musicNode x) {   // Compares tracks according to alphabetical order on strings
    	 if (this.track.compareTo(x.track)<=0) return true;
    	 else return false;
     }
     
     public boolean LTPlayed(musicNode x) {   // Compares according to the played field.
    	 if (this.played <= x.played) return true;
    	 else return false;
     }
     
     public boolean LTTag(musicNode x) {   // Compares according to the shuffle tag.
    	 if (this.shuffleTag <= x.shuffleTag) return true;
    	 else return false;
     }
}; 

// This class represents a playlist;
// We assume that each track appears at most once in the playlist

public class MusicPlayer {
	protected musicNode head = null; // Pointer to the top of the list.
	int length=0;   // the number of nodes in the list.
    boolean debug= false;
    
    public  MusicPlayer() {
    }
    public void setToNull() {
        head = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public String firstTrack() {
        return head.track;
    }
    
    public int firstPlaycount() {
        return head.played;
    }
    
    public int firstTag() {
        return head.shuffleTag;
    }
       
    public musicNode head() {
        return head;
    }
    public void printAll() 
    {   for (musicNode tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.track.toString());
            System.out.print('\n');
    }
    
    void playTrack(String name){  // Simulates playing a track: searches for the name and increments its played field
    	musicNode tmp = head;
    	for (; tmp != null && (tmp.track.compareTo(name)!=0); tmp = tmp.next) {
    		
    	}
            if (tmp!= null) tmp.played= tmp.played+1;   	
    }
    
    void insertTrack(String name) { // Inserts a new track at the top of the list.
    	musicNode temp= new musicNode(name, head);
    	head= temp;
        length++;
   }
    
    void sortTrack() { // TODO
    	// Sorts (ascending) the list according to the name of the track
    	}
    
    void sortPlayed() {  // This is optional but might be useful for shuffling.
    	// Sorts (ascending) the list according to the number of times played
    	}
       
    int countItem(String item) {  // TODO
    	// Returns the number of times that item occurs in the current list
    	return 0;
    }
     
    musicNode checkMembership(String _track) { // TODO
    	// If the given _track is present in the current list (i.e. the node whose "track" field
    	// is equal to _track), returns the address of that node;
    	// otherwise returns null. 
    	return null;
    }
    
    void shuffle() {  // TODO
    	// Randomly shuffles the list
    }
    
    void smartShuffle () {  // TODO
    	// Shuffles the list, whilst respecting the special condition on played
    }
    
    void recommended(String[] historyList) { // TODO
    }
    
    void moveFirstNode(MusicPlayer fromList, MusicPlayer toList) { // TODO  
    	// Removes the top node of fromList and puts it onto (the top of) toList.
    	// If fromList is empty, it does nothing.
    }
}


