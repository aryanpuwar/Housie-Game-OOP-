public class fullHouse implements winningCondition {
    private boolean availability;
    private final String reward;

    public fullHouse() {
        this.availability = false;
        this.reward = "Full House - Cadbury Gift Hamper";
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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (t.playerTick[i][j] != -1) {
                    win = false;
                    break;
                }
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