import org.junit.Test;

import static org.junit.Assert.*;


public class MyMusicTests {
	
	void TestPartition(){
		MusicPlayer a = new MusicPlayer();
		MusicPlayer x = null, y = null;
		
		a.insertTrack("a");
		a.insertTrack("b");
		a.insertTrack("c");
		a.insertTrack("d");
		a.insertTrack("e");
		a.insertTrack("f");
		
		a.partition(a.head, x.head, y.head);
		x.printAll();
		y.printAll();
	}
}
