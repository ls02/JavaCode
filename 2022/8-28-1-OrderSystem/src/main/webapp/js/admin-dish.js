var app = new Vue({
    el: '.center',
    data: {
        // 当前登录用户的用户名, 为空字符串表示未登录状态
        name: "",
        id: "",
        // 是否显示新增菜品对话框
        showAddDishDialog: false,
        showSetDish: false,
        // 新增菜品的信息
        newDish: {
            name: "",
            price: 0,
        },
        newDishId: {
            name: "",
            price: "",
        },
        // 当前的菜品列表
        dishes: [
            // {
            //     dishId: 1,
            //     name: '京酱肉丝',
            //     price: 2000,
            //     isSelected: null,
            // },
            // {
            //     dishId: 2,
            //     name: '宫保鸡丁',
            //     price: 1800,
            //     isSelected: null,
            // },
            // {
            //     dishId: 3,
            //     name: '红烧肉',
            //     price: 2500,
            //     isSelected: null,
            // },
        ],
    },
    methods: {
        // 判定当前是否登录
        isLogin() {
            if (this.name == "") {
                return false;
            }
            return true;
        },
        // 从服务器检测登录状态
        checkLogin() {
            // 页面最初加载时先访问服务器判定自身的登陆状态. 
            console.log("checkLogin");
            $.ajax({
                url: 'login',
                type: 'get',
                success: function (data, status) {
                    if (data.ok != 1) {
                        return;
                    }
                    // 登录成功后
                    // 1. 设置用户名
                    app.name = data.name;
                    // 2. 获取菜品列表
                    app.getDishes();
                }
            });
        },
        deleteDish(dishId) {
            console.log("deleteDish");
            $.ajax({
                type: 'delete',
                url: 'dish?dishId=' + dishId,
                success: function (data, status) {
                    if (data.ok != 1) {
                        alert("删除菜品失败! 该菜品已经被其他订单使用!");
                        return;
                    }
                    app.getDishes();
                    alert("删除菜品成功!");
                }
            })
        },
        modifyDish() {
            console.log("modifyDish");
            $.ajax({
                type: 'put',
                url: 'dish?dishId=' + this.id,
                data: JSON.stringify(app.newDishId),
                success: function (data, status) {
                    if (data.ok != 1) {
                        alert("修改失败!" + data.reason);
                        return;
                    }
                    app.showSetDish = false;
                    app.newDishId = {};
                    window.location.href = "admin-dish.html";
                }
            })
        },
        addDish() {
            console.log("addDish");
            $.ajax({
                type: 'post',
                url: 'dish',
                data: JSON.stringify(app.newDish),
                success: function (data, status) {
                    if (data.ok != 1) {
                        alert("新增菜品失败! " + data.reason);
                        return;
                    }
                    app.getDishes();
                    alert("新增菜品成功!");
                    app.showAddDishDialog = false;
                    app.newDish = {};
                }
            })
        },
        // 获取菜品信息
        getDishes() {
            // 获取菜品信息
            console.log("getDishes");
            $.ajax({
                url: 'dish',
                type: 'get',
                success: function (data, status) {
                    app.dishes = data;
                }
            })
        },
        logout() {
            this.name = "";
            window.location.href = "login.html";
        },
        setDishId(dishId) {
            this.id = dishId;
        }
    }
});