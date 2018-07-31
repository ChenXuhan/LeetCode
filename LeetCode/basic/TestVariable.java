package basic;

public class TestVariable {
	int a;
	int[] array;
	public void setA3() {
		a = 3;
	}
	public int getA() {
		return a;
	}
	public void setA4() {
		a = 4;
	}
	public void addA(int x) {
		a += x;
	}
	public void getArray(int[] inputs) {
		array = inputs.clone();
	}
	public void reverse() {
		int[] temp = array.clone();
		int len = temp.length;
		for(int i=0;i<len;i++)
			array[i] = temp[len-1-i];
	}
	public void printArray(){
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+",");
		System.out.println();
	}
}
