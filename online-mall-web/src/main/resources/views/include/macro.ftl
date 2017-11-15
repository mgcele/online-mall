<#assign base=request.contextPath />
<script>
    (function () {
        window.basePath = '${base}';
        window.templatePath = basePath +"/static/html/";
    })();
</script>