   function updateBackground() {
                        screenWidth = $(window).width();
                        screenHeight = $(window).height();
                        var bg = jQuery("#bg");
                        var iframe = jQuery("#iframe-custom");
                        var submenu = jQuery(".submenu");
                          var submenu2 = jQuery(".submenu2");
                           var submenu3 = jQuery(".submenu3");
                          var font = jQuery(".btn-img");

                        // Proporcion horizontal/vertical. En este caso la imagen es cuadrada
                        ratio = 1;

                                if (screenWidth/screenHeight > ratio) {
                                    $(bg).height("auto");
                                    $(bg).width("100%");
                                } else {
                                    $(bg).width("auto");
                                    $(bg).height("100%");
                                }

                        // Si a la imagen le sobra anchura, la centramos a mano
                        if ($(bg).width() > 0) {
                              $(bg).css('left', (screenWidth - $(bg).width()) / 2);
                        }
                         $(iframe).css('height',(screenHeight)); 
                         $(submenu).css('height',(screenHeight/2)); 
                           $(submenu2).css('height',(screenHeight/2)); 
                            $(submenu3).css('height',(screenHeight)); 
                           $(font).css('font-size',(screenHeight/40)); 
                          
                        }
    $(document).ready(function () {
    
            updateBackground();
            $(window).bind("resize", function () {

                updateBackground();

            });
            
            
            

            $("body").css({"overflow-y": "hidden"});

            var alto = $(window).height();

            $("body").append("<div id='pre-load-web'><div id='imagen-load'><img src='http://preloaders.net/preloaders/359/Filling%20circles.gif'  /><br />Cargando...</div>");

            $("#pre-load-web").css({height: alto + "px"});

            $("#imagen-load").css({"margin-top": (alto / 2) - 30 + "px"});


});
 
 

        $(window).load(function(){
           $("#pre-load-web").fadeOut(2000,function()
           { 
            
               $(this).remove();
  
               $("body").css({"overflow-y":"auto"}); 

           });        
        }); 