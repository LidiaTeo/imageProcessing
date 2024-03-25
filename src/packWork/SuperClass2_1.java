package packWork;
public class SuperClass2_1 extends SuperClass2 {
	static private int number;
	static {
		number = 5;
        System.out.println("Din blocul static de initializare: number = " + number);
	}
	{
		number = 7;
        System.out.println("Din blocul de initializare: number = " + number);
	}	
    @Override
    public void DisplayFrom2() {
        System.out.println("Metoda din DisplayForm2 poate fi alterata, acesta fiind noul text.");
    }
}
