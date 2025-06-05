
$(document).ready(function(){
    $('.category').change(function(){
        if ($(this).val() === 'decor') {
            if ($(this).is(':checked')) {
                $('.decor-products').slideDown();
            } else {
                $('.decor-products').slideUp();
            }
        }
    });
});
