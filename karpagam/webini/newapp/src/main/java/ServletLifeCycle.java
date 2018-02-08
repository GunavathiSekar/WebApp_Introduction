import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletLifeCycle")
public class ServletLifeCycle extends HttpServlet {
    public String url = "jdbc:mysql://localhost:3306/servlettest";
    public ServletLifeCycle() {
        System.out.println("Default constructor");
    }

    public void init(ServletConfig config) {
        System.out.println("Init method...!");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        try {
            
        Connection con = DriverManager.getConnection(url, "root", "");
        System.out.println("Connection created");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employee");

        String person = "Matthew";
        
        //Stores properties of a ResultSet object, including column count
ResultSetMetaData rsmd = rs.getMetaData(); 
int columnCount = rsmd.getColumnCount();

ArrayList<String> employees = new ArrayList<>(columnCount); 
while (rs.next()) {              
   int i = 1;
   while(i <= columnCount) {
    employees.add(rs.getString(i++));
   }
System.out.println(employees);
   req.setAttribute("employees", employees);
   req.getRequestDispatcher("welcome.jsp").forward(req, res);

   res.setContentType("text/html");
   PrintWriter pw = res.getWriter();
   pw.println("Hello, Welcome to splessons...!");
   pw.close();

}
    }catch(Exception e){
        req.setAttribute("Error", e);
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, res);
        return; 
    }finally{
        RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
        rd.forward(req, res);
        return;
    }


    }

    public void destroy() {
        System.out.println("Destroy method");
    }

}