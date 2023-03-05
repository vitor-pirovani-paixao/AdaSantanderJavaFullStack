<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Saudacao do Usuario</title>
</head>
<form name="bmiForm" action="saudacao-servlet" method="POST">
    <table>
        <tr>
            <td><label for: "nome"> Digite seu nome:</label></td>
            <td><input type="text" name="nome", id = "nome"></td>
        </tr>
        <tr>
            <td><label for:"email">Digite seu e-mail:</label?</td>
            <td><input type="text" name="email", id="email"></td>
        </tr>
        <th><input type="submit" value="Enviar" name="find"></th>
        <th><input type="reset" value="Limpar" name="reset"></th>
    </table>
</form>
</body>
</html>