  $(document).ready(function () {
   
           
            $("body").css({"overflow-y": "hidden"});

            var alto = $(window).height();

            $("body").append("<div id='pre-load-web'><div id='imagen-load'><img src='resources/img/load.gif'  /><br /></div>");

            $("#pre-load-web").css({height: alto + "px"});

            $("#imagen-load").css({"margin-top": (alto / 2) - 30 + "px"});
 

});
 
 

        $(window).load(function(){
           $("#pre-load-web").fadeOut(1000,function()
           { 
                       
               $(this).remove();
  
               $("body").css({"overflow-y":"auto"}); 

           });        
        });