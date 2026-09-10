<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Murach's Java CdShop</title>
    <link rel ="stylesheet" href="style/styles.css">
</head>
<body>
<h1>Your cart</h1>
<table>
    <tr>
        <th>Quantity</th>
        <th>Description</th>
        <th>Price</th>
        <th>Amount</th>
    </tr>
<c:forEach var="item" items="${cart.cartItemList}">
    <tr>
        <td>
         <form action = "cart" method = "post">
                <input type = "hidden" name="action" value="update">
                <input type = "hidden" name="description" value = "${item.description}">
                <input type = "text" name="quantity" value="${item.quantity}">
                <button type ="submit">Update</button>
         </form>
        </td>
        <td>${item.description}</td>
        <td>$<fmt:formatNumber value="${item.price}" maxFractionDigits="2"/></td>
        <td>$<fmt:formatNumber value="${item.amount}" maxFractionDigits="2"/></td>
        <td>
            <form action = "cart" method="post">
                <input type = "hidden" name="action" value="remove">
                <input type = "hidden" name="description" value="${item.description}">
                <button type ="submit">Remove</button>
            </form>
        </td>

    </tr>
    </c:forEach>
</table>
<p><b>To change the quantity</b>, enter the new quantity and click on the Update button.</p>

<form action="cart" method="post">
    <input type="hidden" name="action" value="continue">
    <button type = "submit">Continue Shopping</button>
</form>

<form action="cart" method="post">
    <input type="hidden" name="action" value="checkout">
    <input type="hidden" name="total" value="${cart.total}">
    <button type="submit">Checkout</button>
</form>
<p>Total: $<fmt:formatNumber value="${cart.total}" maxFractionDigits="2"/></p>

</body>
</html>