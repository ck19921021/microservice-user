window.onload = function() {

	// 使用由库提供的配置的默认值来创建实例
	// 此时超时配置的默认值是 `0`
	var instance = axios.create();

	instance.defaults.timeout = 6000;

	var vm = new Vue({
		el: '#app',
		data: {
			errors: [],
			name: null,
		},
		mounted: function() {},
		methods: {
			submitForm: function(e) {
				if(this.name) {
					var params = Qs.stringify({
						name: this.name
					})
					instance.post(add, params)
						.then(function(response) {
							console.log(response.data);
							mui.toast("success");
						})
						.catch(function(error) {
							console.log(error);
						});
					return true;
				}

				this.errors = []

				if(!this.name) {
					this.errors.push('角色名称不能为空!');
					mui.toast(this.errors);
				}

				e.preventDefault();

			},
			onValid: function() {
				console.log("valid事件触发了");
			}
		},

	});
}