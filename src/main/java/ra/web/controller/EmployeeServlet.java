package ra.web.controller;

import ra.web.model.Employee;
import ra.web.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private static final EmployeeService service = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "LIST":
                    request.setAttribute("list", service.findAll());
                    request.getRequestDispatcher("/employees/list.jsp").forward(request, response);
                    break;
                case "ADD":
                    // chuyển trang
                    request.getRequestDispatcher("/employees/add.jsp").forward(request, response);
                    break;
                case "DELETE":
                    Integer idDel = Integer.valueOf(request.getParameter("id"));
                    service.deleteById(idDel);
                    response.sendRedirect("/EmployeeServlet?action=LIST");
                    break;
                case "EDIT":
                    Integer idEdit = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("employee",service.findById(idEdit));
                    request.getRequestDispatcher("/employees/edit.jsp").forward(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "ADD":
                    String name = request.getParameter("name");
                    String address = request.getParameter("address");
                    Boolean sex = Boolean.valueOf(request.getParameter("sex"));
                    // yyyy-MM-dd
                    LocalDate birthDay = LocalDate.parse(request.getParameter("birthDay"), DateTimeFormatter.ISO_LOCAL_DATE);
                    Employee employee = new Employee(null, name, birthDay, address, sex);
                    service.save(employee);
                    response.sendRedirect("/EmployeeServlet?action=LIST");
                    break;
                case "UPDATE":
                    Integer idUp = Integer.valueOf(request.getParameter("id"));
                    String nameUp = request.getParameter("name");
                    String addressUp = request.getParameter("address");
                    Boolean sexUp = Boolean.valueOf(request.getParameter("sex"));
                    // yyyy-MM-dd
                    LocalDate birthDayUp = LocalDate.parse(request.getParameter("birthDay"), DateTimeFormatter.ISO_LOCAL_DATE);
                    Employee employeeUp = new Employee(idUp, nameUp,birthDayUp,addressUp,sexUp);
                    service.save(employeeUp);
                    response.sendRedirect("/EmployeeServlet?action=LIST");
                    break;
            }
        }
    }
}
 