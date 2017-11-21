<#import "/template.ftl" as template>
<@template.header title="登陆"></@template.header>
<link rel="stylesheet" href="${template.base}/static/css/login/login.css" />
<@template.content>
<!-- BEGIN PAGE CONTENT  -->
<div ng-controller="loginController">
<div ui-view></div>
</div>
<!-- END PAGE CONTENT-->
</@template.content>

<@template.script>
    <script src="${template.base}/static/js/online-mall/login/loginController.js"></script>
</@template.script>
