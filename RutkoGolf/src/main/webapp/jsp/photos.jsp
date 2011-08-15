<%@include file="include/include.jsp" %>
<h1>View Albums</h1>
<p>(click album to expand)</p>
<p id="pics"></p>
<script type="text/javascript">
var pics = [{}] ;
var albumlen = 0;
pics.push(${photos}) ;
for(a=1; a<pics.length;a++){
	for(b=0; b<pics[a].albums.length; b++){
		$("#pics").append("<h4 id='album"+b+"' style='cursor:pointer;'>&nbsp;&nbsp;<span id='albumtog"+b+"'></span>"+pics[a].albums[b].title+"</h4><br /><div id='albumpic"+b+"'>") ;
		for(c=0; c<pics[a].albums[b].photos.length; c++){
			$("#albumpic"+b).append("<a rel='shadowbox["+pics[a].albums[b].title+"]' href='"+pics[a].albums[b].photos[c].src+"' title='"+pics[a].albums[b].photos[c].caption+"'><img style='padding:3px; border:1px solid #fff; height:50px; width:50px;' alt='' src='"+pics[a].albums[b].photos[c].thumbnail+"' /></a>") ;
		}
		$("#pics").append("</div>") ;
	}
}
var albumcnt = [] ;
for(d=0; d<b; d++){
	albumcnt.push(d) ;
}
$.each(albumcnt, function(index, value){
	$('#albumpic'+value).hide() ;
	$('#albumtog'+value).html("+ ") ;
	$('#album'+value).click(function(){
		$('#albumpic'+value).slideToggle(100, function(){
			var ah = $('#albumpic'+value).height() ;
			var right = $('#right').height() ;
			if($("#albumpic"+value).css('display') === 'block'){
				$('#content').height(ah+120) ;
				$('#albumtog'+value).html("- ") ;
			}else{
				$('#content').height(right+50) ;
				$('#albumtog'+value).html("+ ") ;
			}
		}) ;
	}) ;	
}) ;

</script>