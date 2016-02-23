var height, width, setH;

function setFoot() {
    var bodyHeight = $("body>nav").height() + $("body>div.row").height() + 20 + $("#footDiv").height();
    if (height > bodyHeight) {
        $("#footDiv").addClass("footDiv");
    }else{
        $("#footDiv").removeClass("footDiv");
    }
    if (setH != 0) {
        if (height > setH && width > 974) {
            $("#footDiv").addClass("footDiv");
        }
        else {
            $("#footDiv").removeClass("footDiv");
        }
    }
}


function PlaceFoot(h) {
    //var width, height;
    width = $(window).width();
    height = $(window).height();
    setH = h;
    setFoot();

    $(window).resize(function () {
        width = $(this).width();
        height = $(this).height();
        setFoot();
    });

    
}