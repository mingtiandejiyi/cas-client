<%@ page import="org.jasig.cas.client.authentication.AttributePrincipal" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h1>当前所在子系统：测试系统1</h1>
<h2><a href="http://app1.ngrok.xiaomiqiu.cn">系统2</a></h2>
<h2><a href="http://app2.ngrok.xiaomiqiu.cn">系统1</a></h2>
<b>Authenticated User Id:</b> <a href="javascript:void(0);" title="Click here to log out"><%= request.getRemoteUser() %>
</a>
<br/>
<a href="<%=request.getContextPath() %>/loginOut1" title="Click here to log out">退出系统（方式1）</a>
<a href="<%=request.getContextPath() %>/loginOut2" title="Click here to log out">退出系统（方式2）</a>
<%
    if (request.getUserPrincipal() != null) {
        AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();

        final Map attributes = principal.getAttributes();

        if (attributes != null) {
            Iterator attributeNames = attributes.keySet().iterator();
            out.println("<b>Attributes:</b>");

            if (attributeNames.hasNext()) {
                out.println("<hr><table border='3pt' width='100%'>");
                out.println("<th colspan='2'>Attributes</th>");
                out.println("<tr><td><b>Key</b></td><td><b>Value</b></td></tr>");

                for (; attributeNames.hasNext(); ) {
                    out.println("<tr><td>");
                    String attributeName = (String) attributeNames.next();
                    out.println(attributeName);
                    out.println("</td><td>");
                    final Object attributeValue = attributes.get(attributeName);

                    if (attributeValue instanceof List) {
                        final List values = (List) attributeValue;
                        out.println("<strong>Multi-valued attribute: " + values.size() + "</strong>");
                        out.println("<ul>");
                        for (Object value : values) {
                            out.println("<li>" + value + "</li>");
                        }
                        out.println("</ul>");
                    } else {
                        out.println(attributeValue);
                    }
                    out.println("</td></tr>");
                }
                out.println("</table>");
            } else {
                out.print("No attributes are supplied by the CAS server.</p>");
            }
        } else {
            out.println("<pre>The attribute map is empty. Review your CAS filter configurations.</pre>");
        }
    } else {
        out.println("<pre>The user principal is empty from the request object. Review the wrapper filter configuration.</pre>");
    }
%>
<iframe style="width: 100%;" src="http://app2.ngrok.xiaomiqiu.cn/"></iframe>
</body>
</html>
