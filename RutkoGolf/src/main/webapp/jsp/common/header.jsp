<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="/js/shadowbox/shadowbox.css">
<script type="text/javascript" src="/js/shadowbox/shadowbox.js"></script>
<script type="text/javascript">
	Shadowbox.init({
		handleOversize: "resize",
	  counterType: "skip"
	});
	$(document).ready(function(){
		var left = $('#left').height() ;
		var right = $('#right').height() ;
		if(left > right){
			$('#content').height(left+50) ;
		}else{
			$('#content').height(right+50) ;
		}
	}) ;
</script>
<div class="gradient">
<h1><span></span>DRIVE FOR THE CURE!</h1>
</div>