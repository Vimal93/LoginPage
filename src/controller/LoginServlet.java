package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import model.AuthDAO;
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		if(username==null) username="";
		String password=request.getParameter("password");
		if(password==null) password="";
		if((username.length()==0)&&(password.length()==0)) 
		{ 
		request.setAttribute("errorMessage", "Please fill out the Username and Password");
	    request.getRequestDispatcher("/login.jsp").forward(request, response);
	    return;
	    }
		if((username.length()==0)) 
		{ 
		request.setAttribute("errorMessageUname", "Please fill out the Username");
	    request.getRequestDispatcher("/login.jsp").forward(request, response);
	    return;
	    }
		if((password.length()==0)) 
		{ 
		request.setAttribute("errorMessagePword", "Please fill out the Password");
	    request.getRequestDispatcher("/login.jsp").forward(request, response);
	    return;
	    }
		request.setAttribute("username", username);
		if((session.getAttribute("username")!=null)&&(session.getAttribute("username")).equals(username))
		{
		request.setAttribute("Alreadylogged", "The user has already logged in");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		return;
		}
		int x=0;
		x=AuthDAO.checkUserPass(username, password);
		if(x>0)
		{
			User u=AuthDAO.getUserById(x);
			session.setAttribute("User", u);
            session.setAttribute("username", u.getName());
            session.setAttribute("loggedIn","true");
            request.setAttribute("SuccessMsg", "Login successful");
            session.setAttribute("firstname", u.getFirstName());
            session.setAttribute("lastname", u.getLastName());
            AuthDAO.DB_Close();
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
		else
		{
			request.setAttribute("errorMsg", "Please Check your Username and Password");
			AuthDAO.DB_Close();
			request.getRequestDispatcher("/login.jsp").forward(request, response);			
		}
		
	}

}
