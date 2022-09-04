package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Books;

import services.BookService;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/WriteServlet")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Books bg = new Books();
		bg.setName(request.getParameter("bookname"));
		bg.setAuthor(request.getParameter("authorname"));
		bg.setCondition(request.getParameter("bookcondition"));
		bg.setGenre(request.getParameter("bookgenre"));
		bg.setComments(request.getParameter("comments"));
		
		String action = request.getParameter("action");
		BookService service = new BookService();
		
		if (action.equals("add")) {
			service.save(bg);
			response.sendRedirect("Book/List");
			
		}
		else if (action.equals("update")) {
			bg.setId(Integer.parseInt(request.getParameter("id")));
			service.update(bg);
			
			session.setAttribute("message", "Character updated!");
			response.sendRedirect("Book/List");
		}
		else {
			session.setAttribute("error", "Character " + action + "failed!");
			request.getRequestDispatcher("jsp/Error.jsp").forward(request, response);
		}
	}

}
