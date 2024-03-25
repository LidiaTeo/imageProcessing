package packWork;

import java.awt.image.BufferedImage;

public class Buffer {
	private BufferedImage imageToProcess;
	private boolean available = false;
	
	public Buffer(BufferedImage img){
		this.imageToProcess = img;
	}

	public BufferedImage getImage(){
		return imageToProcess;
	}

	public void setImage(BufferedImage img){
		this.imageToProcess = img;
	}


	public synchronized BufferedImage consume() {
		while (!available) {
			try {
				wait();
				// Asteapta producatorul sa puna o valoare
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		available = false;
		notifyAll();
		return imageToProcess;
	}
	public synchronized void produce(BufferedImage img) {
		while (available) {
			try {
				wait();
				// Asteapta consumatorul sa preia valoarea
			} catch ( InterruptedException e) {
				e.printStackTrace ();
			}
		}
		this.imageToProcess = img;
		available = true;
		notifyAll();
	}

}
