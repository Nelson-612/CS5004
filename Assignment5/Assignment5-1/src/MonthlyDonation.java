import java.time.LocalDateTime;

public class MonthlyDonation extends Donation{
  private LocalDateTime cancellationDateTime;

  public MonthlyDonation(double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
  }

  public void setCancellationDateTime(LocalDateTime cancellationDateTime) {
    if (cancellationDateTime.isBefore(getCreationDateTime())) {
      throw new IllegalArgumentException("Cancellation date cannot be before creation date");
    }
    this.cancellationDateTime = cancellationDateTime;
  }

  @Override
  public double getAmountForYear(int year) {
    int startYear = getCreationDateTime().getYear();
    int startMonth = getCreationDateTime().getMonthValue();

    if (startYear > year) {
      return 0.0;
    }

    if (cancellationDateTime != null && cancellationDateTime.getYear() < year) {
      return 0.0;
    }

    if (startYear == year) {
      int months = 12 - startMonth + 1;
      if (cancellationDateTime != null && cancellationDateTime.getYear() == year){
        months = cancellationDateTime.getMonthValue() - startMonth + 1;
      }
      return months * getAmount();
    }

    if (cancellationDateTime != null && cancellationDateTime.getYear() == year) {
      return cancellationDateTime.getMonthValue() * getAmount();
    }
    return 12 * getAmount();
  }
}



