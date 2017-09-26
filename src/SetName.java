
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetName
 */
@WebServlet(name = "setname", urlPatterns = "/setName")
public class SetName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static HashMap<String, String> hashmap;
	
	static {
		hashmap = new HashMap<String, String>();
		hashmap.put("hossein", "1234");
		hashmap.put("milad", "1234");
		hashmap.put("ehsan", "1234");
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetName() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		if ((boolean) session.getAttribute("login")) {
			session.setAttribute("login", Boolean.parseBoolean(request.getParameter("login")));
			response.getWriter().println("you are logout");
		} else
			response.getWriter().println("your were not logged on");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (hashmap.get(username).equals(password)) {
			session.setAttribute("login", true);
			session.setAttribute("username", username);
			response.getWriter().println("your are login");
		} else {
			session.setAttribute("login", false);
			response.getWriter().println("your are  NOT  login\n");
		}

		// session.setAttribute("name", username);

		// response.getWriter().println("hello " + request.getParameter("name") + "
		// azizam!");
	}

}
