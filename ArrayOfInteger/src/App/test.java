package App;

import Module.ArrayOfInteger;

public class test {

	public static void main(String[] args) {

		System.out.println("Array defalut:");
		ArrayOfInteger arrSimp = new ArrayOfInteger();
		arrSimp.output();
		System.out.println("Add:");
		arrSimp.add(10000);
		arrSimp.output();
		System.out.println("Add with index:");
		arrSimp.add(2, 10000000);
		arrSimp.output();
		System.out.println("Value at 8: " + arrSimp.getValue(8));
		arrSimp.setValue(3, 0);
		arrSimp.output();
		System.out.println("Remove value at index:");
		arrSimp.remove(0);
		arrSimp.output();

		System.out.println();

		System.out.println("Array with capacity:");
		ArrayOfInteger arrCapa = new ArrayOfInteger(2);
		arrCapa.output();
		System.out.println("Add:");
		arrCapa.add(1000000);
		arrCapa.output();
		System.out.println("Add with index:");
		arrCapa.add(3, 10000000);
		arrCapa.output();
		System.out.println("Value at 3: " + arrCapa.getValue(3));
		arrCapa.setValue(3, 0);
		arrCapa.output();
		System.out.println("Remove value at index:");
		arrCapa.remove(99);
		arrCapa.output();

	}
}
