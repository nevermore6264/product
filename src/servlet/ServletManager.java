package servlet;

import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletManager", urlPatterns = "/product")
public class ServletManager extends HttpServlet {
    ProductService service = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product.jsp");
        System.out.println(action + "--" + id);
        switch (action) {
            case "info":
                request.setAttribute("product", service.getProduct(id));
                System.out.println(service.getProduct(id).toString());
                ;
                requestDispatcher.forward(request, response);
                break;
            case "delete":
                if (service.delete(id)) {
                    try {
                        request.setAttribute("list", service.getAll());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    requestDispatcher = request.getRequestDispatcher("index.jsp");
                    requestDispatcher.forward(request, response);
                }
                break;
            case "save":

        }
    }
}
