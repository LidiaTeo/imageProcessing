package packWork;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadImage extends Thread{ //clasa citire imagine de la adresa specificata

    private Buffer b;
    private String filename;
    CalculateTime IntInstance = new ImplementCalculateTime();

    public void ReadText() {
        System.out.println("Text afisat din clasa de ReadImage");
    }

    public void run () {
    	System.out.println("Producatorul a pus imaginea. ");
        long start = IntInstance.time();
        try { //se incearca accesarea fisierului dat ca parametru
            File imageFile = new File(filename);
            this.b.produce(ImageIO.read(imageFile)); //imaginea este stocata in variabila image
        } catch (IOException e) { //daca nu se poate deschide fisierul
            System.out.println(e.getMessage()); //se afiseaza eroarea care a aparut
    	}
        long stop = IntInstance.time();
    	System.out.println("Reading took " + (stop - start) + " miliseconds. ");        
    }

    public ReadImage(String filename, Buffer b) { //constructor cu un parametru
    	
       this.b = b;
       this.filename = filename;
    }

    public BufferedImage getImage() {
        return b.getImage();
    } //getter pentru variabila private image

}