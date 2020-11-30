package ooga.controller.Properties;

import static ooga.controller.Controller.PROPERTY_DIRECTORY;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class BankProperties {

  private static final String BANK_DIRECTORY = "Bank/";
  private static final String DEFAULT_BANK_PROPS = "defaultBank.properties";
  private String myBankProperties;

  private static final String PASSIVE_INCOME_KEY = "passive_income";
  private static final double DEFAULT_PASSIVE_INCOME = 1;
  private double passiveIncome;
  private static final String END_OF_ROUND_INCOME_KEY = "end_of_round_income";
  private static final double DEFAULT_END_OF_ROUND_INCOME = 100;
  private double endOfRoundIncome;
  private static final String MONEY_MULTIPLIER_KEY = "money_multiplier";
  private static final double DEFAULT_MONEY_MULTIPLIER = 1;
  private double moneyMultiplier;
  private static final String INITIAL_BALANCE_KEY = "initial_balance";
  private static final double DEFAULT_INITIAL_BALANCE = 500;
  private double initialBalance;

  private Properties prop = new Properties();
  private InputStream PROPERTIES_INPUT_STREAM;

  /**
   * Reads in properties for the bank
   * @param bankProps location of the properties file
   * @throws IOException
   */
  public BankProperties(Optional<String> bankProps) throws IOException {
    if(bankProps.isEmpty()){
      myBankProperties = DEFAULT_BANK_PROPS;
    } else {
      myBankProperties = bankProps.get();
    }
    PROPERTIES_INPUT_STREAM  = getClass().getClassLoader().getResourceAsStream(PROPERTY_DIRECTORY+ BANK_DIRECTORY
        + myBankProperties);
    prop.load(PROPERTIES_INPUT_STREAM);
    setMoneyMultiplier();
    setEndOfRoundIncome();
    setPassiveIncome();
    setInitialBalance();
  }

  private void setPassiveIncome() {
    if(prop.keySet().contains(PASSIVE_INCOME_KEY)) {
      passiveIncome = Double.parseDouble(prop.getProperty(PASSIVE_INCOME_KEY));
    } else {
      passiveIncome = DEFAULT_PASSIVE_INCOME;
    }
  }

  private void setEndOfRoundIncome() {
    if(prop.keySet().contains(END_OF_ROUND_INCOME_KEY)) {
      endOfRoundIncome = Double.parseDouble(prop.getProperty(END_OF_ROUND_INCOME_KEY));
    } else {
      endOfRoundIncome = DEFAULT_END_OF_ROUND_INCOME;
    }
  }

  private void setMoneyMultiplier() {
    if(prop.keySet().contains(MONEY_MULTIPLIER_KEY)) {
      moneyMultiplier = Double.parseDouble(prop.getProperty(MONEY_MULTIPLIER_KEY));
    } else {
      moneyMultiplier = DEFAULT_MONEY_MULTIPLIER;
    }
  }

  private void setInitialBalance() {
    if(prop.keySet().contains(INITIAL_BALANCE_KEY)) {
      initialBalance = Double.parseDouble(prop.getProperty(INITIAL_BALANCE_KEY));
    } else {
      initialBalance = DEFAULT_INITIAL_BALANCE;
    }
  }

  /**
   * @return passive income for the player
   */
  public double getPassiveIncome(){
    return passiveIncome;
  }

  /**
   * @return end of round income for the player
   */
  public double getEndOfRoundIncome(){
    return endOfRoundIncome;
  }

  /**
   * @return money multiplier
   */
  public double getMoneyMultiplier(){
    return moneyMultiplier;
  }

  /**
   * @return initial balance for the player
   */
  public double getInitialBalance(){
    return initialBalance;
  }

}
