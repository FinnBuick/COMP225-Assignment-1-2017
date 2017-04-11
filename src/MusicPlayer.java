
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
    
    public void setHead(musicNode el){ //setter
    	head = el;
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
    	MusicPlayer a = new MusicPlayer();
    	MusicPlayer b = new MusicPlayer();

    	
    	if(head == null || head.next == null)// Checks if the list is empty or if we have reached the end of the list
    		return;
    	
    	partition(head, a, b); // split list in half (JAVA OBJECTS ARE NOT PASS BY REFERENCE?)
    	
    	a.sortTrack(); //recurse first half
    	b.sortTrack(); //recurse second half
    	
    	head = mergeListsByTrack(a.head,b.head); 
    	
    	}
    
    
    void sortPlayed() {  // This is optional but might be useful for shuffling.
    	// Sorts (ascending) the list according to the number of times played
    	MusicPlayer a = new MusicPlayer();
    	MusicPlayer b = new MusicPlayer();

    	
    	if(head == null || head.next == null)// Checks if the list is empty or if we have reached the end of the list
    		return;
    	
    	partition(head, a, b); // split list in half (JAVA OBJECTS ARE NOT PASS BY REFERENCE?)
    	
    	a.sortTrack(); //recurse first half
    	b.sortTrack(); //recurse second half
    	
    	head = mergeListsByPlayed(a.head,b.head); 
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
    	if(fromList.isEmpty())
    		return;
    	else{
    		musicNode tmp = fromList.head; // Save top of fromList
    		fromList.head = fromList.head.next; // increment head
    		tmp.next = toList.head;
    		toList.head = tmp;
    	}
    	
    }
    
	void partition(musicNode head, MusicPlayer front, MusicPlayer back){ // front and back be null
    	// Splits the given list in half 
    	musicNode slow;
    	musicNode fast;
    	
    	if(head == null || head.next == null){// Checks if the list is empty or if we have reached the end of the list
    		front.setHead(head);
    		back.setToNull();
    	} else {
    		slow = head;
    		fast = head.next;
    		
    		while(fast != null){
    			
    			fast = fast.next;
    			
    			if(fast != null){
    				slow = slow.next;
    				fast = fast.next;
    			}
    	
    		}
    		front.setHead(head);
    		back.setHead(slow.next);
    		slow.next = null;
    	}
    }
	
    musicNode mergeListsByTrack(musicNode l1, musicNode l2) {
    	musicNode mergedList = null;
    	
    	if(l1 == null)
    		return l2;
    	else if(l2 == null)
    		return l1;
    	
    	if(l1.LTTrack(l2)){
    		mergedList = l1;
    		mergedList.next = mergeListsByTrack(l1.next, l2);
    	}else{
    		mergedList = l2;
    		mergedList.next = mergeListsByTrack(l1, l2.next);
    	}
    	
		return mergedList;
	}
    
    musicNode mergeListsByPlayed(musicNode l1, musicNode l2) {
    	musicNode mergedList = null;
    	
    	if(l1 == null)
    		return l2;
    	else if(l2 == null)
    		return l1;
    	
    	if(l1.LTPlayed(l2)){
    		mergedList = l1;
    		mergedList.next = mergeListsByPlayed(l1.next, l2);
    	}else{
    		mergedList = l2;
    		mergedList.next = mergeListsByPlayed(l1, l2.next);
    	}
    	
		return mergedList;
	}
}


