<#macro header title>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <#include "/include/meta.ftl"/>
    <#include "/include/macro.ftl"/>
    <!-- necessary css -->
    <link rel="stylesheet" href="${template.base}/static/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${template.base}/static/css/bootstrap-theme.min.css" />
    <!-- necessary js -->
    <script src="${template.base}/static/js/plugins/jquery.min.js"></script>
    <script src="${template.base}/static/js/plugins/bootstrap.min.js"></script>
    <script src="${template.base}/static/js/plugins/angular.min.js"></script>
    <script src="${template.base}/static/js/plugins/angular-resource.min.js"></script>
    <script src="${template.base}/static/js/plugins/angular-ui-router.min.js"></script>
    <script src="${template.base}/static/js/plugins/ui-bootstrap-tpls.min.js"></script>
    <script src="${template.base}/static/js/app.js"></script>
</head>
</#macro>

<#macro content>
<body ng-app="OnlineMallApp" ng-controller="onlineMallRootController">
<#nested />
</body>
</#macro>
<#macro script>
    <#nested />
<!-- END JAVASCRIPTS -->
</html>
</#macro>