package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Books;

import services.BookService;

/**
 * Servlet implementation class BookReadServlet
 */
@WebServlet("/BookReadServlet")
public class BookReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BookReadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idString = request.getParameter("id");
		BookService service = new BookService();
		HttpSession session = request.getSession();
		
		if (idString != null ) {
			Integer id = Integer.parseInt(idString);
			
		Books book = service.findByID(id);
		session.setAttribute("book", book);
		
		request.getRequestDispatcher("/jsp/Bookspages/update.jsp").forward(request, response);
		
		
		}
		
		else {
			//no ID passed in do a selectAll()
			ArrayList<Books> books = null;
			
			String bookname = request.getParameter("bookname");
			String authorname = request.getParameter("authorname");
			
			if(bookname !=null && bookname.trim().length() >0 ) {
				books = service.findByBookName(bookname);
				
			}
			else if (authorname != null && authorname.trim().length() > 0) {
				books = service.findByBookAuthor(authorname);
			}
			
			else {
				books = service.findAll();
			}
			String deleteString = request.getParameter("deleteid");
			if (deleteString != null) {
				Integer id = Integer.parseInt(deleteString);
				service.deleteById(id);
			}
			
			session.setAttribute("books", books);
			request.getRequestDispatcher("/jsp/BooksPages/DisplayBook.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
