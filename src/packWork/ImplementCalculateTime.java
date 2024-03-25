package packWork;


public	class ImplementCalculateTime implements CalculateTime {

	public long time() {
		return System.currentTimeMillis();
	}
}
