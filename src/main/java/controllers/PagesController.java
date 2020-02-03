package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;

public class PagesController {

    public String notFound(Exception ex, Request request, Response response){
        response.status(404);
        return "Oops, la pagina que buscabas no existe.";
    }

    public ModelAndView home(Request request, Response response){
        return new ModelAndView(new HashMap<String,Object>(),"test.html");
    }
}
