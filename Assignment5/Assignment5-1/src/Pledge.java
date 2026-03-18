import java.time.LocalDateTime;

public class Pledge extends Donation {
  private LocalDateTime processingDateTime;  // field up here

  public Pledge(double amount, LocalDateTime creationDateTime) {  // constructor here
    super(amount, creationDateTime);
  }

  public Pledge(double amount, LocalDateTime creationDateTime, LocalDateTime processingDateTime) {
    super(amount, creationDateTime);
    this.processingDateTime = processingDateTime;
  }

  public void setProcessingDateTime(LocalDateTime processingDateTime) {
    if (processingDateTime != null && processingDateTime.isBefore(getCreationDateTime())) {
      throw new IllegalArgumentException("Processing date cannot be before creation date");
    }
    this.processingDateTime = processingDateTime;
  }

  @Override
  public double getAmountForYear(int year) {
    if (processingDateTime == null) {
      return 0.0;
    }

    if(processingDateTime.getYear() == year) {
      return getAmount();
    }
    return 0.0;
  }
}
