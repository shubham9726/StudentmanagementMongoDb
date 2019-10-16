import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns = {"/menu"})
public class Menu extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        if(request.getParameter("create_account")!=null)
        {
            RequestDispatcher d=request.getRequestDispatcher("createaccount.jsp");
            d.forward(request,response);
        }
        if(request.getParameter("delete_account")!=null)
        {
            RequestDispatcher d=request.getRequestDispatcher("delete_account.jsp");
            d.forward(request,response);
        }
        if(request.getParameter("deposite_amount")!=null)
        {
            RequestDispatcher d=request.getRequestDispatcher("deposit_amount.jsp");
            d.forward(request,response);
        }
        if(request.getParameter("withdraw_amount")!=null)
        {
            RequestDispatcher d=request.getRequestDispatcher("withdraw_amount.jsp");
            d.forward(request,response);
        }
        if(request.getParameter("mini_statement")!=null)
        {
            RequestDispatcher d=request.getRequestDispatcher("mini_statement.jsp");
            d.forward(request,response);
        }
        if(request.getParameter("active")!=null)
        {
            RequestDispatcher d=request.getRequestDispatcher("activeaccounts.jsp");
            d.forward(request,response);
        }
    }
}