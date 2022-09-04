package dal;

import java.util.ArrayList;

import com.user.Books;

public interface DaoInterface {
	
	ArrayList<Books> findAll();
	Books findById(int id);
	void update(Books obj);
	Books save(Books obj);
	void delete (int id);
}
