package model;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;

import model.User;

public class AuthDAO {
	public static final String DB_URL = "jdbc:mysql://localhost:3306/lab003";
	public static final String DB_USER = "root";
	public static final String DB_PW = "";
	public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	static Connection conn=null;
	static PreparedStatement ps=null;
	static ResultSet res=null;
	public static void createConnection()
	{
		try
		{
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static int checkUserPass(String userName, String password)
	{
	  try
	  {
		  String sql="SELECT * FROM user WHERE username='"+userName+"'";
		  if((conn==null)||(conn.isClosed()==true)) createConnection();
		  ps = conn.prepareStatement(sql);
		  ResultSet rs=ps.executeQuery();
		  if(rs.last())
		  {
		  if((rs.getString("username").equals(userName))&&(rs.getString("password")).equals(password)) return rs.getInt("userId");
	  	  }
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	 return -1;	
	}
	public static User getUserById(int userId)
	{
		User u=null;
		String name,fn,ln;
		int id;
		try
		  {
			  String sql="SELECT * FROM user,user_profile WHERE user.userId="+userId+" AND user_profile.userId="+userId;
			  if((conn==null)||(conn.isClosed()==true)) createConnection();
			  ps = conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  if(rs.last())
			  {
				  name=rs.getString("username");
				  id=rs.getInt("userId");
				  fn=rs.getString("firstName");
				  ln=rs.getString("lastName");
				  u=new User(id,name,fn,ln);
				  
			  }
		  }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
	}				
	
	public static int enterNewUser(String userName, String password)
	{
		int i=0;
		try
		 {
		 String sql="INSERT INTO user (username,password) VALUES ('"+userName+"','"+password+"')";
		 if((conn==null)||(conn.isClosed()==true)) createConnection();
		 ps = conn.prepareStatement(sql);
		 i=ps.executeUpdate();
		 ps.close();
		 }
		 catch(Exception e)
		 {
		 e.printStackTrace(); 
		 }
		return i;	
	}
	public static boolean enterUserName(String username, String firstName, String lastName)
	{
		try
		{
			String sql="SELECT userId FROM user where username='"+username+"'";
			if((conn==null)||(conn.isClosed()==true)) createConnection();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int s=rs.getInt("userId");
			sql="INSERT INTO user_profile VALUES ('"+s+"','"+firstName+"','"+lastName+"')";
			ps=conn.prepareStatement(sql);
			if((ps.executeUpdate())>0) return true;
			ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}			
		return false;
	}
	public static boolean isUserNameAvailable(String userName)
	{
		try
		{
			String sql="SELECT username FROM user where username='"+userName+"'";
			if((conn==null)||(conn.isClosed()==true)) createConnection();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.last())
			{
				if(rs.getString("username").equalsIgnoreCase(userName)) return false;
			}
			ps.close();
			return true;			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return true;		
	}
	public static boolean checkMember(String userName,String firstName,String lastName)
	{   
		try
		{
		String sql="SELECT * FROM user_profile WHERE userId IN (SELECT userId FROM user WHERE username='"+userName+"')";
		if((conn==null)||(conn.isClosed()==true)) createConnection();
		ps = conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.last())
		{
		if((rs.getString("firstName").equals(firstName))&&(rs.getString("lastName").equals(lastName))) return true;
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return false;
	}
	
	public static void DB_Close()
	{
		try
		{
			conn.close();
				
		}
		catch(Exception e)
		{
		    e.printStackTrace();	
		}
		
		
	}
	}


