/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function() {
    $('#MainMenu > li').click(function(e) {
        e.stopPropagation();
        var $el = $('ul',this);
        $('#MainMenu > li > ul').not($el).slideUp();
        $el.stop(true, true).slideToggle(400);
    });
        $('#MainMenu > li > ul > li').click(function(e) {
        e.stopImmediatePropagation();  
    });
});


