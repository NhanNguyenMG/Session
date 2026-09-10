package Cdshop;

import Cdshop.business.CartItem;
import Cdshop.business.CartList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cart")
public class CdServlet extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();


        if("add".equals(req.getParameter("action"))) {
            String description = req.getParameter("description");
            String price = req.getParameter("price");
            double priceDouble = Double.parseDouble(price);
            CartList cart = (CartList) session.getAttribute("cart");
            if (cart == null) {
                cart = new CartList();
            }

            cart.addCartItem(new CartItem(description, priceDouble, 1));

            session.setAttribute("cart", cart);
            resp.sendRedirect("yourcart.jsp");
        }

        else if("remove".equals(req.getParameter("action"))) {
            CartList cart = (CartList) session.getAttribute("cart");
            String description = req.getParameter("description");
            cart.removeCartItem(description);
            session.setAttribute("cart", cart);
            resp.sendRedirect("yourcart.jsp");
            }

        else if("continue".equals(req.getParameter("action"))) {
            resp.sendRedirect("index.html");
        }

        else if("update".equals(req.getParameter("action"))) {
            CartList cart = (CartList) session.getAttribute("cart");
            String description = req.getParameter("description");
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            cart.updateCartItemQuantity(description, quantity);
            session.setAttribute("cart", cart);
            resp.sendRedirect("yourcart.jsp");

        }

        else if("checkout".equals(req.getParameter("action"))) {
            double total = Double.parseDouble(req.getParameter("total"));
            session.setAttribute("total", total);
            resp.sendRedirect("thanks.jsp");
        }
    }
}