package services;

import java.util.ArrayList;

import com.user.Books;

import dal.BooksDao;

public class BookService implements ServiceInterface<Books> {

	private static BooksDao dao;
	
	public BookService() {
		dao = new BooksDao();
	}
	@Override
	public ArrayList<Books> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Books findByID(int id) {
		// TODO Auto-generated method stub
		return dao.findByID(id);
	}

	@Override
	public void update(Books obj) {
		// TODO Auto-generated method stub
		dao.update(obj);
	}

	@Override
	public Books save(Books obj) {
		// TODO Auto-generated method stub
		return dao.save(obj);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stu
		dao.delete(id);
		
	}
	
	public ArrayList<Books>findByBookName (String str) {
		return dao.findByBookName(str);
	}
	public ArrayList<Books>findByBookAuthor (String str) {
		return dao.findByBookAuthor(str);
	}

}
