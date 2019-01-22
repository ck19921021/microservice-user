window.onload = function() {
	
	var page = 1
	var rows = 10
	var id = ''
	var uuid = ''
	var phone = ''
	var optType = -1
	
	var vm = new Vue({
		el: '#app',
		data: {
			sites: [],
			page: 1,
			totalPage: 1
		},
		mounted: function() {
			this.get(1);
		},
		methods: {
			get: function(page) {
				//发送get请求
				this.$http.post(search, {
					"page": page,
					"rows": rows,
					"id": id,
					"uuid": uuid,
					"phone": phone,
					"optType": optType,
				}).then(function(res) {
					this.$data.sites = res.body.page1
					this.$data.page = res.body.page1.page
					this.$data.totalPage = res.body.page1.totalPage
					//					console.log(res.body.page1);
				}, function() {
					console.log('请求失败处理');
				});
			},
			btnClick: function(data) { //页码点击事件
				if(data != this.page) {
					this.page = data
				}
				this.get(data);
				document.body.scrollTop = document.documentElement.scrollTop = 0;
			},
			pageClick: function() {
				this.get(this.page);
				document.body.scrollTop = document.documentElement.scrollTop = 0;
			}
		},
		computed: {
			indexs: function() {
				var left = 1;
				var right = this.$data.totalPage;
				var ar = [];
				if(this.$data.totalPage >= 5) {
					if(this.$data.page > 3 && this.$data.page < this.$data.totalPage - 2) {
						left = this.$data.page - 2
						right = this.$data.page + 2
					} else {
						if(this.$data.page <= 3) {
							left = 1
							right = 5
						} else {
							right = this.$data.totalPage
							left = this.$data.totalPage - 4
						}
					}
				}
				while(left <= right) {
					ar.push(left)
					left++
				}
				return ar
			}

		}
	});
}