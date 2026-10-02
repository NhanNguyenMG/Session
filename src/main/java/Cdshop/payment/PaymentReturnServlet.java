package Cdshop.payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/payment-return")
public class PaymentReturnServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        Map<String, String> fields = new HashMap<>();
        for (String key : request.getParameterMap().keySet()) {
            String value = request.getParameter(key);
            if (value != null && !value.isEmpty()) {
                fields.put(key, value);
            }
        }

        String vnp_SecureHash = request.getParameter("vnp_SecureHash");
        fields.remove("vnp_SecureHashType");
        fields.remove("vnp_SecureHash");

        String signValue = VNPayConfig.hmacSHA512(VNPayConfig.vnp_HashSecret, VNPayConfig.hashAllFields(fields));
        
        if (signValue.equals(vnp_SecureHash)) {
            if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
                response.sendRedirect("payment_success.jsp?" + request.getQueryString());
            } else {
                response.sendRedirect("payment_failure.jsp?" + request.getQueryString());
            }
        } else {
             response.getWriter().println("<html><body><h3>Lỗi: Chữ ký không hợp lệ!</h3></body></html>");
        }
        if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
            request.getSession().removeAttribute("cart");
            response.sendRedirect("payment_success.jsp?" + request.getQueryString());
        }
    }
}