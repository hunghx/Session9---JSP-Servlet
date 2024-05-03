package ra.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // xử li các request gửi theo GET : thẻ <a> , Gõ trên đường dẫn , thẻ <form:get>
        // Lấy ra tham số - keyword
        // thông tin công khai
        String action = request.getParameter("action");
        if (action!=null){
            switch (action){
                case "List":
//                    response.sendRedirect("/list.jsp");
                    Student s = new Student(10,"Quỳnh anh");
                    request.setAttribute("student",s);
                    request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request,response);
                    break;
            }
        }
        String keyword = request.getParameter("keyword");
        System.out.println("keyword: "+keyword);
        System.out.println("Call Get homeServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // xử li các request gửi theo GET : thẻ <form:post>
        // thông tin nhạy cảm
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String keyword = request.getParameter("keyword");
        System.out.println("keyword: "+keyword);
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + keyword + "</h1>");
        out.println("</body></html>");
    }
}
 