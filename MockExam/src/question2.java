public class question2 {

}
//Given the code on pages 5, 6, and 7, Write a description of all classes
//1. identifying whether the class is abstract or concrete
//2. identifying all superclasses and subclasses of the class.
//3. Explaining all methods in the class:
//a. Their input
//b. What they do
//c. What they return
//4. Explaining all the variables in the class:
//a. Purpose.
//b. Access level (package, private, protected, public)


public Rental (Movie movie, int rentalDays) {
  this.movie = movie;
  this.rentalDays = rentalDays;}

public void setDaysLate(int daysLate) {
  this.daysLate = daysLate;
}

public double getLateFees() {
  return movie.calcLateFees(dayLate);
}