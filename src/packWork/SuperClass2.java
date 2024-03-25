package packWork;
public class SuperClass2 extends SuperClass3{
	
    public void DisplayFrom2() {
        System.out.println("Acesta este textul afisat din clasa SuperClass2");
    }
    @Override
    public void DisplayAbstract(){
    	 System.out.println("Acesta este textul afisat din metoda suprascrisa din clasa abstracta");
    }
}