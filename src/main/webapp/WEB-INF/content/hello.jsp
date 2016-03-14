<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="hello.message"/></title>
</head>

<body>
<h2><s:property value="message"/></h2>

<h3>Languages</h3>
<ul>
    <li>
        <s:url id="url" action="hello">
            <s:param name="request_locale">en</s:param>
        </s:url>
        <s:a href="%{url}">English</s:a>
    </li>
    <li>
        <s:url id="url" action="hello">
            <s:param name="request_locale">es</s:param>
        </s:url>
        <s:a href="%{url}">Espanol</s:a>
    </li>
</ul>
<br>
    <s:url id="url" action="sales" />
    <s:a href="%{url}">sales</s:a>
<br>
    <s:url id="url" action="shipping" />
    <s:a href="%{url}">shipping</s:a>
<br>
    <s:url id="url" action="management" />
    <s:a href="%{url}">management</s:a>
</body>
</html>
