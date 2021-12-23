package mao.httpservletrequest_interface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Project name(项目名称)：HttpServletRequest_interface
 * Package(包名): mao.httpservletrequest_interface
 * Class(类名): RequestHeader
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/23
 * Time(创建时间)： 19:20
 * Version(版本): 1.0
 * Description(描述)： 获取请求头信息
 * 当浏览器发送请求时，需要通过请求头向服务器传递一些附加信息，例如客户端可以接收的数据类型、压缩方式、语言等。
 * 为了获取请求头中的信息， HttpServletRequest 接口定义了一系列用于获取 HTTP 请求头字段的方法，如下表所示。
 * 返回值类型        	方法声明	                   描述
 * String	getHeader(String name)	该方法用于获取一个指定头字段的值。
 * 如果请求消息中包含多个指定名称的头字段，则该方法返回其中第一个头字段的值。
 * Enumeration	getHeaders(String name)	该方法返回指定头字段的所有值的枚举集合，
 * 在多数情况下，一个头字段名在请求消息中只出现一次，但有时可能会出现多次。
 * Enumeration	getHeaderNames()	该方法返回请求头中所有头字段的枚举集合。
 * String	getContentType()	该方法用于获取 Content-Type 头字段的值。
 * int	getContentLength()	该方法用于获取 Content-Length 头字段的值 。
 * String	getCharacterEncoding()	该方法用于返回请求消息的字符集编码 。
 */

public class RequestHeader extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        //获得所有请求头字段的枚举集合
        Enumeration<String> headers = request.getHeaderNames();
        writer.write("编码：" + request.getCharacterEncoding() + "<br/>");
        while (headers.hasMoreElements())
        {
            //获得请求头字段的值
            String value = request.getHeader(headers.nextElement());
            writer.write(headers.nextElement() + ":" + value + "<br/>");
        }
        writer.write("Content-Type 头字段的值:" + request.getContentType()+"<br/>");
        writer.write("Content-Length 头字段的值 :" + request.getContentLength());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
