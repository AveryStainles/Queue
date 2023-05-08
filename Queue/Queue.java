public class Queue {
	private int intArray[];
	private int intArrayLength;
	
	private double doubleArray[];
	private int doubleArrayLength;
	
	private String stringArray[];
	private int stringArrayLength;
	
	private int pointerReader[];// intQueue: 0, doubleQueue: 1, StringQueue: 2
	private int counter[];// element 0: how many int, element 1: how many double, 
							//element 2: how many String, element 3: seed counter
	private int seed[];
	private int seedLength;
	
	Queue() {
		pointerReader = new int[] {0, 0, 0, 0};
		counter = new int[] {0, 0, 0, 0};
		
		intArrayLength = 10;
		intArray = new int[intArrayLength];
		
		doubleArrayLength = 10;
		doubleArray = new double[doubleArrayLength];
		
		stringArrayLength = 10;
		stringArray = new String[stringArrayLength];
		
		seedLength = 40;
		seed = new int[seedLength];
	}// Queue() Constructor

	public void setQueueInt(int num) {
		try {
			setQueueSeed(0);
			intArray[counter[0]] = num;
			counter[0]++;
		} catch (ArrayIndexOutOfBoundsException e) {
			int[] arrayHold = intArray;
			intArrayLength += 10;

			intArray = new int[intArrayLength];

			for (int i = 0; i < arrayHold.length; i++) {
				intArray[i] = arrayHold[i];
			}
			setQueueSeed(0);
			intArray[counter[0]] = num;
			counter[0]++;

		} // catch		
	}// setQueue(int) Method
	
	
	
	
	public void setQueueDouble(double num) {
		try {
			setQueueSeed(1);
			doubleArray[counter[1]] = num;
			counter[1]++;
		} catch (ArrayIndexOutOfBoundsException e) {
			double[] arrayHold = doubleArray;
			doubleArrayLength += 10;

			doubleArray = new double[doubleArrayLength];

			for (int i = 0; i < arrayHold.length; i++) {
				doubleArray[i] = arrayHold[i];
			}
			setQueueSeed(1);
			doubleArray[counter[1]] = num;
			counter[1]++;

		} // catch	
	}// setQueueDouble(double) Method
	
	
	
	public void setQueueString(String text) {
		try {
			setQueueSeed(2);
			stringArray[counter[2]] = text;
			counter[2]++;
		} catch (ArrayIndexOutOfBoundsException e) {
			String[] arrayHold = stringArray;
			stringArrayLength += 10;

			stringArray = new String[stringArrayLength];

			for (int i = 0; i < arrayHold.length; i++) {
				stringArray[i] = arrayHold[i];
			}
			setQueueSeed(2);
			stringArray[counter[2]] = text;
			counter[2]++;

		} // catch	
	}// setQueueString(String) Method
	
	
	public void setQueueSeed(int num) {
		try {
			seed[counter[3]] = num;
			counter[3]++;
		} catch (ArrayIndexOutOfBoundsException e) {
			int[] arrayHold = seed;
			seedLength += 40;

			seed = new int[seedLength];

			for (int i = 0; i < arrayHold.length; i++) {
				seed[i] = arrayHold[i];
			}
			seed[counter[3]] = num;
			counter[3]++;

		} // catch	
	}// setQueueSeed(int) Method
	

	
	

	public int getQueueInt() {	
		int x = pointerReader[0];
		pointerReader[0]++;
		return intArray[x];
	}// getQueue() Method
	
	public double getQueueDouble() {	
		int x = pointerReader[1];
		pointerReader[1]++;
		return doubleArray[x];
	}// getQueue() Method
	
	public String getQueueString() {	
		int x = pointerReader[2];
		pointerReader[2]++;
		return stringArray[x];
	}// getQueue() Method
	
	public int getQueueSeed() {	
		return seed[pointerReader[3]];
	}// getQueue() Method
	
	public void incrementPointerReaderSeed() {
		pointerReader[3]++;
	}// incrementPointerReaderSeed() Method
	
	
	public int getPointerReaderInt() {
		return pointerReader[0];
	}// getPointerReaderInt() Method
	
	public int getPointerReaderDouble() {
		return pointerReader[1];
	}// getPointerReaderInt() Method
	
	public int getPointerReaderString() {
		return pointerReader[2];
	}// getPointerReaderString() Method
	
	public int getPointerReaderSeed() {
		return pointerReader[3];
	}// getPointerReaderSeed() Method
	
	public int getIntCounter() {
		return counter[0];
	}// getIntCounter() Method
	
	public int getDoubleCounter() {
		return counter[1];
	}// getDoubleCounter() Method
	
	public int getStringCounter() {
		return counter[2];
	}// getStringCounter() Method
	
	public int getSeedCounter() {
		return counter[3];
	}// getSeedCounter() Method
	
	public void clearQueue() {
		intArrayLength = 10;
		doubleArrayLength = 10;
		stringArrayLength = 10;
		seedLength = 40;
		
		counter = new int[] {0, 0, 0, 0};
		pointerReader = new int[] {0, 0, 0, 0};
		
		intArray = new int[intArrayLength];
		doubleArray = new double[doubleArrayLength];
		stringArray = new String[stringArrayLength];
		seed = new int[seedLength];
	}// clearQueue() Method
}// Queue Class
