<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <td>${item.quantity}</td>
        <td>${item.description}</td>
        <td>${item.price}</td>
        <td>${item.amount}</td>
    </tr>
    </c:forEach>
</table>

<p>Total: $${cart.total}</p>

</body>
</html>