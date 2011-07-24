<%@include file="include/include.jsp" %>
<h1>View Albums</h1>
<p id="pics"></p>
<script type="text/javascript">
var pics = [{}] ;
pics.push(${photos}) ;
for(a=1; a<pics.length;a++){
	for(b=0; b<pics[a].albums.length; b++){
		$("#pics").append("<h3 id='album'>"+pics[a].albums[b].title+"</h3><br />") ;
		for(c=0; c<pics[a].albums[b].photos.length; c++){
			$("#pics").append("<a rel='shadowbox["+pics[a].albums[b].title+"]' href='"+pics[a].albums[b].photos[c].src+"' title='"+pics[a].albums[b].photos[c].caption+"'><img alt='' src='"+pics[a].albums[b].photos[c].thumbnail+"' /></a>&nbsp;&nbsp;") ;
		}
	}
}
</script>