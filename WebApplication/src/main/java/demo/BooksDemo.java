package demo;

import java.util.ArrayList;

import com.user.Books;

public class BooksDemo {
	public static void main (String[] args) {
		
	}
	
	public static void displayBooks(ArrayList<Books>items) {
		for (Books item : items) {
			System.out.println(item);
		}
	}
	
}
