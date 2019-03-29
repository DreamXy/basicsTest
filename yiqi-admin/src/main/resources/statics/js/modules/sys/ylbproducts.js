$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/ylbproducts/list',
        datatype: "json",
        colModel: [			
			{ label: 'pid', name: 'pid', index: 'pid', width: 50, key: true },
			{ label: '', name: 'cateid', index: 'cateid', width: 80 }, 			
			{ label: '', name: 'storeid', index: 'storeid', width: 80 }, 			
			{ label: '', name: 'name', index: 'name', width: 80 }, 			
			{ label: '', name: 'shopprice', index: 'shopprice', width: 80 }, 			
			{ label: '', name: 'state', index: 'state', width: 80 }, 			
			{ label: '', name: 'ishot', index: 'ishot', width: 80 }, 			
			{ label: '', name: 'showimg', index: 'showimg', width: 80 }, 			
			{ label: '', name: 'salecount', index: 'salecount', width: 80 }, 			
			{ label: '', name: 'visitcount', index: 'visitcount', width: 80 }, 			
			{ label: '', name: 'reviewcount', index: 'reviewcount', width: 80 }, 			
			{ label: '', name: 'addtime', index: 'addtime', width: 80 }, 			
			{ label: '', name: 'costprice', index: 'costprice', width: 80 }, 			
			{ label: '', name: 'marketprice', index: 'marketprice', width: 80 }, 			
			{ label: '', name: 'displayorder', index: 'displayorder', width: 80 }			
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