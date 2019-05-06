/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sary
 */
//@WebServlet(name = "Login", urlPatterns= {"/login.html"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //Recuperare i dati dal form
            String usernameFromForm = request.getParameter("user");
            String passwordFromForm = request.getParameter("psw");
            String urlFromForm = request.getParameter("profileImg");
            String stringaVuota = "";
            
            //Crea o prende sessione creata in precedenza
            HttpSession session = request.getSession(false);
            
            if(session!=null && session.getAttribute("user")==null)
            {
                if(usernameFromForm != null && passwordFromForm != null &&
                    urlFromForm != null)
                {

                     if(usernameFromForm.equals(stringaVuota));
                     {
                         System.out.print("Attenzione stringa vuota");
                     }

                     UtenteFactory usrFact = UtenteFactory.getInstance();
                     if(usrFact.login(usernameFromForm, passwordFromForm))
                     {
                         Utente u = usrFact.getUser(usernameFromForm, passwordFromForm);
                         session.setAttribute("user", u);
                         request.getRequestDispatcher("index.html").forward(request, response);
                     }
                     else
                     {
                         System.out.print("utente non registrato");

                         //Passare i valori alla jsp
                         request.setAttribute("userJsp", usernameFromForm);
                         request.setAttribute("passJsp", passwordFromForm);
                         request.setAttribute("urlJsp", urlFromForm);
                         request.getRequestDispatcher("login.jsp").forward(request, response);
                     } 
                }
                else
                {
                   System.out.println("Il tuo username è null");
                   request.setAttribute("userJsp", stringaVuota);
                   request.setAttribute("passJsp", stringaVuota);
                   request.setAttribute("urlJsp", stringaVuota);

                   request.getRequestDispatcher("login.jsp").forward(request, response);
                } 
            }
            else
            {
                request.getRequestDispatcher("index.html").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
