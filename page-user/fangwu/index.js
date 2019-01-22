window.onload = function() {
	var page = 1
	var rows = 10
	var uuid = ''
	var phone = ''
	var useStatus = -1
	var updateStatus = -1
	var vm = new Vue({
		el: '#app',
		data: {
			sites: [],
			page: 1,
			totalPage: 1,
		},
		mounted: function() {
			this.get(1);
		},
		methods: {
			get: function(page) {
				//发送get请求
				var params = Qs.stringify({
					"token":"1",
					"page": page,
					"rows": rows,
				})

				this.$http.post(list, params, {
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					}
				}).then(function(res) {
					this.$data.sites = res.body.page1
					this.$data.totalPage = res.body.page1.totalPage
				}, function() {
					console.log('请求失败处理');
				});

				//				return new Promise((resolve, reject) => {
				//					axios.post(list, params)
				//						.then((res) => {
				//							resolve(res.data);
				//							this.$data.sites = res.data.page1
				//							this.$data.totalPage = res.data.page1.totalPage
				//						})
				//						.catch(function(error) {
				//							reject(error);
				//							console.log(error);
				//						});
				//				});

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