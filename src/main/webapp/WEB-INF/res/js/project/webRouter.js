/**
 * 定义前端页面与后端项目的映射路径
 * */
/*修改此变量以更改环境
* const env = 'prod';
* */
const env = 'prod';

/*页面跳转地址*/
const router_dev = {
    login: 'login.html',
    vipReg: 'vipReg.html',
    index: 'index.html',
    businessReg: 'businessReg.html',
    userZone: 'userZone.html',
    groupInfo: 'groupInfo.html',
    userOrder: 'userOrder.html',
    shopInfo: 'shopInfo.html',
    goodsInfo: 'goodsInfo.html',
    searchResult: 'searchResult.html',
    personOrder: 'PersonOrder.html'
}
const router_prod = {
    login: '/user/login',
    vipReg: '/user/vipReg',
    index: '/index',
    businessReg: '/user/businessReg',
    userZone: '/user/userZone',
    groupInfo: '/group/groupInfo',
    userOrder: '/user/userOrder',
    shopInfo: '/shop/shopInfo',
    goodsInfo: '/shop/goodsInfo',
    searchResult: '/searchGoods',
    personOrder: '/user/personOrder'
}

/*异步请求地址信息,开发环境与生产环境相同*/
const getReq = {
    saleTypeList: '/shop/saleTypeList',
    userInfo: '/user/userInfo',
    logout: '/user/logout',
    indexHotGroup: '/group/indexHotGroup',
    indexGroupList: '/group/indexGroupList',
    groupListPageAccount: '/group/groupListPageAccount',
    shopList: '/shop/getHotShop',
    shopInfo: '/shop/shopInfo',
    goodsInfo: '/shop/goodsInfo',
    searchResult: '/searchGoods'
};

const postReq = {
    userLogin: '/user/login',
    userVipReg: '/user/vipReg',
    businessReg: '/user/businessReg'
};


/*开发环境地址信息*/
const Url_dev = {
    ajaxUrl: 'http://127.0.0.1',
    router: router_dev,
    get: getReq,
    post: postReq,
    uploadUrl: 'http://127.0.0.1/fileUpload'
}
/*线上环境地址信息*/
const Url_prod = {
    ajaxUrl: 'http://127.0.0.1',
    uploadUrl: 'http://127.0.0.1/fileUpload',
    router: router_prod,
    get: getReq,
    post: postReq,
}

/*根据不同的环境获取不同的路径信息*/
function getRouterUrl() {
    switch (env) {
        case 'dev':
            return Url_dev;
        case 'prod':
            return Url_prod;
    }
}

var routerUrl = getRouterUrl();

/*进行页面跳转*/
function VRouter(url) {
    window.location.href = url;
}

/**
 * 以下是axios的配置
 * */
var Ajx = axios.create({
    baseURL: routerUrl.ajaxUrl,
    timeout: 30000,
    responseType: 'json',
    header: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
    },
    /*设置该属性后可以使每次的请求使用相同的SessionID*/
    withCredentials: true
});
//添加一个请求拦截器
/*
Ajx.interceptors.request.use(function(config){
    return config;
},function(err){
    //Do something with request error
    return Promise.reject(error);
});*/