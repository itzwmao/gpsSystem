//将form表单元素的值序列化成对象
function serializeObject(form,ignoreBlank){
	var o ={};
	$.each(form.serializeArray(),function(index){
		if(typeof(ignoreBlank) == 'undefined' || (ignoreBlank !=null &&ignoreBlank == false)){
			if(o[this['name']]){
				o[this['name']]=o[this['name']]+","+this['value'];
			}else{
				o[this['name']] = this['value'];
			}
		}else{
			if(this['value']!=null&&this['value']!=""){
				if(o[this['name']]){
					o[this['name']]=o[this['name']]+","+this['value'];
				}else{
					o[this['name']] = this['value'];
				}
			}
		}
	});
	return o;
};