import java.util.ArrayList;

public class Player implements Runnable{
    public String playerName;
    public int playerId;
    Ticket playerTicket;
    GameData gameData;
    ArrayList<winningCondition> wincond;
    ArrayList<String> prizeWon;

    Player(int i,String s,GameData gameData) {
        this.playerId=i;
        this.playerName=s;
        this.gameData = gameData;
        prizeWon = new ArrayList<String>();
    }
    
    void setWinCond(ArrayList<winningCondition> wc){
        wincond = wc;
    }
    
    public boolean hasCurrentNumber(int n){
        for(int i=0;i<3;i++)
        {
            for (int j=0;j<9;j++)
            {
                if(playerTicket.playerTick[i][j]==n)
                {
                    playerTicket.playerTick[i][j]=-1;
                    System.out.println(n + " Crossed out in "+playerName+"'s ticket");
                    return true;
                }
            }
        }
        return false;
    }

    public String verifyWin(ArrayList<winningCondition> wincond){
        for(int i=0;i<4;i++)
        {
            if(wincond.get(i).checkAvailability())
            {
                return wincond.get(i).verifyCondition(playerTicket);
            }
        }
        return null;
    }
    
    @Override
    public void run() {
		
		synchronized(gameData.lock1) {			
			
			while(!gameData.gameCompleteFlag) { 
								  
				while(!gameData.noAnnouncedFlag || gameData.playerChanceFlag.get(playerId)) {
					try {
						gameData.lock1.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if(hasCurrentNumber(gameData.announcedNumber)){
				    String temp=verifyWin(wincond);
                    if(temp!=null){
                        prizeWon.add(playerName + ": " + temp);
                        System.out.println(playerName+" won "+ temp);
                    }
				}
				// player sets its chance flag 
				gameData.playerChanceFlag.set(playerId, true);
					
				gameData.lock1.notifyAll();
				}
			}
		}
	}
