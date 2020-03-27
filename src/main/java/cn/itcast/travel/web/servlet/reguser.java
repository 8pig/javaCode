package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "reguser")
public class reguser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取数据
        System.out.println(123);
        Map map1 = request.getParameterMap();
        String paramJson = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        Map parseObject = JSON.parseObject(paramJson, Map.class);
        System.out.println(paramJson);
        // 2. 封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, parseObject);
            System.out.println(parseObject);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 3. 调用service注册
        UserService service = new UserServiceImpl();
        Boolean flag = service.regist(user);
        ResultInfo res = new ResultInfo();
        // 4. 响应数据
        Map<String,Object> resMap = new HashMap<>();    // 使用Map存储键值对中添加内容

        if (flag) {
            resMap.put("code",200);
        }else {
            resMap.put("code",203);
            resMap.put("msg","注册失败");
        }

        request.setCharacterEncoding("utf-8");  // 设置request字符编码
        response.setContentType("text/json; charset=utf-8");    // 设置response的编码及格式
        PrintWriter out = response.getWriter();

        String resJSON = JSON.toJSONString(resMap);     // 转换为json

        out.print(resJSON);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(1);

    }
}
