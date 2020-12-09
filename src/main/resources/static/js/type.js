String.prototype.startWith = function(str) {
	var reg = new RegExp("^" + str);
	return reg.test(this);
}

function initTypeSelects(garderId,subjectId,semesterId,shiftsId,phaseId,chapterId) {
	$.ajax({
		type : 'get',
		url : '/types/all',
		contentType : "application/json; charset=utf-8",
		// data : JSON.stringify(formdata),
		async : false,
		success : function(data) {
			if (data.length > 0) {
				var gardeOption = '';
				var subjectOption = '';
				var semesterOption = '';
				var shiftsOption = '';
				var phaseOption = '';
				var chapterOption = '';
				for (var i = 0; i < data.length; i++) {
					if (data[i].superCode && data[i].superCode.startWith('0')
							&& data[i].code.length == 3) {
						gardeOption += "<option value=" + data[i].code + ">"
								+ data[i].name + "</option>"
					}
					if (data[i].superCode == '1') {// 学科
						subjectOption += "<option value=" + data[i].code + ">"
								+ data[i].name + "</option>"
					}
					if (data[i].superCode && data[i].superCode.startWith('2')) {
						semesterOption += "<option value=" + data[i].code + ">"
						+ data[i].name + "</option>"
					}
					if (data[i].superCode == '3') {
						shiftsOption += "<option value=" + data[i].code + ">"
						+ data[i].name + "</option>"
					}
					if (data[i].superCode == '4') {
						phaseOption += "<option value=" + data[i].code + ">"
						+ data[i].name + "</option>"
					}
					if (data[i].superCode == '5') {
						chapterOption += "<option value=" + data[i].code + ">"
						+ data[i].name + "</option>"
					}
				}
				if (garderId) {
					$('#' + garderId).append($(gardeOption));
				}
				if(subjectId){
					$('#' + subjectId).append($(subjectOption));
				}
				if(semesterId){
					$('#' + semesterId).append($(semesterOption));
				}
				if(shiftsId){
					$('#' + shiftsId).append($(shiftsOption));
				}
				if(phaseId){
					$('#' + phaseId).append($(phaseOption));
				}
				if(chapterId){
					$('#' + chapterId).append($(chapterOption));
				}
			}
		}
	});
}

function allTypeDict(){
	var v = sessionStorage["typeDict"];
	if(v == null || v == ""){
		$.ajax({
			type : 'get',
			url : '/types/all',
			contentType : "application/json; charset=utf-8",
			// data : JSON.stringify(formdata),
			async : false,
			success : function(data) {
				if (data && data.length > 0) {
					var typeDict = {};
					for(var i=0;i<data.length;i++){
						typeDict[data[i].code] = data[i].name;
					}
					sessionStorage["typeDict"] = JSON.stringify(typeDict);
				}
			}
		});
	}

	return JSON.parse(sessionStorage["typeDict"]);;
}