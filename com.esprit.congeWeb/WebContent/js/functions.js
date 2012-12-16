function min_stat(type)
{
	params = 'type='+type;
	var myAjax = new Ajax.Updater(type, 'includes/mini_stat.php', {
			method:'post',
			parameters:params,
			onLoading: function() {$(type).innerHTML = '<img src="images/loader.gif" />';}
		}
	);
}

function tirage(tirage)
{
	if($('content_'+tirage).innerHTML == '')
	{
		params = 'tirage='+tirage;
		var myAjax = new Ajax.Updater('content_'+tirage, 'includes/tirage_info.php', {
				method:'post',
				parameters:params,
				onLoading: function() {$('content_'+tirage).innerHTML = '<img src="images/loader.gif" />';}
			}
		);
	}
}

function stat_day(i,date,stat)
{
	if($('content_'+i).innerHTML == '')
	{
		params = 'i='+i+'&date='+date;
		var myAjax = new Ajax.Updater('content_'+i, 'includes/stat_day'+stat+'.php', {
				method:'post',
				parameters:params,
				onLoading: function() {$('content_'+i).innerHTML = '<img src="images/loader.gif" />';}
			}
		);
	}
}

function stat_day2(i,date)
{
	if($('content_'+i).innerHTML == '')
	{
		params = 'i='+i+'&date='+date;
		var myAjax = new Ajax.Updater('content_'+i, 'includes/stat_day2.php', {
				method:'post',
				parameters:params,
				onLoading: function() {$('content_'+i).innerHTML = '<img src="images/loader.gif" />';}
			}
		);
	}
}

function update_date(nom)
{
	$(nom).value = $('year_'+nom).value+'-'+$('month_'+nom).value+'-'+$('day_'+nom).value;
}

function update_date_time(nom)
{
	$(nom).value = $('year_'+nom).value+'-'+$('month_'+nom).value+'-'+$('day_'+nom).value+' '+ $('hour_'+nom).value+':'+$('minute_'+nom).value+':'+$('second_'+nom).value;
}

