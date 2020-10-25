package com.jakartacookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/")
public class NewCookies {

    private String cookie;

    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf8")
    public String newCookies(@Context HttpServletRequest request, @Context HttpServletResponse response) {

        // Создаём куки
        Cookie cookie1 = new Cookie("_cookies", "ThisCoockie");
        cookie1.setMaxAge(-1); // В секундах. -1 на время открытого браузера. 24 * 60 * 60 это сутки. 0 удаляет.
        cookie1.setPath("/");
        cookie1.setDomain("localhost");
        cookie1.setSecure(false);

        // Вставляем подготовленные Cookies в ответ response
        response.addCookie(cookie1);


        // Получаем куки
        Cookie[] cookies = request.getCookies();
        String cookieName = "_cookies";
        if(cookies !=null) {
            for(Cookie c: cookies) {
                if(cookieName.equals(c.getName())) {
                    this.cookie = c.getName() + " " + c.getValue();
                    break;
                }
            }
        }

        return cookie;
    }
}
