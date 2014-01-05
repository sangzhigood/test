package com.sangzhi.httpserver.handle;

import com.sangzhi.httpserver.context.HttpContext;

public interface RequestHandler {

    void handle(HttpContext httpContext);

}
