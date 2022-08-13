public interface winningCondition {
    public boolean checkAvailability();
    public void setAvailability(boolean b);
    String verifyCondition(Ticket t);
    String getReward();
}
