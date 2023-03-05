package com.example.pesoidealservlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "PesoServlet", value = "/peso-servlet")
public class PesoIdealServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Double peso = Double.parseDouble(request.getParameter("peso"));
        Double altura = Double.parseDouble(request.getParameter("altura"));
        String sexo = request.getParameter("sexo");

        Double imc = peso / Math.pow(altura, 2);
        String infoPesoIMC = String.format("Seu IMC é %.2f%% o que indica que você está %s. Seu peso ideal está entre %s.",
                imc,caculaFaixaDeImc(sexo,imc),caculaFaixaDePesoIdeal(sexo,altura));

        request.setAttribute("infoPesoIMC", infoPesoIMC);
//        response.setHeader("infoPesoIMC",infoPesoIMC);
        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }

    public String caculaFaixaDePesoIdeal(String sexo, Double altura) {
        if (sexo.equals("m")) {
            Double pesoMinimo = 18.0 * Math.pow(altura, 2);
            Double pesoMaximo = 25.0 * Math.pow(altura, 2);
            return String.format("%.2f kg e %.2f kg", pesoMinimo, pesoMaximo);
        } else if (sexo.equals("f")) {
            Double pesoMinimo = 18.0 * Math.pow(altura, 2);
            Double pesoMaximo = 24.0 * Math.pow(altura, 2);
            return String.format("%.2f kg e %.2f kg", pesoMinimo, pesoMaximo);
        } else {
            return null;
        }
    }

    public String caculaFaixaDeImc(String sexo, Double imc) {
        if (sexo.equals("m")) {
            if (imc < 18) {
                return "abaixo do peso";
            } else if (imc>=18 && imc<= 25) {
                return "no peso ideal";
            } else if (imc>25 && imc<= 30) {
                return "com sobrepeso";
            }else if (imc>30 && imc<= 40) {
                return "com obesidade moderada";
            }else if (imc>40 && imc<= 50) {
                return "com obesidade grave";
            }else{
                return "com obesidade gravíssima";
            }

        } else if (sexo.equals("f")) {
            if (imc < 18) {
                return "abaixo do peso";
            } else if (imc>=18 && imc<= 24) {
                return "peso ideal";
            } else if (imc>24 && imc<= 30) {
                return "com sobrepeso";
            }else if (imc>30 && imc<= 40) {
                return "com obesidade moderada";
            }else if (imc>40 && imc<= 50) {
                return "com obesidade grave";
            }else{
                return "com obesidade gravíssima";
            }
        } else {
            return null;
        }
    }


}