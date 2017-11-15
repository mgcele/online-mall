<#import "/template.ftl" as template>
<@template.header title="登陆"></@template.header>

<@template.content>
<!-- BEGIN PAGE CONTENT  -->
<div class="online-mall-bg" ng-controller="loginController">
<div ui-view></div>
</div>
<!-- END PAGE CONTENT-->
</@template.content>

<@template.script>
    <script src="${template.base}/static/js/online-mall/login/loginController.js"></script>
</@template.script>
