/**
 * 网站首页
 */
var app = new Vue({
    el: '#app',
    data: {
        url: routerUrl,
        searchVal: '',
        isLogin: false,
        user: {},
        hotGroupList: [],
        saleTypeList: [],
        groupList: [],
        shopList: [],
        indexPage: 1,
        pageSize: 50,
        /*总页数*/
        pageCount: 1
    },
    methods: {
        search: function () {
            Ajx.get(routerUrl.get.searchResult + "/" + this.searchVal);
            VRouter(routerUrl.router.searchResult);
        },
        gotoUrl: function (url) {
            window.location.href = url;
        },
        /*注销*/
        logout: function () {
            Ajx.get(routerUrl.get.logout);
            /*返回登录页面*/
            VRouter(routerUrl.router.login);
        },
        /*跳转到对应的商品详情页*/
        routerToGroup: function (groupId) {
            Ajx.get(routerUrl.get.groupInfo + "/" + groupId);
            VRouter(routerUrl.router.groupInfo);
        },
        /*跳转到商家详情页*/
        goToShopInfo: function (shopid) {
            Ajx.get(routerUrl.get.shopInfo + "/" + shopid);
            VRouter(routerUrl.router.shopInfo);
        }
    },
    /*组件创建时的回调函数,在此完成数据的异步加载*/
    created: function () {
        /*并发请求*/
        axios.all([
            getLoginUser(),
            hotGroup(),
            getSaleType(),
            getIndexGroup(),
            groupListPageAccount(),
            getShopList()
        ]);
    },
    mounted: function () {

    }
});

/*获取登录的用户信息*/
function getLoginUser() {
    /*先获取Session的用户信息,不存在表示用户未登录*/
    return Ajx.get(routerUrl.get.userInfo).then(function (response) {
        if (response.data != undefined) {
            app.user = response.data;
            app.isLogin = true;
        }
    }).catch(function (error) {
        app.isLogin = false;
    });
}

/*获取用于滚动播放的热门团购*/
function hotGroup() {
    return Ajx.get(routerUrl.get.indexHotGroup).then(function (response) {
        response.data.forEach(function (group) {
            app.hotGroupList.push(group);
        });
    }).catch(function () {

    });
}

/*获取商品分类*/
function getSaleType() {
    return Ajx.get(routerUrl.get.saleTypeList).then(function (response) {
        response.data.forEach(function (type) {
            app.saleTypeList.push(type);
        })
    }).catch(function () {
        this.saleTypeList = [{id: '', name: ''}];
    });
}

/*获取团购列表*/
function getIndexGroup() {
    return Ajx.get(routerUrl.get.indexGroupList, {
        params: {
            page: 1,
            pageSize: 50
        }
    }).then(function (response) {
        response.data.forEach(function (group) {
            app.groupList.push(group);
        })
    });
}

/*获取总页码*/
function groupListPageAccount() {
    return Ajx.get(routerUrl.get.groupListPageAccount, {
        params: {
            pageSize: 50
        }
    }).then(function (response) {
        app.pageCount = response.data;
    })
}

/*获取推荐商家*/
function getShopList() {
    return Ajx.get(routerUrl.get.shopList, {
        params: {
            number: 4
        }
    }).then(function (response) {
        response.data.forEach(function (shop) {
            app.shopList.push(shop);
        })
    });
}