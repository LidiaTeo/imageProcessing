package packTest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import packWork.* ;

public class Main {
    public static void main(String[] args) {
        // Se încearcă citirea imaginii de la calea specificată în primul parametru
        BufferedImage img;
        try {
            img = ImageIO.read(new File(args[0]));
            // Se creează un obiect Buffer pentru a stoca imaginea
            Buffer b = new Buffer(img);

            // Se crează o instanță a clasei ReadImage, care primește calea imaginii și obiectul Buffer
            ReadImage image = new ReadImage(args[0], b);
            ProcessingImage processingImage = new ProcessingImage(b);

            // Consumatorul (thread-ul care procesează imaginea)
            processingImage.start();
            // Producatorul (thread-ul care citește imaginea)
            image.start();

            try {
                // Se așteaptă ca ambele thread-uri să se termine
                processingImage.join();
                image.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Se creează un obiect WriteImage pentru a scrie imaginea procesată
            WriteImage writeImage = new WriteImage(processingImage);
            // Se încearcă scrierea imaginii la adresa specificată de către utilizator prin al doilea parametru
            writeImage.WriteToFile(args[1]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
