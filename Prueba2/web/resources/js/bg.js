   function updateBackground() {
                        screenWidth = $(window).width();
                        screenHeight = $(window).height();
                        var bg = jQuery("#bg");
                          var font = jQuery(".ca-icon");
                           var font2 = jQuery(".btn-img");

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
                        
                       
                    
                     
                            $(font).css('font-size',(screenHeight/10)); 
                            $(font2).css('font-size',(screenHeight/35)); 
                            
                            $(font2).css('font-size',(screenHeight/35)); 
                            
                            $(font2).hover(
                                function() {
                                  $( this ).css('font-size',(screenHeight/35)+1 );
                                }, function() {
                                  $( this ).css('font-size',(screenHeight/35) );
                                }
                              );
                            
                            $(font2).hover();
                           
                             
                          
                        }
                        
    $(document).ready(function () {
    
            updateBackground();
            $(window).bind("resize", function () {

                updateBackground();

            });
            
            
         

});
 
  