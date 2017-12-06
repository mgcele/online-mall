OnlineMallApp.factory('restApi', function ($resource) {
    return $resource(basePath + '/user/:first/:second/:third',
        {}, {
        getVC : {
            method : 'GET',
            params : {
                'first' : 'vc',
                'second' : '@second'
            },
            headers : {
                'Content-Type' : 'application/json'
            }
        }
    })
});