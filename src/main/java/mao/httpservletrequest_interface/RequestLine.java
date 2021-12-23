package mao.httpservletrequest_interface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project name(项目名称)：HttpServletRequest_interface
 * Package(包名): mao.httpservletrequest_interface
 * Class(类名): RequestLine
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/23
 * Time(创建时间)： 19:08
 * Version(版本): 1.0
 * Description(描述)： 一般情况下，浏览器（客户端）通过 HTTP 协议来访问服务器的资源，Servlet 主要用来处理 HTTP 请求。
 * Servlet 处理 HTTP 请求的流程如下：
 * Servlet 容器接收到来自客户端的 HTTP 请求后，容器会针对该请求分别创建一个 HttpServletRequest 对象和 HttpServletReponse 对象。
 * 容器将 HttpServletRequest 对象和 HttpServletReponse 对象以参数的形式传入 service() 方法内，并调用该方法。
 * 在 service() 方法中 Servlet 通过 HttpServletRequest 对象获取客户端信息以及请求的相关信息。
 * 对 HTTP 请求进行处理。
 * 请求处理完成后，将响应信息封装到 HttpServletReponse 对象中。
 * Servlet 容器将响应信息返回给客户端。
 * 当 Servlet 容器将响应信息返回给客户端后，HttpServletRequest 对象和 HttpServletReponse 对象被销毁。
 * HttpServletRequest 接口
 * 在 Servlet API 中，定义了一个 HttpServletRequest 接口，它继承自 ServletRequest 接口。
 * HttpServletRequest对象专门用于封装 HTTP 请求消息，简称 request 对象。
 * HTTP 请求消息分为请求行、请求消息头和请求消息体三部分，所以 HttpServletRequest 接口中定义了获取请求行、请求头和请求消息体的相关方法。
 * <p>
 * 返回值类型	    方法声明                	描述
 * String	getMethod()	该方法用于获取 HTTP 请求方式（如 GET、POST 等）。
 * String	getRequestURI()	该方法用于获取请求行中的资源名称部分，即位于 URL 的主机和端口之后，参数部分之前的部分。
 * String	getQueryString()	该方法用于获取请求行中的参数部分，也就是 URL 中“?”以后的所有内容。
 * String	getContextPath()	返回当前 Servlet 所在的应用的名字（上下文）。对于默认（ROOT）上下文中的 Servlet，此方法返回空字符串""。
 * String	getServletPath()	该方法用于获取 Servlet 所映射的路径。
 * String	getRemoteAddr()	该方法用于获取客户端的 IP 地址。
 * String	getRemoteHost()	该方法用于获取客户端的完整主机名，如果无法解析出客户机的完整主机名，则该方法将会返回客户端的 IP 地址。
 */

public class RequestLine extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("请求方式:" + request.getMethod() + "<br/>" +
                "客户端的 IP 地址:" + request.getRemoteAddr() + "<br/>" +
                "应用名字（上下文）:" + request.getContextPath() + "<br/>" +
                "URI:" + request.getRequestURI() + "<br/>" +
                "请求字符串:" + request.getQueryString() + "<br/>" +
                "Servlet所映射的路径:" + request.getServletPath() + "<br/>" +
                "客户端的完整主机名:" + request.getRemoteHost() + "<br/>"
        );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

}
