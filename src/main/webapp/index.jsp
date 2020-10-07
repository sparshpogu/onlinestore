<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>

</style>
<title>Online Store Application</title>
</head>
<body>
<h1>Online Store</h1>
 <ul >
  <li><a href="getCartItems">Get Cart Items</a></li>
  <li><a href="getTotal">Cart Total</a></li>
</ul>


<form action="addtostore">
<h4>Add to Store</h4>
<table>
    <tr>
        <td>Item </td>
		<td><input type="text" name="name"></td>
	</tr>
 	<tr>
        <td>Price </td>
        <td><input type="text" name="price"></td>
 	</tr>
<tr><td><input type="submit" value="Add to Shop"></td></tr>	
</table>
</form>

<form action="addtoCart">
<h4>Add to Cart</h4>
<table>
    <tr>
        <td>Item</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>Quantity</td>
		<td> <input type="text" name="quantity"></td>
	</tr>		
	<tr><td><input type="submit" value="Add to Cart"></td></tr>	
</table>
</form>


${total}
${items}
${message}
</body>
</html>