public class thirdRow implements winningCondition {
    private boolean availability;
    private final String reward;

    public thirdRow() {
        this.availability = false;
        this.reward = "Third Row - Cadbury Bournville";
    }

    public boolean checkAvailability(){
        return availability;
    }

    @Override
    public void setAvailability(boolean b) {
        this.availability=b;
    }

    @Override
    public String verifyCondition(Ticket t) {
        boolean win = true;
        for (int j = 0; j < 9; j++) {
            if (t.playerTick[2][j] != -1) {
                win = false;
                break;
            }
        }

        if (win) {
            availability = false;
            return reward;
        }
        return null;
    }

    public String  getReward() {
        return reward;
    }

}