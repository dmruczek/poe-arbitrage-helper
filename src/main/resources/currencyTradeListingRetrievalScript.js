var myData = [];

$('.displayoffer').each(function() {
   myData.push({
      'sellValue' : $(this).attr('data-sellvalue'),
      'buyValue' : $(this).attr('data-buyvalue'),
      'sellCurrency' : $(this).attr('data-sellcurrency'),
      'buyCurrency' : $(this).attr('data-buycurrency')
   });
});

return myData;