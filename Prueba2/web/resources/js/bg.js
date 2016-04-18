   function updateBackground() {
                        screenWidth = $(window).width();
                        screenHeight = $(window).height();
                        var bg = jQuery("#bg");
                          var font = jQuery(".ca-icon");
                           var font2 = jQuery(".btn-img");
                             var font3 = jQuery(".c2");
                            var font4 = jQuery(".icon-menu"); 

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
                        
                         if (screenWidth < 1000) {
                              $(font4).css('font-size',(screenHeight/35)); 
                               $(font3).css('font-size',(screenHeight/40)); 
                        }else{
                              $(font4).css('font-size',30); 
                               $(font3).css('font-size',18); 
                        }
                     
                    
                     
                           $(font).css('font-size',(screenHeight/10)); 
                            $(font2).css('font-size',(screenHeight/35)); 
                           
                             
                          
                        }
                        
    $(document).ready(function () {
    
            updateBackground();
            $(window).bind("resize", function () {

                updateBackground();

            });
            
            
         

});
 
  