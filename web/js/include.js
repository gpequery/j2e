$j(document).ready(function () {
    /* SYNCHRONE SCRIPTS */
    $j.ajaxSetup({async: false});
    $j.getScript("/js/boostrap/bootstrap.min.js").done(function (script, textStatus) {
        console.info("LOAD bootstrap.js \t--> " +  textStatus);
    });

    $j.getScript("/js/jquery/jquery-ui.min.js").done(function (script, textStatus) {
        console.info("LOAD jquery-ui.js \t--> " +  textStatus);
    });
    $j.ajaxSetup({async: true});

    /* ASYNCHRONE SCRIPTS */
    $j.getScript("/js/home.js").done(function (script, textStatus) {
        console.info("LOAD home.js \t\t--> " +  textStatus);
    });

});