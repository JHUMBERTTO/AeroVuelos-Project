/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Iván
 */
@WebServlet(urlPatterns = {"/SvBD"})
public class SvRegistrarVuelo extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("EJECUCIÓN");
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("EJECUCIÓN");
        
        String 
                cod_vue = request.getParameter("cod_vue"),
                ori_vue = request.getParameter("ori_vue"),
                des_vue = request.getParameter("des_vue"),
                dia_vue = request.getParameter("dia_vue"),
                nda_vue = request.getParameter("nda_vue");
        
            UpdateBD conexion = new UpdateBD();
            
            System.out.println(cod_vue);
            System.out.println(ori_vue);
            System.out.println(des_vue);
            System.out.println(dia_vue);
            System.out.println(nda_vue);
            
            int resultado = conexion.registrarVuelo(cod_vue, ori_vue, des_vue, dia_vue, nda_vue);
            
            System.out.println("El resultado del registro es " + resultado);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        System.out.println("EJECUCIÓN");
        return "Short description";
    }// </editor-fold>

}
