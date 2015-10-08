package model;

import java.util.ArrayList;

public class Model {
	private final ArrayList<String> strings;
	
	
	public Model() {
		strings = new ArrayList<>();
		for (int i = 0; i < 10; i++){
			strings.add("string" + (i + 1));
		}
	}


	public ArrayList<String> getStrings() {
		return strings;
	}
	
	public void addString(String addString){
		strings.add(addString);
	}
	
	public boolean removeString(String removeString){
		boolean succes = strings.remove(removeString);
		return succes;
	}
	
	@Override
	public String toString() {
		String returnString = " ";
		for (String string : strings) {
			System.out.println(string);
			returnString += string;
		}
		System.out.println(returnString);
		return returnString;
	}
	
	
}
