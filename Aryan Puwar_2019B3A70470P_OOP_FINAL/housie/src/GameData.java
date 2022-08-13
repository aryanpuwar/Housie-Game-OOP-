import java.util.*;
public class GameData {
	public int announcedNumber = 0;	 
	public boolean gameCompleteFlag = false;	
	public boolean noAnnouncedFlag = false;
	public ArrayList<Boolean> playerChanceFlag;
	public Object lock1 = new Object();
	
	GameData(int numberOfPlayers){
	    playerChanceFlag = new ArrayList<Boolean>(numberOfPlayers);
	    for(int i=0;i<numberOfPlayers;i++){
	        playerChanceFlag.add(false);
	    }
	}
	
	void setPlayersChanceFlagFalse(){
	    for(int i=0;i<playerChanceFlag.size();i++){
	        playerChanceFlag.set(i,false);
	    }
	}
	
	boolean everyPlayerChanceOver(){
	    for(Boolean b : playerChanceFlag){
	        if(b == false){
	            return false;
	        }
	    }
	    return true;
	}
}