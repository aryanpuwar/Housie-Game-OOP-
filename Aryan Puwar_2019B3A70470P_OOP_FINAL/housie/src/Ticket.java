public class Ticket {
    public int[][] playerTick = new int[3][9];

    public Ticket(int[][] playerTicket) {
        this.playerTick = playerTicket;
    }

    public int[][] getPlayerTicket() {
        return playerTick;
    }

    public void printTicket(){
        for (int i=0;i<3;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(playerTick[i][j]==-1)
                {
                    System.out.print("   *");
                }
                else {
                    System.out.printf("%4d",playerTick[i][j]);
                }
            }
            System.out.println();
        }
    }
}


