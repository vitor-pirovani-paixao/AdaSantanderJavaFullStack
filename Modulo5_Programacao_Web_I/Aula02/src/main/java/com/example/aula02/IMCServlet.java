package com.example.aula02;
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name="IMCServlet", urlPatterns="/calcularIMC")
public class IMCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String peso = req.getParameter("peso");
        String altura = req.getParameter("altura");
        Double imc = Double.parseDouble(peso) / Math.pow(Double.parseDouble(altura), 2);
        req.setAttribute("imc", String.format("%.2f %%",imc));
        resp.setHeader("imc",String.format("%.2f %%",imc));
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
