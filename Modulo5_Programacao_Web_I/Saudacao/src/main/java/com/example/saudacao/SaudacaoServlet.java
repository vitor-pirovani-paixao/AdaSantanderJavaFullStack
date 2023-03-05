package com.example.saudacao;

import java.io.*;
import java.time.LocalTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SaudacaoServlet", value = "/saudacao-servlet")
public class SaudacaoServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");

        String saudacao = gerarSaudacao() + nome;
        request.setAttribute("saudacao",saudacao);
        request.getRequestDispatcher("/dispMsg.jsp").forward(request,response);

    }

    private String gerarSaudacao(){
        LocalTime hora = LocalTime.now();
        LocalTime seisDaManha = LocalTime.of(6,0,0);
        LocalTime meioDia = LocalTime.of(12,0,0);
        LocalTime seisDaTarde = LocalTime.of(18,0,0);
        if (hora.isBefore(meioDia) && hora.isAfter(seisDaManha)){
            return "Bom dia, ";
        } else if (hora.isAfter(meioDia)&&hora.isBefore(seisDaTarde)) {
            return "Boa tarde, ";
        }else {
            return "Boa noite, ";
        }
    }
}