<%@ page contentType="text/html;charset=UTF-8" %>


<html>
<head>
    <title>Hello World</title>
    <meta name='description' content='A simple page'>
    <script type="text/javascript" src="/sitemesh_app/static/jquery-1.9.1.min.js" />

    <script type="text/javascript">
        $(function(){
            $('.btn').click(function(){
                alert('f');
//                $.getJSON('/sitemesh_app/ajax/hello');
            });
        });
    </script>
</head>
<body>
<p>Hello <strong>world</strong>!</p>

<!--<button id="btn" onclick="alert('x');">数据</button>-->
<a id="btn" href="javascript:void(0)" onclick="$.get('/sitemesh_app/ajax/hello',function(d){alert(d)});">数据</a>

</body>
</html>