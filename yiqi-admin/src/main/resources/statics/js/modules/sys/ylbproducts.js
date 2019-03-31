$(function () {
	//, 			{ label: '', name: 'displayorder', index: 'displayorder', width: 80 }
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/ylbproducts/list',
        datatype: "json",
        colModel: [			
			{ label: '商品id', name: 'pid', index: 'pid', width: 50, key: true },
			{ label: '分类id', name: 'cateid', index: 'cateid', width: 80 }, 			
			{ label: '商铺id', name: 'storeid', index: 'storeid', width: 80 }, 			
			{ label: '名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '商城价', name: 'shopprice', index: 'shopprice', width: 80 }, 	
			{ label: '成本价', name: 'costprice', index: 'costprice', width: 80 }, 			
			{ label: '市场价', name: 'marketprice', index: 'marketprice', width: 80 }, 		
			{ label: '状态', name: 'state', index: 'state', width: 80 }, 			
			{ label: '是否为热销', name: 'ishot', index: 'ishot', width: 80 }, 			
			{ label: '主图', name: 'showimg', index: 'showimg', width: 80 }, 			
			{ label: '销售数量', name: 'salecount', index: 'salecount', width: 80 }, 			
			{ label: '访问数量', name: 'visitcount', index: 'visitcount', width: 80 }, 			
			{ label: '评价数量', name: 'reviewcount', index: 'reviewcount', width: 80 }, 			
			{ label: '添加时间', name: 'addtime', index: 'addtime', width: 80 }		
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条	
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		ylbProducts: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.ylbProducts = {};
		},
		update: function (event) {
			var pid = getSelectedRow();
			if(pid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(pid)
		},
		saveOrUpdate: function (event) {
			var url = vm.ylbProducts.pid == null ? "sys/ylbproducts/save" : "sys/ylbproducts/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.ylbProducts),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var pids = getSelectedRows();
			if(pids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/ylbproducts/delete",
                    contentType: "application/json",
				    data: JSON.stringify(pids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(pid){
			$.get(baseURL + "sys/ylbproducts/info/"+pid, function(r){
                vm.ylbProducts = r.ylbProducts;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});



function setImg(obj) {
	var f = $(obj).val();
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
				
				vm.ylbProducts.showimg = ret.result.url;
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