   function updateBackground() {
                        screenWidth = $(window).width();
                        screenHeight = $(window).height();
                        var bg = jQuery("#bg");
                        var iframe = jQuery("#iframe-custom");
                        var submenu = jQuery(".submenu");
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
                         $(submenu).css('height',(screenHeight/3)); 
                           $(font).css('font-size',(screenHeight/40)); 
                          
                        }
    $(document).ready(function() {
                                // Actualizamos el fondo al cargar la pagina
                                updateBackground();
                                $(window).bind("resize", function() {
                                // Y tambien cada vez que se redimensione el navegador
                                updateBackground();
                                
                                });
                                
                                 
                        });
 
                        
