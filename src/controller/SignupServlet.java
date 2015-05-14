package controller;

import java.io.IOException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AuthDAO;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		if(username==null) username="";
		request.setAttribute("username", username);
		String firstname=request.getParameter("firstname");
		if(firstname==null) firstname="";
		request.setAttribute("firstname",firstname);
		String lastname=request.getParameter("lastname");
		if(lastname==null) lastname="";
		request.setAttribute("lastname",lastname);
		String password=request.getParameter("password");
		if(password==null) password="";
		String cpassword=request.getParameter("cpassword");
		if(cpassword==null) cpassword="";
		int x=0,z=0;
		String sub1=request.getParameter("sub1");
		if(sub1==null) sub1="";
		String sub2=request.getParameter("sub2");
		if(sub2==null) sub2="";
		if(sub1.length()!=0)
		{   
			if(username.length()==0)
		    {
			    request.setAttribute("errorMessageUname", "Please fill out the Username");
			    request.getRequestDispatcher("/signup.jsp").forward(request, response);
			    return;
		    }
		    if((AuthDAO.isUserNameAvailable(username))!=false)
			{
		    	request.setAttribute("errorMessageUnameA", "Username Available");
				request.getRequestDispatcher("/signup.jsp").forward(request, response);		    	
				return;
			}
		    else
		    {   
		    	request.setAttribute("errorMessageUnameNA", "Username Not Available");
				request.getRequestDispatcher("/signup.jsp").forward(request, response);
				return;
			} 
		}
		if(sub2.length()!=0) 
		{   
			if(username.length()==0)
	        {
		       request.setAttribute("errorMessageUname", "Please fill out the Username");
		       x=-1;
	        }
		    if(firstname.length()==0)
			{
				request.setAttribute("errorMessageFname", "Please fill out the Firstname");
				x=-1;
			}
		    if(lastname.length()==0)
			{
				request.setAttribute("errorMessageLname", "Please fill out the Lastname");
				x=-1;
			}
		    if(password.length()==0)
			{
				request.setAttribute("errorMessagePass", "Please fill out the Password");
				x=-1;
			}
		    if(cpassword.length()==0)
			{
				request.setAttribute("errorMessageCPass", "Please fill out the Confirm Password");
				x=-1;
			}
		    if(!(password.equals(cpassword)))
		    {
				request.setAttribute("errorMessagePassMatch", "Passwords does not match");
				x=-1;
			}
		    if(x==-1)
			{
				request.getRequestDispatcher("/signup.jsp").forward(request, response);
				return;
			}
		}    
		if((AuthDAO.isUserNameAvailable(username))==false)
		{   
			if((AuthDAO.checkMember(username,firstname,lastname))==false)
			{
			request.setAttribute("errorMessageUnameNA", "Username Not Available");
			request.getRequestDispatcher("/signup.jsp").forward(request, response);
			return;
			}
			else
			{
			request.setAttribute("alreadyamember", "You have already been a member");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
			}
		}
		else
		{
		if((AuthDAO.enterNewUser(username,password))>0)
		{
			if((AuthDAO.enterUserName(username, firstname, lastname))==true)
			{
		    request.setAttribute("SuccessMessage", "Account is successfully created for "+username);
		    request.getRequestDispatcher("/login.jsp").forward(request, response);
		    return;
			}
		}
		else
		{
			request.setAttribute("UnSuccessMessage", "Account creation Unsuccessful"+z);
			request.getRequestDispatcher("/signup.jsp").forward(request, response);
			
		}
		}
	}
	} 



