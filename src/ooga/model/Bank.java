package ooga.model;

public interface Bank {
    /**
     * Returns the Bank account balance to see how much money is currently saved up.
     *
     * @return The total amount of money that the player has saved up
     */
    int getBalance();

    /**
     * Increase the Bank account balance by adding money to the current balance.
     *
     * @param amount The amount of money to add to the Bank account balance
     */
    void increaseBalance(int amount);

    /**
     * Decrease the Bank account balance by subtracting money from the current balance.
     *
     * @param amount The amount of money to remove from the Bank account balance
     */
    void decreaseBalance(int amount);

    /**
     * Add money to bank account at the end of every round.
     */
    void addEndOfRoundIncomeToBalance();
}