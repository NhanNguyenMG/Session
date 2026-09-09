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

        String description = req.getParameter("description");
        String price = req.getParameter("price");
        double priceDouble = Double.parseDouble(price);

        HttpSession session = req.getSession();
        CartList cart = (CartList) session.getAttribute("cart");
        if(cart==null){
            cart = new CartList();
        }

        cart.addCartItem(new CartItem(description, priceDouble, 1));

        session.setAttribute("cart",cart);
        resp.sendRedirect("yourcart.jsp");


    }
}