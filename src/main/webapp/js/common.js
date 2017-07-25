//编号转换为文本
function valueToText(array,value){
		array=array.substring(1,(array.length-1));
		var sp=array.split(",");
		for(j=0;j<sp.length;j++){
			var k=sp[j].split("=","100");
			if($.trim((k[0]))==$.trim(value)){
				return k[1];
			}
		}
		return value;	
}
//日期格式化
function getLocalTime(nS) {  
    var date = new Date(nS);
    var year = date.getFullYear();
    var month = date.getMonth()+1;
    var day = date.getDate();
    return year+"-"+month+"-"+day;
} 
