$("a[data-go-link]").each(function(index,atag){
		const contextPath = $("body").data("contextPath")
		console.log(contextPath)
		let fullUrl=contextPath + $(atag).data("goLink")
		$(atag).attr("href", fullUrl);
	});