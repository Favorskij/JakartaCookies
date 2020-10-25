package com.jakartacookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/")
public class NewCookies {

    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf8")
    public String newCookies(@Context HttpServletResponse response) {

        // Создаём куки
        Cookie cookie = new Cookie("_cookies", "ThisCoockie");
        cookie.setMaxAge(-1); // В секундах. -1 на время открытого браузера. 24 * 60 * 60 это сутки. 0 удаляет.
        cookie.setPath("/");
        cookie.setDomain("localhost");
        cookie.setSecure(false);

        // Вставляем подготовленные Cookies в ответ response
        response.addCookie(cookie);

        return "Привет мир!!!";
    }
}
