OnlineMallApp.factory("restApi", function ($resource) {
    return $resource(basePath + "/:first", {}, {
        getVC : {
            method : 'GET',
            params : {
                'first' : 'VC'
            },
            headers : {
                'Content-Type' : 'application/json'
            }
        }
    })
});