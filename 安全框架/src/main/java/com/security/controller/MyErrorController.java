package com.security.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*处理请求出错的类*/
@Controller
@RequestMapping("/error")
public class MyErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "error";
    }

    @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView errorHtml(HttpServletRequest request, Model model) {
        HttpStatus status = getStatus(request);

        /*不允许访问*/
        if (status.value() == 403) {
            model.addAttribute("message", "您的权限不足,请充钱偶！！！");
        }
        /*判断错误码是不是400开头的额*/
        if (status.value() == 404) {
            model.addAttribute("message", "大兄弟页面不纯在哦");
        }
        /*判断错误码是不是500开头的额*/
        if (status.is5xxServerError()) {
            model.addAttribute("message", "服务器下班啦");
        }
        return new ModelAndView("error");
    }

    /*获取请求当中的错误信息*/
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
