package cn.zz.login;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, Object> m1 = new HashMap<>();
        try {
            m1 = getParam4Post(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(m1+",m1");
        System.out.println(m1.get("password"));
        System.out.println(m1.get("username"));
//        getJson(request, response, m1);//返回一个user对象




    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);

    }
    public static Map<String, Object> getParam4Post(HttpServletRequest request) throws Exception {
        Map<String, Object> params = new HashMap<>();
        // 获取内容格式
        String contentType = request.getContentType();
        if (contentType != null && !contentType.equals("")) {
            contentType = contentType.split(";")[0];
        }

        // form表单格式  表单形式可以从 ParameterMap中获取
        if ("appliction/x-www-form-urlencoded".equalsIgnoreCase(contentType)) {
            // 获取参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (parameterMap != null) {
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    params.put(entry.getKey(), entry.getValue()[0]);
                }
            }
        }

        // json格式 json格式需要从request的输入流中解析获取
        if ("application/json".equalsIgnoreCase(contentType)) {
            // 使用 commons-io中 IOUtils 类快速获取输入流内容
            String paramJson = IOUtils.toString(request.getInputStream(), "UTF-8");
            Map parseObject = JSON.parseObject(paramJson, Map.class);
            params.putAll(parseObject);
        }


        return params ;
    }
    protected void getJson(HttpServletRequest request,HttpServletResponse response,Object object){
        response.setContentType("text/html;charset=UTF-8");
        //禁用缓存，确保网页信息是最新数据
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", -10);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String jsonStr=JSON.toJSONString(object);
            out.print(jsonStr);
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            out.close();
        }
    }

}
