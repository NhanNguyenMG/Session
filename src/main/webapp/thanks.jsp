<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java CDShop</title>
    <link rel="stylesheet" href="style/styles.css">
</head>
<body>
<h1><b> Thanks you for your shopping !!</b></h1>
<p> Your total: $<fmt:formatNumber value="${total}" maxFractionDigits = "2"/></p>

</body>