$(function() {
	$("#jqGrid")
			.jqGrid(
					{
						url : baseURL + 'sys/sysadvertisingimg/list',
						datatype : "json",
						colModel : [
								{
									label : '图片ID',
									name : 'id',
									index : 'id',
									width : 50,
									key : true
								},
								{
									label : '图片内容',
									name : 'imgsrc',
									width : 80
								},
								{
									label : '图片跳转地址',
									name : 'imgurl',
									width : 80
								},
								{
									label : '图片位置',
									name : 'imgtype',
									width : 80,formatter : function(value, options, row) {
										return value == 0 ? '<span class="label label-danger">首页顶部</span>' :'<span class="label label-success">首页底部</span>';
									}
								},
								{
									label : '图片顺序',
									name : 'imgsequence',
									width : 80
									
								}, {
									label : '上线时间',
									name : 'createDate',
									index : 'create_date',
									width : 80
								} ],
						viewrecords : true,
						height : 385,
						rowNum : 10,
						rowList : [ 10, 30, 50 ],
						rownumbers : true,
						rownumWidth : 25,
						autowidth : true,
						multiselect : true,
						pager : "#jqGridPager",
						jsonReader : {
							root : "page.list",
							page : "page.currPage",
							total : "page.totalPage",
							records : "page.totalCount"
						},
						prmNames : {
							page : "page",
							rows : "limit",
							order : "order"
						},
						gridComplete : function() {
							// 隐藏grid底部滚动条
							$("#jqGrid").closest(".ui-jqgrid-bdiv").css({
								"overflow-x" : "hidden"
							});
						}
					});
});

var vm = new Vue(
		{
			el : '#rrapp',
			data : {
				showList : true,
				title : null,
				sysAdvertisingImg : {}
			},

			methods : {
				query : function() {
					vm.reload();
				},
				add : function() {
					vm.showList = false;
					vm.title = "新增";
					vm.sysAdvertisingImg = {};
				},
				update : function(event) {
					var id = getSelectedRow();
					if (id == null) {
						return;
					}
					vm.showList = false;
					vm.title = "修改";

					vm.getInfo(id)
				},
				saveOrUpdate : function(event) {
					var url = vm.sysAdvertisingImg.id == null ? "sys/sysadvertisingimg/save"
							: "sys/sysadvertisingimg/update";
					$.ajax({
						type : "POST",
						url : baseURL + url,
						contentType : "application/json",
						data : JSON.stringify(vm.sysAdvertisingImg),
						success : function(r) {
							if (r.code === 0) {
								alert('操作成功', function(index) {
									vm.reload();
								});
							} else {
								alert(r.msg);
							}
						}
					});
				},
				del : function(event) {
					var ids = getSelectedRows();
					if (ids == null) {
						return;
					}

					confirm('确定要删除选中的记录？', function() {
						$.ajax({
							type : "POST",
							url : baseURL + "sys/sysadvertisingimg/delete",
							contentType : "application/json",
							data : JSON.stringify(ids),
							success : function(r) {
								if (r.code == 0) {
									alert('操作成功', function(index) {
										$("#jqGrid").trigger("reloadGrid");
									});
								} else {
									alert(r.msg);
								}
							}
						});
					});
				},
				getInfo : function(id) {
					$.get(baseURL + "sys/sysadvertisingimg/info/" + id,
							function(r) {
								vm.sysAdvertisingImg = r.sysAdvertisingImg;
							});
				},
				reload : function(event) {
					vm.showList = true;
					var page = $("#jqGrid").jqGrid('getGridParam', 'page');
					$("#jqGrid").jqGrid('setGridParam', {
						page : page
					}).trigger("reloadGrid");
				}
			}
		});


function setImg(obj) {
	var f = $(obj).val();
	alert(f);
	console.log(obj);
	if (f == null || f == undefined || f == '') {
		return false;
	}
	if (!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f)) {
		alert("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
		$(obj).val('');
		return false;
	}
	var data = new FormData();
	console.log(data);
	$.each($(obj)[0].files, function(i, file) {
		data.append('file', file);
	});
	console.log(data);
	$.ajax({
		type : "POST",
		url : baseURL + "sys/sysadvertisingimg/uploadImg.xhtml",
		data : data,
		cache : false,
		contentType : false, // 不可缺
		processData : false, // 不可缺
		dataType : "json",
		success : function(ret) {
			console.log(ret);
			if (ret.code == 0) {
				
				vm.sysAdvertisingImg.imgsrc = ret.result.url;
				// $("#photourlShow").attr("src",ret.result.url);//显示图片
				alert(ret.message);
			} else {
				alert(ret.message);
				$("#url").val("");
				$(obj).val('');
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("上传失败，请检查网络后重试");
		}
	});

}
