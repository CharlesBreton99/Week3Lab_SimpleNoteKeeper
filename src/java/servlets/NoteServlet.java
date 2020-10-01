/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.Note;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Birdd
 */
public class NoteServlet extends HttpServlet {

    
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
               ServletContext context = getServletContext();
               
               InputStream is = context.getResourceAsStream("/WEB-INF/note.txt");
               
               Note data = new Note();
               
               if (is != null) {
                   InputStreamReader isr = new InputStreamReader(is);
                   BufferedReader reader = new BufferedReader(isr);
                   
                   String text;
                   int counter = 0;
                 
                    
                   while ((text = reader.readLine()) != null) {
                       
                       if (counter == 0) {
                           data.setTitle(text);
                           counter++;
                       }
                       else {
                           data.setContent(text);
                       }
                   }
               }
               
               request.setAttribute("data", data);
               
               log(data.getTitle());
               log(data.getContent());
               
               getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
              
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
      
      
    }


}
