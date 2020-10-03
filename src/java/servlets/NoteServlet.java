/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.Note;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Birdd
 */
public class NoteServlet extends HttpServlet {

    Note data = new Note();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Note data = new Note();
        // log(data.getTitle());
        //  log(data.getContent());

        /*  
      boolean firstLoad = true;

        if (firstLoad) {
         
            firstLoad = false;
        }
         */
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        String text = null;

        // boolean check = ((text = br.readLine()) != null);

        /*
        String check2 = String.valueOf(check);
        log(check2);
         */
        int counter = 0;

        while ((text = br.readLine()) != null) {
            //log("This is inside while" + text);

            if (counter == 0) {
                log("WORKING");
                data.setTitle(text);
               //log(data.getTitle());

                counter++;
            } else {
                data.setContent(data.getContent() + "\n" + text);
               // log(1 + data.getContent());
            }

            //log(data.getTitle());
            //log(data.getContent());


            /*
            if (counter == 0) {
                log("WORKING");
                data.setTitle(text);
                counter++;
            } else {
                data.setContent(text);
            }
             */
        }
        log(2 + data.getContent());
        request.setAttribute("data", data);
        log(data.getTitle());
        log(data.getContent());

        String editButton = request.getParameter("edit");
        log(request.getParameter("edit"));
        if (editButton != null) {

            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);
            return;
        }
        //request.setAttribute("data", data);

        request.setAttribute("data", data);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        data.setTitle(title);
        data.setContent(content);

        /*
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        pw.write(title);
        pw.write(content);
         */
        log(data.getTitle());
        log(data.getContent());
        request.setAttribute("data", data);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }

}
