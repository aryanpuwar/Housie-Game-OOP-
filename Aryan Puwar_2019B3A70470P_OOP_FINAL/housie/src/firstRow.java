public class firstRow implements winningCondition {
    private boolean availability;
    private final String reward;

    public firstRow() {
        this.availability = false;
        this.reward = "First Row - Cadbury Dairy Milk Silk";
    }

    public boolean checkAvailability() {
        return availability;
    }

    public void setAvailability(boolean b) {
        this.availability = b;
    }

    @Override
    public String verifyCondition(Ticket t) {
        boolean win = true;
        for(int j = 0; j<9; j++){
            if(t.playerTick[0][j] != -1) {
                win = false;
                break;
            }
        }

        if(win) {
            availability = false;
            return reward;
        }
        return null;
    }

    public String  getReward()
    {
        return reward;
    }
}
