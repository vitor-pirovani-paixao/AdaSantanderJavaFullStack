<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Peso Ideal e IMC</title>
</head>
<body>
<h1>Cálculo do Peso Ideal e IMC</h1>
<form name="bmiForm" action="peso-servlet" method="GET">
    <table>
        <tr>
            <td><label for: "weight" > Seu peso (kg):</label></td>
            <td><input type="text" name="peso", id = "weight"></td>
        </tr>
        <tr>
            <td><label for:"heigth" > Sua altura (m):</label?</td>
            <td><input type="text" name="altura", id="height"></td>
        </tr>
        <tr>
            <td><label for:"gender" > Seu gênero (m/f):</label?</td>
            <td><input type="text" name="sexo", id="gender"></td>
        </tr>
        <th><input type="submit" value="Enviar" name="find"></th>
        <th><input type="reset" value="Limpar" name="reset"></th>
    </table>
    <h2>${infoPesoIMC}</h2>
</form>
</body>
</html>