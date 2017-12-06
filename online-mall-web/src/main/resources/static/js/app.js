var OnlineMallApp = angular.module("OnlineMallApp", [
    "ui.router",
    "ngResource",
    "ui.bootstrap",
    "ngSanitize"
]);

OnlineMallApp.controller('onlineMallRootController', ['$rootScope', function ($rootScope) {
    console.log("app test successful!");
}]);

// OnlineMallApp.controller(function ($rootScope) {
//     console.log("Test successful!");
// });
(function () {
    //计算dom root element的字体大小，(7.5 = 设计稿像素/100）
    var recalc = function () {
        document.documentElement.style.fontSize = document.documentElement.clientWidth / 7.5 + 'px';
    };
    var resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize';
    window.addEventListener(resizeEvt, recalc, false);
    document.addEventListener('DOMContentLoaded', recalc, false);

    //拦截器服务
    OnlineMallApp.factory('intercepter', function ($rootScope, $q) {

        /**
         * 判断resnpnse格式是正常
         */
        var isNormalResp = function (resp) {
            return angular.isDefined(resp.data.meta) && resp.data.meta !== null ;
        };
        return {
            request: function (config) {
                var ua = window.navigator.userAgent;

                var at = ua.indexOf('gapclient') > -1 ? JSON.parse(ua.split('gapclient')[1]).at : ua;

                config.headers = config.headers || {};

                config.headers.Authorization = 'gapclient/test/0/1.0.0/' + at;
                // config.headers.Authorization = 'Bearer ' + at;

                console.debug("【request】>> config :" + JSON.stringify(config));
                return config;
            },
            response: function (response) {
                // console.debug("【response】>> [status:"+response.status + "] [data:" + JSON.stringify(response.data)+"]");
                $rootScope.ajaxStatus = true;
                return response || $q.when(response);
            },
            responseError: function (response) {
                //统一异常码
                var RESP_ERR_CODE = $rootScope.RESP_ERR_CODE;
                console.error("【responseError】>> " + JSON.stringify(response));
                var status = response.status;
                /**
                 * data: 交易返回数据
                 * stateCode: 交易错误码
                 * msg: 错误提示信息
                 */
                var data = {},
                    stateCode = {},
                    filterExcluded = false,
                    msg = "";
                if (response.data !== null && response.data !== "") {
                    data = response.data.data;
                    stateCode = response.data.code;
                    if(typeof(data) === "String"){
                        msg = data;
                    }
                }

                if (isNormalResp(response)) {
                    stateCode = response.data.meta.stateCode;
                    filterExcluded = response.data.meta.filterExcluded;
                    msg = response.data.meta.friendlyMsg ? response.data.meta.friendlyMsg : response.data.meta.msgs[0];
                }

                $rootScope.ajaxStatus = false;

                if (!filterExcluded) {
                    if (status === 401) {

                        switch (stateCode) {
                            case RESP_ERR_CODE.REQUIRE_SMS:
                                $rootScope.credentials.requireMsgCode = true;
                                break;
                            case RESP_ERR_CODE.REQUIRE_CAPTCHA:
                                $rootScope.credentials.requireImgCode = true;
                                break;
                            case RESP_ERR_CODE.AT_NON:
                            case RESP_ERR_CODE.AT_EXPIRED:
                            case RESP_ERR_CODE.AT_INVALID:
                            case RESP_ERR_CODE.AT_KICKED_OUT:
                                $rootScope.page302(stateCode);
                                break;
                            default:
                                $rootScope.showError(msg);
                        }
                    }
                    else if (status === 500) {
                        $rootScope.showError('系统异常，请稍后再试');
                    }
                    else if (status === 504) {
                        $rootScope.showError('网关超时，请稍后再试');
                    }
                    else {
                        if (data === null || data === '') {
                            response.data.data = "未知错误";
                        }
                        switch (stateCode) {
                            case RESP_ERR_CODE.REQUIRE_SMS:
                                $rootScope.credentials.requireMsgCode = true;
                                break;
                            case RESP_ERR_CODE.REQUIRE_CAPTCHA:
                                $rootScope.credentials.requireImgCode = true;
                                break;
                            case RESP_ERR_CODE.AT_KICKED_OUT:    //其他地方登录，被踢出
                            case RESP_ERR_CODE.AT_INVALID:
                            case RESP_ERR_CODE.AT_EXPIRED:
                            case RESP_ERR_CODE.AT_NON:
                                $rootScope.page302(stateCode);
                                break;
                            default:
                                $rootScope.showError("(" + response.status + ") " + msg);
                        }
                    }
                }

                return $q.reject(response.data);
            }
        };
    });

    OnlineMallApp.config(function ($httpProvider) {
        $httpProvider.interceptors.push('intercepter');
    });
})(window);