   function updateBackground() {
                        screenWidth = $(window).width();
                        screenHeight = $(window).height();
                        var bg = jQuery("#bg");
                        //var sign = jQuery("#sign");
                        // var sign2 = jQuery("#sign2");
                       // var reg = jQuery(".reg");

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
                        //$(sign).css('top',(screenHeight/3)).css('left',(screenWidth/3));
                         // $(sign2).css('top',(screenHeight/3)).css('left',(screenWidth/3));
                         //$(reg).css('top',(screenHeight/3.4));
                          
                        }
    $(document).ready(function() {
                                // Actualizamos el fondo al cargar la pagina
                                updateBackground();
                                $(window).bind("resize", function() {
                                // Y tambien cada vez que se redimensione el navegador
                                updateBackground();
                                });
                                
                                 
                        });
                        
