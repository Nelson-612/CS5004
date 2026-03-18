import java.time.LocalDateTime;

public abstract class Donation {
  private double amount;
  private LocalDateTime creationDateTime;

  public Donation(double amount, LocalDateTime creationDateTime){
    this.amount= amount;
    this.creationDateTime = creationDateTime;
  }

  public abstract double getAmountForYear(int year);

  public double getAmount() {
    return this.amount;
  }

  public LocalDateTime getCreationDateTime() {
    return this.creationDateTime;
  }
}

